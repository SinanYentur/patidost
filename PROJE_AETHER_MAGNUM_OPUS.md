# PROJE AETHER v5.0 (MAGNUM OPUS) - NİHAİ FABRİKA ANAYASASI

**Tarih:** 2026-01-29
**Statü:** Kutsal Metin / Mutlak Anayasa
**Kapsam:** Altyapı, Güvenlik, Kalite, Yönetim, Kriz, Gelecek

---

## BÖLÜM 1: GİRİŞ VE VAROLUŞSAL HEDEF

**1.1 HEDEF: MÜHENDİSLİK MÜKEMMELLİĞİ**
"Hataların doğamayacağı fabrika", hatanın oluşabileceği uzay-zamanı ortadan kaldırmak üzerine kuruludur. Kodun yazıldığı ortam, kullanılan dilin kuralları ve üretim bandı öyle kilitlenir ki, hatalı bir kodun yazılması fiziksel olarak imkansız hale gelir.

**1.2 NEDEN "PROJE AETHER"?**
Nx (Chimera) yerine **Gradle Convention Plugins (Aether)** seçilmiştir. Çünkü Gradle, Android'in "kendi eti ve kemiği"dir. Sıfır maliyet, sıfır tercüme hatası ve %100 uyum için bu yol seçilmiştir.

---

## BÖLÜM 2: FABRİKA ZEMİNİ (FİZİKSEL HAZIRLIK)

**2.1 KLASÖR HİYERARŞİSİ**
*   `build-logic`: Anayasa Kulesi. Tüm kurallar burada kodlanır.
*   `gradle`: Merkezi Envanter. `libs.versions.toml` burada yaşar.
*   `config`: Güvenlik ve Kalite Karargahı. `detekt.yml` burada yaşar.

---

## BÖLÜM 3: MERKEZİ ENVANTER (`libs.versions.toml`)

Bu dosya, fabrikanın "Stok Takip Sistemi"dir. Tüm versiyonlar burada kilitlenir.

```toml
[versions]
agp = "8.2.2"
kotlin = "1.9.22"
coreKtx = "1.12.0"
junit = "4.13.2"
junitVersion = "1.1.5"
espressoCore = "3.5.1"
composeBom = "2023.08.00"
activityCompose = "1.8.2"
lifecycleRuntimeKtx = "2.7.0"
detekt = "1.23.5"
jacoco = "0.8.11"
semanticVersion = "2.0.0"
hilt = "2.50"
retrofit = "2.9.0"
okhttp = "4.12.0"
kotlinxSerialization = "1.6.2"
work = "2.9.0"
hiltWork = "1.2.0"
firebasePerf = "1.4.2"
firebasePerfLib = "20.5.2"
ossLicenses = "0.10.6"
dokka = "1.9.10"
playIntegrity = "1.3.0"

[libraries]
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
android-gradlePlugin = { group = "com.android.tools.build", name = "gradle", version.ref = "agp" }
kotlin-gradlePlugin = { group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version.ref = "kotlin" }
detekt-gradlePlugin = { group = "io.gitlab.arturbosch.detekt", name = "detekt-gradle-plugin", version.ref = "detekt" }
hilt-android = { group = "com.google.dagger", name = "hilt-android", version.ref = "hilt" }
hilt-compiler = { group = "com.google.dagger", name = "hilt-android-compiler", version.ref = "hilt" }
retrofit-core = { group = "com.squareup.retrofit2", name = "retrofit", version.ref = "retrofit" }
okhttp-logging = { group = "com.squareup.okhttp3", name = "logging-interceptor", version.ref = "okhttp" }
kotlinx-serialization-json = { group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-json", version.ref = "kotlinxSerialization" }
retrofit-kotlin-serialization = { group = "com.jakewharton.retrofit", name = "retrofit2-kotlinx-serialization-converter", version = "1.0.0" }
androidx-work-ktx = { group = "androidx.work", name = "work-runtime-ktx", version.ref = "work" }
androidx-hilt-work = { group = "androidx.hilt", name = "hilt-work", version.ref = "hiltWork" }
firebase-performance = { group = "com.google.firebase", name = "firebase-perf", version.ref = "firebasePerfLib" }
oss-licenses = { group = "com.google.android.gms", name = "play-services-oss-licenses", version = "17.0.1" }
play-integrity = { group = "com.google.android.play", name = "integrity", version = "1.3.0" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
android-library = { id = "com.android.library", version.ref = "agp" }
jetbrains-kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
detekt = { id = "io.gitlab.arturbosch.detekt", version.ref = "detekt" }
semantic-version = { id = "com.dipien.android.semantic-version", version.ref = "semanticVersion" }
hilt = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
firebase-performance = { id = "com.google.firebase.firebase-perf", version.ref = "firebasePerf" }
oss-licenses-plugin = { id = "com.google.android.gms.oss-licenses-plugin", version.ref = "ossLicenses" }
dokka = { id = "org.jetbrains.dokka", version.ref = "dokka" }
```

