# PROTOKOL P-01: KONFİGÜRASYON BÜTÜNLÜĞÜ VE UYUMLULUK DENETİMİ

**Belge ID:** OMEGA-PROTOCOL-P01-V1.0
**Durum:** AKTİF, ZORUNLU
**Felsefe:** "Uyumsuz bir temel üzerine sağlam bir yapı inşa edilemez."

---

## 1. AMAÇ

Bu protokol, projenin temel yapılandırma ayarlarının (versiyonlar, bağımlılıklar) tüm modüllerde tutarlı ve birbiriyle uyumlu olmasını garanti altına alır. Derleme zamanı hatalarının en yaygın nedenlerinden birini proaktif olarak önlemeyi hedefler.

## 2. TETİKLEYİCİ

1.  Projeye yeni bir modül eklendiğinde.
2.  Projenin ana Kotlin, Gradle veya Android Gradle Plugin versiyonu güncellendiğinde.
3.  Compose, Hilt gibi ana kütüphanelerin majör bir versiyon güncellemesi yapıldığında.

## 3. ZORUNLU KONTROL LİSTESİ (CHECKLIST)

- **[ ] Compose/Kotlin Uyumluluk Kontrolü:**
  - **Eylem:** Android'in resmi **Compose-Kotlin Uyumluluk Haritası** (`developer.android.com/jetpack/androidx/releases/compose-kotlin`) kontrol edilir.
  - **Doğrulama:** Projenin `build.gradle.kts` dosyalarındaki `kotlinCompilerExtensionVersion` ile projenin ana Kotlin versiyonunun bu haritadaki uyumlu bir çift olduğu kanıtlanır.

- **[ ] Bağımlılık Versiyon Tutarlılığı:**
  - **Eylem:** Projedeki tüm modüllerin `build.gradle.kts` dosyaları taranır.
  - **Doğrulama:** Compose, Hilt, Coroutines gibi paylaşılan temel kütüphanelerin versiyonlarının, proje seviyesindeki `libs.versions.toml` (Version Catalog) tarafından veya aynı manuel versiyon numarasıyla yönetildiği garanti edilir. Farklı modüllerde aynı kütüphanenin farklı versiyonları olamaz.

- **[ ] Kod Üretim (Kapt/KSP) Tutarlılığı:**
  - **Eylem:** Hilt, Room gibi ek açıklama işlemcileri kullanan modüllerin yapılandırmaları incelenir.
  - **Doğrulama:** Tüm modüllerin `kapt` veya `ksp` için aynı temel yapılandırmayı (`correctErrorTypes` vb.) kullandığı teyit edilir.

## 4. ÇIKTI

Bu denetimden geçmeyen hiçbir modül eklemesi veya versiyon güncellemesi ana `develop` branch'ine birleştirilemez. Bu protokol, P-00 Ön-Denetim Protokolü'nün bir parçası olarak işletilir.
