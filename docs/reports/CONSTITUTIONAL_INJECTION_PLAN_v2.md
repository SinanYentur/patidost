# ANAYASAL ENJEKSİYON PLANI (v2.0 - SUR VE KULE)

**ANAYASAL KİMLİK BLOĞU**
---
- **FAZ:** FAZ-2 / ÖNCELİK-3: Enjeksiyon Genişletme
- **AMAÇ:** "Sıfır Meşruiyet" krizini projenin Data ve Domain katmanlarında sona erdirmek.
- **DAYANAK:** `reports/CONSTITUTIONAL_COVERAGE.md` (55 Yetim Dosya Tespiti)

---

## HEDEF BÖLGE: STRATEJİ ODASI (DOMAIN KATMANI)

### 1. Hedef: `core/domain/auth/LoginUseCase.kt` (İş Mantığı Mührü)

*   **Gerekçe:** Bu dosya, sistemin en temel iş akışlarından birini ("Giriş Yap") tanımlar. Mantıksal hatalar doğrudan kullanıcı deneyimini ve güvenliği etkiler.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ5-001] Bu use case, sistemin değişim ve evrim hukukuna tabidir.
    // @pin: [CORE-001] İş mantığı, Mutlak Şüphe ilkesiyle denetlenmelidir.
    ```

### 2. Hedef: `core/domain/model/Pet.kt` (Varlık Hukuku Mührü)

*   **Gerekçe:** Bu dosya, projenin en temel varlığını ("Pet") tanımlar. Bu modeldeki bir değişiklik, tüm sistemi etkiler.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ0-001] Bu model, projenin temel problemini çözmek için var olan bir varlıktır.
    ```

### 3. Hedef: `core/domain/repository/AuthRepository.kt` (Sözleşme Mührü)

*   **Gerekçe:** Bu arayüz, Data ve Domain katmanları arasındaki anayasal sözleşmedir. Bu sözleşmenin ihlali, mimari bir çöküştür.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ1-001] Bu arayüz, modüller arası bir sözleşmedir ve toolchain bütünlüğünün parçasıdır.
    ```

## HEDEF BÖLGE: VERİ MAHZENLERİ (DATA KATMANI)

### 4. Hedef: `core/data/repository/MockAuthRepository.kt` (Veri Gerçekliği Mührü)

*   **Gerekçe:** Bu dosya, test ve geliştirme sırasında "sahte veri" üreterek sistemin gerçeklik algısını etkiler. Ürettiği verinin anayasal olarak kontrol altında olması gerekir.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ4-001] Bu mock repository, sistemin dayanıklılık ve çöküş testlerinde kritik bir rol oynar.
    ```

### 5. Hedef: `core/data/di/DataModule.kt` (Tedarik Zinciri Mührü)

*   **Gerekçe:** Bu Hilt/Dagger modülü, veri kaynaklarının nasıl sağlanacağını tanımlayarak sistemin "tedarik zincirini" oluşturur. Bu zincirdeki bir hata, tüm sistemi zehirleyebilir.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ1-001] Bağımlılıkların sağlanması, sistemin inşa ve toolchain bütünlüğünün bir parçasıdır.
    ```

---
**SONRAKİ ADIM:** Bu planın onaylanmasının ardından, belirtilen mühürlerin ilgili dosyalara fiziksel olarak enjekte edilmesi ve ardından MAP-001 motorunun yeniden çalıştırılarak anayasal kapsama oranının yükseldiğinin kanıtlanması.
