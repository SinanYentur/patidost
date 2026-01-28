# ANAYASAL ENJEKSİYON PLANI (v3.0 - SON KALE)

**ANAYASAL KİMLİK BLOĞU**
---
- **FAZ:** FAZ-2 / ÖNCELİK-3: Enjeksiyon Genişletme
- **AMAÇ:** Data ve Domain katmanlarındaki anayasal kapsama oranını %100'e çıkarmak ve tespit edilen mimari anomalileri çözmek.
- **DAYANAK:** `reports/ORPHANED_FILES.log` (4 Stratejik Yetim Tespiti)

---

## 1. HEDEF: STRATEJİK YETİMLERİN MÜHÜRLENMESİ

### 1.1. Hedef: `core/data/src/main/java/com/patidost/core/data/repository/MockDiscoveryRepository.kt`

*   **Gerekçe:** Keşif özelliği için sahte veri üreten bu kaynak, dayanıklılık testlerinin temelidir.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ4-001] Bu mock repository, sistemin dayanıklılık ve çöküş testlerinde kritik bir rol oynar.
    ```

### 1.2. Hedef: `core/domain/src/main/java/com/patidost/core/domain/auth/AuthResult.kt`

*   **Gerekçe:** Kimlik doğrulama işlemlerinin başarı/hata durumlarını modelleyen temel bir varlıktır.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ5-001] Bu veri sınıfı, sistemin durum ve evrim mantığının bir parçasıdır.
    ```

### 1.3. Hedef: `core/domain/src/main/java/com/patidost/core/domain/repository/DiscoveryRepository.kt`

*   **Gerekçe:** Keşif özelliği için veri katmanıyla olan anayasal sözleşmeyi tanımlar.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ1-001] Bu arayüz, modüller arası bir sözleşmedir.
    ```

## 2. KRİTİK MİMARİ ANOMALİ: İKİZ DOSYA TESPİTİ (ANOM-001)

*   **Tespit:** MAP-001 motoru, iki farklı yolda (`core/domain/auth/` ve `core/domain/repository/`) `AuthRepository.kt` adında iki dosya olduğunu tespit etmiştir. Biri mühürlü, diğeri yetimdir.
*   **Hüküm:** Bu, "Tekil Hakikat Kaynağı" (Single Source of Truth) ilkesinin ihlalidir ve anayasal belirsizlik yaratır.
*   **Eylem Planı:** Anayasal olarak mühürlenmemiş ve yetim olan `core/domain/auth/AuthRepository.kt` dosyası mühürlenmeyecek, bunun yerine **SİLİNECEKTİR**. Bu, belirsizliği ortadan kaldıracak ve anayasayı daha da güçlendirecektir.

---
**SONRAKİ ADIM:** Bu planın onaylanmasının ardından, 3 dosyanın mühürlenmesi ve 1 anomalili dosyanın silinmesi icra edilecektir. Ardından MAP-001 motoru çalıştırılarak, stratejik katmanlarda %100 kapsama oranına ulaşıldığı kanıtlanacaktır.
