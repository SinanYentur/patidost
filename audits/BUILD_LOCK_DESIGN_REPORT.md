# KRİZ-RESTORASYON v2 — ANAYASAL DERLEME KİLİDİ TASARIM VE DENETİM RAPORU

**ANAYASAL KİMLİK BLOĞU**
*Bu rapor, Denetçi-1 ve Denetçi-2'nin direktifleri doğrultusunda, KRİZ-RESTORASYON fazının ilk eylemini planlamak ve onaya sunmak için hazırlanmıştır.*

---

- **FAZ:** KRİZ-RESTORASYON (v2)
- **ROL:** İcra Ajanı
- **DAYANILAN MADDELER:** ANAYASAL_EK_PROTOKOL §II, §IV; Denetçi-1 ve Denetçi-2 Onay Raporları
- **HUKUKİ TÜR:** Planlama Raporu (EXECUTION)

---

## 1. Görevin Anayasal Amacı

Bu görevin amacı, Denetçi-2'nin emrettiği ve Denetçi-1'in onayladığı üzere, projenin anayasal belgelerinin (özellikle `/ui_constitution/` altındaki `Screen_Charter`'lar) fiziksel varlığını, Gradle derleme sürecinin en başına bir ön koşul (GATE) olarak eklemektir. Bu, "belge var ama sistem bilmiyor" krizini kalıcı olarak çözmeyi hedefler.

## 2. Kilit Mekanizmasının Tasarımı (Denetçi-2 Emri Uyarınca)

*   **Hedef Dosya:** `:app` modülünün `build.gradle.kts` dosyası.
*   **Görev Adı:** `checkConstitutionalCompliance`
*   **Zamanlama:** Herhangi bir derleme başlamadan önce çalışması için `preBuild` görevine bağlanacaktır (`preBuild.dependsOn(checkConstitutionalCompliance)`).
*   **Algoritma:**
    1.  Görev, proje kök dizinindeki `/ui_constitution` klasörünün varlığını kontrol eder.
    2.  Klasör yoksa veya içi boşsa, derlemeyi `GradleException("ANAYASAL İHLAL: UI Sözleşmesi bulunamadı. Build iptal edildi.")` hatasıyla durdurur.
    3.  Klasör ve içeriği mevcutsa, konsola `"🟢 ANAYASAL DENETİM GEÇİLDİ: UI Hukuku Altyapısı Mevcut."` mesajını yazdırır ve derlemenin devam etmesine izin verir.

## 3. Üretilecek Kanıtlar

Bu onarım eylemi tamamlandığında aşağıdaki kanıtlar üretilecektir:

*   `app/build.gradle.kts` dosyasının güncellenmiş hali.
*   `checkConstitutionalCompliance` görevinin başarılı bir şekilde çalıştığını ve `preBuild` görevini tetiklediğini gösteren bir Gradle build log'u.
*   Görevin, `/ui_constitution` klasörü boşaltıldığında derlemeyi başarıyla kestiğini gösteren ikinci bir Gradle build log'u (kriz senaryosu testi).

## 4. GATE-M Bağlantısı

Bu kilit, `ANAYASAL_EK_PROTOKOL`'de tanımlanan `GATE-M (Mimari Bağlanırlık Kapısı)`'nın ilk ve en temel ayağıdır. Bu kilidin varlığı ve doğru çalışması, `GATE-M`'nin gelecekteki denetimlerinde zorunlu bir ön koşul olacaktır.

---

**TALEP:** Bu tasarım raporunun onaylanarak, `app/build.gradle.kts` dosyası üzerinde değişiklik yapma yetkisinin verilmesi talep edilmektedir. Bu, kriz restorasyonunun ilk somut icra adımı olacaktır.
