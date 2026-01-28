# ALT PROTOKOL: OTOMATİK REFLEKS SİSTEMİ VE KRİZ YÖNETİMİ (SP-04)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/SYSTEM_RESILIENCE_AND_COLLAPSE_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Detay Protokolü
- **ETKİ ALANI:** Kriz Yönetimi, DevOps, Sistem Sağlığı
- **RİSK SEVİYESİ:** Kritik

---

## 1. PHOENIX BOOT PROSEDÜRÜ (SİSTEM YENİDEN DOĞUŞ)

Sistem geri dönülemez şekilde çöktüğünde (Veri kaybı, Build yapılamaması), bu protokol devreye girer.

### 1.1. ADIM ADIM YENİDEN DOĞUŞ
1.  **Durdur:** Tüm CI/CD süreçlerini ve yerel build'leri durdur.
2.  **Temizle:** `.gradle`, `build`, `.idea` klasörlerini tamamen sil (`git clean -fdx`).
3.  **Doğrula:** `scripts/verify_constitution_checksum.sh` ile anayasal bütünlüğü kontrol et.
4.  **Enjekte Et:** `buildSrc` ve `gradle/wrapper` dosyalarını, bilinen son `STABİL` commit'ten geri yükle.
5.  **Başlat:** `./gradlew clean assembleDebug` komutuyla "Soğuk Başlangıç" (Cold Start) yap.

## 2. KISMİ HAYATTA KALMA MODU (PARTIAL SURVIVAL)

Kriz sadece bir modüldeyse (Örn: `feature:chat`), tüm sistemi kapatmak yerine "Ampütasyon" yapılır.

### 2.1. AMPÜTASYON PROTOKOLÜ
1.  **İzole Et:** `settings.gradle.kts` dosyasından hatalı modülün `include` satırını yorum satırı yap (`// include(":feature:chat")`).
2.  **Körle:** Ana uygulamadaki (`app`) navigasyon grafiğinden, bu modüle giden yolları kaldır veya "Bakım Modu" ekranına yönlendir.
3.  **Raporla:** `CRISIS_LOG.md` dosyasına "Modül Kapatıldı" kaydını düş.

## 3. MİMARİ SAPMA ALGILAYICI (ARCHITECTURAL DRIFT DETECTOR)

### 3.1. OTOMATİK DENETİM
Her gece, CI sunucusu `scanArchitecturalDrift` görevini çalıştırır.
*   **Kontrol:** `core:ui` modülü `core:data`'ya erişiyor mu?
*   **Kontrol:** `feature` modülleri birbirine doğrudan bağlı mı?
*   **Tepki:** İhlal varsa, **ALARM** üretilir ve ilgili commit sahibine bildirim gider.

## 4. KRİZ MODLARI VE YETKİ SEVİYELERİ

| Kriz Modu | Tetikleyici | İzin Verilen Eylemler | AI Yetkisi |
| :--- | :--- | :--- | :--- |
| **NORMAL** | Yok | Tüm Üretim | Tam |
| **SARI (Gözlem)** | Sessiz Hata, Performans Düşüşü | Hata Düzeltme, Optimizasyon | Kısıtlı |
| **KIRMIZI (Kriz)** | Build Fail, Veri Kaybı | **SADECE ONARIM** | Yok (Sadece Rapor) |
| **SİYAH (Çöküş)** | Anayasal İhlal, Güvenlik Sızıntısı | **SİSTEM KAPALI** | Pasif |

---
**OPERASYONEL KARŞILIK:** `scripts/phoenix_boot.sh`, `scripts/scan_drift.sh`
**FAZ GEÇİŞ ŞARTI:** Kriz modu **NORMAL** olmadan faz geçilemez.
