# ANAYASAL ENJEKSİYON PLANI (v2.0 - SUR VE KULE)

**ANAYASAL KİMLİK BLOĞU**
---
- **FAZ:** FAZ-2 / ÖNCELİK-3: Enjeksiyon Genişletme
- **AMAÇ:** "Sıfır Meşruiyet" krizini projenin Data ve Domain katmanlarında sona erdirmek.
- **DAYANAK:** `reports/CONSTITUTIONAL_COVERAGE.md` (50 Gerçek Yetim Dosya Tespiti)

---

## HEDEF BÖLGE: STRATEJİ ODASI (DOMAIN KATMANI)

### 1. Hedef: `core/domain/auth/AuthResult.kt` (Sonuç Mührü)

*   **Gerekçe:** Sistemin başarı ve hata durumlarını tanımlayan, iş mantığının temel bir parçasıdır.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ4-001] Bu sınıf, sistemin çöküş ve başarı senaryolarını modellemektedir.
    ```

### 2. Hedef: `core/domain/repository/DiscoveryRepository.kt` (Keşif Sözleşmesi Mührü)

*   **Gerekçe:** Keşif verilerine erişim için anayasal bir sözleşme tanımlar.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ1-001] Bu arayüz, modüller arası bir sözleşmedir.
    ```

## HEDEF BÖLGE: VERİ MAHZENLERİ (DATA KATMANI)

### 3. Hedef: `core/data/repository/MockDiscoveryRepository.kt` (Sahte Veri Mührü)

*   **Gerekçe:** Test sırasında sahte "keşif" verileri üreterek sistemin gerçeklik algısını etkiler.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ4-001] Bu mock repository, sistemin dayanıklılık testlerinde kritik rol oynar.
    ```

## HEDEF BÖLGE: NAVİGASYON (SİSTEMİN DAMARLARI)

### 4. Hedef: `app/src/main/java/com/patidost/app/navigation/AppNavGraph.kt`

*   **Gerekçe:** Uygulama içi ekran geçişlerinin ana mantığını ve rotalarını tanımlar. Sistemin seyrüsefer haritasıdır.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [CORE-001] Tüm navigasyon kararları, Mutlak Şüphe ilkesine tabidir.
    ```

---
**SONRAKİ ADIM:** Bu planın onaylanmasının ardından, belirtilen mühürlerin ilgili dosyalara fiziksel olarak enjekte edilmesi ve MAP-001 motorunun yeniden çalıştırılarak anayasal kapsama oranının yükseldiğinin kanıtlanması.
