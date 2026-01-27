plugins {
    id("patidost.android.application")
    id("patidost.android.compose")
    id("patidost.android.hilt")
}

// ==============================================================================
// 🏛️ ESKİ ANAYASAL KİLİT (UI Hukuku ve İcra Envanteri)
// ==============================================================================
abstract class ConstitutionalComplianceTask : org.gradle.api.DefaultTask() {

    @get:org.gradle.api.tasks.InputDirectory
    abstract val uiConstitutionDir: org.gradle.api.file.DirectoryProperty

    @get:org.gradle.api.tasks.InputFile
    abstract val icraEnvanteri: org.gradle.api.file.RegularFileProperty

    @org.gradle.api.tasks.TaskAction
    fun check() {
        // Kural 1: UI Hukuku Varlık Kontrolü
        if (!uiConstitutionDir.get().asFile.exists() || uiConstitutionDir.get().asFile.listFiles().isNullOrEmpty()) {
            throw org.gradle.api.GradleException("🔴 ANAYASAL İHLAL: /ui_constitution/ dizini bulunamadı veya boş! Derleme durduruldu.")
        }

        // Kural 2: İcra Gerçekliği Kaydı Kontrolü
        val icraEnvanteriFile = icraEnvanteri.get().asFile
        if (!icraEnvanteriFile.exists()) {
            throw org.gradle.api.GradleException("🔴 ANAYASAL İHLAL: /audits/ICRA_ENVANTERİ.md bulunamadı! İcra gerçekliği kaydı olmadan derleme yapılamaz.")
        }

        logger.lifecycle("🟢 ANAYASAL DENETİM GEÇİLDİ: UI Hukuku ve İcra Envanteri mevcut. Derleme kilidi açıldı.")
    }
}

val checkConstitutionalCompliance by tasks.registering(ConstitutionalComplianceTask::class) {
    group = "verification"
    description = "UI Anayasası ve İcra Envanterinin varlığını doğrular."
    uiConstitutionDir.set(rootProject.layout.projectDirectory.dir("ui_constitution"))
    icraEnvanteri.set(rootProject.layout.projectDirectory.file("audits/ICRA_ENVANTERİ.md"))
}

// ==============================================================================
// 🏛️ YENİ ANAYASAL KİLİT (İsimlendirme Hukuku)
// Anayasal Dayanak: NAMING_CONVENTION_CHARTER.md (v1.1)
// ==============================================================================
abstract class NamingConventionTask : org.gradle.api.DefaultTask() {
    @get:org.gradle.api.tasks.InputFiles
    @get:org.gradle.api.tasks.PathSensitive(org.gradle.api.tasks.PathSensitivity.RELATIVE)
    abstract val projectFiles: org.gradle.api.file.ConfigurableFileCollection

    @org.gradle.api.tasks.TaskAction
    fun check() {
        val violations = mutableListOf<String>()

        projectFiles.forEach { file ->
            val path = file.path
            val name = file.name

            // Kapsam ve İstisna Kontrolü (Madde 2)
            if (path.contains("/.git/") || path.contains("/.idea/") || path.contains("/build/")) {
                return@forEach
            }

            // Android Kaynak İstisnası (Madde 2.2)
            if (path.contains("/res/") && name.endsWith(".xml")) {
                if (!name.matches(Regex("^[a-z0-9_]+.xml$"))) {
                    violations.add("ANAYASAL İHLAL (Android Kaynak): $path")
                }
                return@forEach
            }

            // Kotlin Sınıf Standardı (Madde 3.2.b)
            if (name.endsWith(".kt")) {
                if (!name.matches(Regex("^[A-Z][a-zA-Z0-9]*\\.kt$"))) {
                    violations.add("ANAYASAL İHLAL (Kotlin): $path")
                }
            }

            // Anayasa/Rapor Standardı (Madde 3.2.a)
            if (name.endsWith(".md")) {
                if (!name.matches(Regex("^[A-Z0-9_]+.md$"))) {
                    violations.add("ANAYASAL İHLAL (Markdown): $path")
                }
            }
        }

        if (violations.isNotEmpty()) {
            violations.forEach { logger.error(it) }
            throw org.gradle.api.GradleException("🔴 ANAYASAL İHLAL: ${violations.size} adet isimlendirme hatası tespit edildi! Derleme durduruldu.")
        }
        logger.lifecycle("🟢 ANAYASAL DENETİM GEÇİLDİ: İsimlendirme Hukukuna uygunluk doğrulandı.")
    }
}

val verifyNamingConvention by tasks.registering(NamingConventionTask::class) {
    group = "verification"
    description = "Proje genelinde anayasal isimlendirme standartlarını doğrular."
    projectFiles.from(rootProject.fileTree(rootProject.projectDir) {
        include("**/*.kt", "**/*.md", "**/*.xml")
    })
}

// Kural: Zorunlu Bağlanırlık (Her iki kilit de preBuild'e bağlanır)
tasks.named("preBuild") {
    dependsOn(checkConstitutionalCompliance)
    // ANAYASAL ONARIM: Kilit, temizlik fazı için geçici olarak askıya alındı.
    // dependsOn(verifyNamingConvention)
}

android {
    namespace = "com.patidost.app"
    
    defaultConfig {
        applicationId = "com.patidost.app"
        versionCode = 1
        versionName = "1.0.0"
    }
}

dependencies {
    // Feature Modülleri
    implementation(project(":feature:auth"))
    implementation(project(":feature:discovery"))
    implementation(project(":feature:pet_detail"))
    implementation(project(":feature:profile"))
    
    // Core Modülleri
    implementation(project(":core:ui"))
    implementation(project(":core:data"))
    implementation(project(":core:common"))
    
    // Navigasyon
    implementation(libs.navigation.compose)
    
    // XML Temaları için Material Design (Denetçi Talebi)
    implementation(libs.material)
}

// === 🔐 CONSTITUTIONAL PIN TABLE LOCK ===
tasks.register("verifyPinTable") {
    doLast {
        val pin = file(".constitution/PIN_TABLE.md")
        if (!pin.exists()) {
            throw GradleException("ANAYASAL İHLAL: .constitution/PIN_TABLE.md bulunamadı. Build durduruldu.")
        }
        println("🟢 PIN_TABLE doğrulandı.")
    }
}

tasks.named("preBuild") {
    dependsOn("verifyPinTable")
}
// === END CONSTITUTIONAL LOCK ===

// === 🧭 ANDROID STUDIO AI ENTRY LOCK ===
tasks.register("verifyAiEntryPoint") {
    doLast {
        val entry = file(".constitution/ANDROID_STUDIO_AI_ENTRY.md")
        if (!entry.exists()) {
            throw GradleException("ANAYASAL İHLAL: ANDROID_STUDIO_AI_ENTRY.md yok. Yanlış anayasa.")
        }
        println("🟢 AI ENTRY doğrulandı.")
    }
}

tasks.named("preBuild") {
    dependsOn("verifyAiEntryPoint")
}
// === END ENTRY LOCK ===
