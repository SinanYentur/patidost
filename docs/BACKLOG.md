# GÖREV HAVUZU (BACKLOG) - FAZ 1 (SIFIR MALİYET EDİSYONU)

## EPIC-1: ALTYAPI VE TEMEL KURULUM (ÖNCELİK: YÜKSEK)
Projenin teknik iskeletinin kurulması. Tamamen yerel geliştirme.

- [ ] **TASK-1.1:** `buildSrc` ve Convention Plugin yapılandırması. (Gradle setup)
- [ ] **TASK-1.2:** Temel Modül Yapısının Oluşturulması (`:core:ui`, `:core:data`, `:core:network`).
- [ ] **TASK-1.3:** Navigasyon Kurulumu (Jetpack Navigation Compose).
- [ ] **TASK-1.4:** Temel UI Teması (Material 3, Typography, Colors, Dark Mode).
- [ ] **TASK-1.5:** Dependency Injection (Hilt) Kurulumu.

## EPIC-2: KİMLİK DOĞRULAMA (SIMULATED AUTH) (ÖNCELİK: YÜKSEK)
Bulut masrafı çıkarmamak için yerel simülasyon veya Ücretsiz Firebase Sınırı.

- [ ] **TASK-2.1:** `AuthRepository` arayüzünün oluşturulması.
- [ ] **TASK-2.2:** **MockAuthRepository** (Sahte Giriş) implementasyonu. (İnternet gerektirmez, %0 maliyet).
- [ ] **TASK-2.3:** Login Ekranı UI.
- [ ] **TASK-2.4:** Register Ekranı UI.
- [ ] **TASK-2.5:** Kullanıcı oturumunu yerel olarak (DataStore) saklama.

## EPIC-3: KEŞİF VE İLANLAR (MOCK DATA) (ÖNCELİK: YÜKSEK)
Sunucu bağlantısı yerine yerel sahte verilerle (JSON) çalışma.

- [ ] **TASK-3.1:** Room Database kurulumu (Tamamen cihazda çalışır).
- [ ] **TASK-3.2:** İlan Veri Modelleri (Pet, Breed, Location).
- [ ] **TASK-3.3:** **FakeDiscoveryDataSource**: Uygulama içine gömülü 10-15 örnek ilan verisi oluşturma.
- [ ] **TASK-3.4:** Ana Sayfa (Feed) UI - Gömülü verileri listeleme.
- [ ] **TASK-3.5:** Filtreleme UI (Yerel veriyi filtreler).

## EPIC-4: İLAN DETAY (ÖNCELİK: ORTA)
- [ ] **TASK-4.1:** İlan Detay Ekranı UI.
- [ ] **TASK-4.2:** Favorilere Ekleme (Room DB - Yerel Kayıt).
- [ ] **TASK-4.3:** "Sahiplen" butonu (Sadece Toast mesajı gösterir, SMS/Arama intent'i açar).

## EPIC-5: İLAN OLUŞTURMA (LOCAL STORAGE) (ÖNCELİK: ORTA)
Resimler buluta yüklenmez, sadece cihaz hafızasında tutulur.

- [ ] **TASK-5.1:** Fotoğraf Seçici (Photo Picker) entegrasyonu.
- [ ] **TASK-5.2:** İlan Formu UI.
- [ ] **TASK-5.3:** İlanı yerel veritabanına (Room) kaydetme.
- [ ] **TASK-5.4:** Listeye yeni eklenen ilanı anında gösterme (Local State Update).

---
**MALİYET NOTU:** Bu plandaki hiçbir madde dış sunucuya bağlanmaz, API key gerektirmez ve kredi kartı bilgisi istemez. Tamamen güvenlidir.
