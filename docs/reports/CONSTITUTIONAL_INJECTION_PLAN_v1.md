# ANAYASAL ENJEKSİYON PLANI (v1.0)

**ANAYASAL KİMLİK BLOĞU**
---
- **FAZ:** FAZ-2 / ÖNCELİK-3: Anayasal Enjeksiyon
- **AMAÇ:** "Sıfır Meşruiyet" krizini sona erdirmek ve kod tabanına ilk anayasal bağları kurmak.
- **DAYANAK:** `audits/reports/CONSTITUTIONAL_COVERAGE.md` (%0 Kapsama Raporu)

---

## HEDEF DOSYALAR VE ENJEKTE EDİLECEK ANAYASAL MÜHÜRLER

### 1. Hedef: `app/src/main/AndroidManifest.xml` (Sistemin Kapısı)

*   **Gerekçe:** Bu dosya, uygulamanın işletim sistemine kimliğini beyan eder, izinlerini talep eder ve bileşenlerini tanımlar. Anayasal olarak sistemin "pasaportudur".
*   **Enjekte Edilecek Mühür:**
    ```xml
    <!-- @pin: [FAZ0-001] Bu manifest, projenin temel amacını ve kimliğini yansıtır. -->
    <!-- @pin: [FAZ4-001] Uygulamanın çökme ve dayanıklılıkla ilgili temel beyanlarını içerir. -->
    ```

### 2. Hedef: `app/src/main/java/com/patidost/app/MainActivity.kt` (Sistemin Bilinci)

*   **Gerekçe:** Uygulamanın ana görsel ve mantıksal başlangıç noktasıdır. Kullanıcıyla ilk teması kuran anayasal yüzeydir.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [CORE-001] Bu aktivite, sistemin tüm operasyonel ilkelerine tabidir.
    // @pin: [PROJ-001] Bu aktivite, Patidost projesinin tanımlanmış prensiplerini hayata geçirir.
    ```

### 3. Hedef: `build.gradle.kts` (Kök İnşa Yasası)

*   **Gerekçe:** Tüm projenin nasıl derleneceğini, hangi eklentilerin kullanılacağını ve modüllerin nasıl bir araya getirileceğini tanımlayan en üst düzey inşa yasasıdır.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ1-001] Bu script, projenin "Build & Toolchain Mutlak Stabilite Sözleşmesi"ne tabidir.
    ```

### 4. Hedef: `.constitution/CORE_CONSTITUTION.md` (Mutlak Üst Norm)

*   **Gerekçe:** Bu dosya, diğer tüm anayasaların dayandığı, hiyerarşinin en tepesindeki mutlak normdur. Kendi varlığını ve dokunulmazlığını tescil etmelidir.
*   **Enjekte Edilecek Mühür:**
    ```markdown
    <!-- @pin: [CORE-001] Bu belge, kendisinin sistemin mutlak üst normu olduğunu beyan eder. -->
    ```

---

**SONRAKİ ADIM:** Bu planın onaylanmasının ardından, belirtilen mühürlerin ilgili dosyalara fiziksel olarak enjekte edilmesi ve ardından MAP-001 motorunun yeniden çalıştırılarak anayasal kapsama oranının %0'dan yükseldiğinin kanıtlanması.
