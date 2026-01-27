plugins {
    id("patidost.android.application")
    id("patidost.android.compose")
    id("patidost.android.hilt")
}

// ANAYASAL KİLİT MEKANİZMASI (v2 - Configuration Cache Uyumlu)
// Anayasal Dayanak: ANAYASAL_EK_PROTOKOL §II, Denetçi-1 ve Denetçi-2 Direktifleri
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
        if (!icraEnvanteri.get().asFile.exists()) {
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

// Kural: Zorunlu Bağlanırlık (Pre-Build Hook)
tasks.named("preBuild") {
    dependsOn(checkConstitutionalCompliance)
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
