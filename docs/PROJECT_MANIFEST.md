# PROJE MANİFESTOSU

## TEMEL BİLGİLER
- **Proje Adı:** PatiDost
- **Paket Adı:** com.patidost.app
- **Hedef SDK:** 34
- **Minimum SDK:** 24

## İŞ MODELİ
- **Monetizasyon:** Freemium (Temel özellikler ücretsiz, "Pati Puanı" ile ek özellikler)
- **Hedef Gelir (12 ay):** N/A (İlk hedef kullanıcı tabanı oluşturma)
- **Rekabet Analizi:** Genel ilan siteleri, basit eşleştirme uygulamaları. Farklılaşma: Güvenilirlik, topluluk ve oyunlaştırma.

## TEKNİK VİZYON
- **Mimari Pattern:** MVVM (Clean Architecture katmanları ile)
- **UI Framework:** Jetpack Compose
- **Veri Katmanı:** Room ve DataStore
- **Network:** Retrofit
- **Bağımlılık Yönetimi:** Gradle Version Catalogs & `buildSrc` Convention Plugins

## GÜVENLİK POLİTİKALARI
- **Veri Şifreleme:** TBD (Hassas veri için Jetpack Security kullanılacak)
- **API Güvenliği:** SSL Pinning (ileriki fazlarda)
- **Kod Obfuscation:** ProGuard/R8 (Release build'larda aktif)