---

## BÖLÜM 4-10: ANAYASA KULESİ VE KURALLAR (ÖZET)

*   **`AndroidApplicationConventionPlugin.kt`:** Uygulamaların `minSdk 26`, `Java 17` ve `Detekt` kurallarına uymasını zorunlu kılar.
*   **`detekt.yml`:** Kod stilini ve karmaşıklığını denetler. `maxIssues: 0` ile sıfır tolerans uygular.
*   **`EncryptedSharedPreferences`:** Verileri AES-256 ile şifreler.
*   **`NetworkSecurityConfig`:** Sadece HTTPS trafiğine izin verir ve sertifika iğnelemesi (Pinning) yapar.
*   **`Semantic Versioning`:** Sürüm numaralarını otomatik yönetir.
*   **`Jacoco`:** Test kapsamının %80 olmasını zorunlu kılar.

---

## BÖLÜM 11: AŞILMAZ MERKEZİ OTORİTE (`ci.yml`)

Bu dosya, GitHub Actions üzerinde çalışan, her değişikliği denetleyen otomatik bekçidir.

```yaml
name: Aether Anayasal Otoritesi
on:
  push:
    branches: [ "**" ]
  pull_request:
    branches: [ "main" ]

permissions:
  contents: write
  issues: write
  security-events: write
  checks: write

jobs:
  uretim-hatti:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout Code
        uses: actions/checkout@v4
        with:
          fetch-depth: 0
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Setup Gradle
        uses: gradle/actions/setup-gradle@v3
        with:
          cache-read-only: ${{ github.ref != 'refs/heads/main' }}
      - name: 🛡️ Security Scan (Trivy)
        uses: aquasecurity/trivy-action@0.16.1
        with:
          scan-type: 'fs'
          ignore-unfixed: true
          format: 'sarif'
          output: 'trivy-results.sarif'
          severity: 'CRITICAL,HIGH'
          exit-code: '1'
      - name: Upload Trivy Scan Results
        uses: github/codeql-action/upload-sarif@v3
        if: always()
        with:
          sarif_file: 'trivy-results.sarif'
      - name: Grant Execute Permission for Gradlew
        run: chmod +x gradlew
      - name: 🏗️ Lint & Build
        run: ./gradlew detekt assembleRelease
      - name: Upload Detekt Report
        if: failure()
        uses: actions/upload-artifact@v4
        with:
          name: detekt-report
          path: app/build/reports/detekt/
      - name: 🧪 Unit Tests & Coverage
        run: ./gradlew testDebugUnitTest jacocoTestCoverageVerification
      - name: Upload Test Reports
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: test-reports
          path: app/build/reports/tests/
      - name: 📦 Upload APK
        uses: actions/upload-artifact@v4
        with:
          name: app-release
          path: app/build/outputs/apk/release/*.apk
```

---

## BÖLÜM 12-39: İLERİ SEVİYE KATMANLAR (ÖZET)

*   **Veri Güvenliği:** `EncryptedPreferencesManager` ile yerel veriler şifrelenir.
*   **Hata Yönetimi:** `Timber` (CrashReportingTree) ile üretim hataları Firebase Crashlytics'e raporlanır.
*   **Veritabanı:** `Room` + `KSP` ile güvenli ve hızlı veritabanı.
*   **Mimari:** `:core`, `:feature` modülleri ile temiz ayrım.
*   **DI:** `Hilt` ile bağımlılık enjeksiyonu.
*   **Ağ:** `Retrofit` + `Kotlinx Serialization` + `OkHttp` ile güvenli API iletişimi.
*   **UI:** `Jetpack Compose` ve `BOM` ile modern arayüz.
*   **Navigasyon:** `Type-Safe Navigation` ve `AppNavigator` arayüzü ile gevşek bağlılık.
*   **Tasarım Sistemi:** `:core:designsystem` ile merkezi tema, renk ve tipografi yönetimi.
*   **Asenkron:** `Coroutines` ve `Flow` ile thread yönetimi.
*   **Arka Plan:** `WorkManager` ile garantili görevler.
*   **Performans:** `Firebase Performance` ile özel izler (Custom Traces).
*   **Güncelleme:** `In-App Update` ile zorunlu güncellemeler.
*   **Lisans:** `OSS Licenses Plugin` ile yasal uyumluluk.
*   **Dokümantasyon:** `Dokka` ile otomatik API dokümantasyonu.
*   **Güvenlik (İleri):** `R8/ProGuard` kuralları, `Certificate Pinning`, `Play Integrity API`.
*   **Yedekleme:** `Dependency Verification` (Checksum) ve `SBOM` üretimi.

---

## SONUÇ

Bu belge, **PROJE AETHER v5.0** mimarisinin anayasasıdır. Değiştirilemez, tartışılamaz. Fabrika bu kurallar üzerine inşa edilecektir.
