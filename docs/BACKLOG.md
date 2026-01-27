# GÖREV HAVUZU (BACKLOG) - FAZ 1 (MVP)

## EPIC-1: ALTYAPI VE TEMEL KURULUM (ÖNCELİK: YÜKSEK)
Projenin teknik iskeletinin kurulması.

- [ ] **TASK-1.1:** `buildSrc` ve Convention Plugin yapılandırması. (Gradle setup)
- [ ] **TASK-1.2:** Temel Modül Yapısının Oluşturulması (`:core:ui`, `:core:data`, `:core:network`).
- [ ] **TASK-1.3:** Navigasyon Kurulumu (Jetpack Navigation Compose).
- [ ] **TASK-1.4:** Temel UI Teması (Material 3, Typography, Colors, Dark Mode).
- [ ] **TASK-1.5:** Dependency Injection (Hilt) Kurulumu.

## EPIC-2: KİMLİK DOĞRULAMA (AUTH) (ÖNCELİK: YÜKSEK)
Kullanıcıların sisteme güvenli giriş yapması.

- [ ] **TASK-2.1:** Firebase Console kurulumu ve `google-services.json` entegrasyonu.
- [ ] **TASK-2.2:** `AuthRepository` ve UseCase'lerin yazılması (Login, Register, Logout).
- [ ] **TASK-2.3:** Login Ekranı UI (Email/Password + Google Sign In butonu).
- [ ] **TASK-2.4:** Register Ekranı UI (Validasyon kuralları ile).
- [ ] **TASK-2.5:** AuthViewModel ve Unit Testleri.

## EPIC-3: KEŞİF VE İLANLAR (DISCOVERY) (ÖNCELİK: YÜKSEK)
Hayvan ilanlarının listelenmesi.

- [ ] **TASK-3.1:** Room Database kurulumu (Local Cache için).
- [ ] **TASK-3.2:** İlan Veri Modelleri (Pet, Breed, Location) ve API arayüzü (Mocky/Firebase).
- [ ] **TASK-3.3:** `DiscoveryRepository` ve Offline-First mantığı.
- [ ] **TASK-3.4:** Ana Sayfa (Feed) UI - LazyColumn ile liste yapısı.
- [ ] **TASK-3.5:** Filtreleme BottomSheet UI (Tür, Yaş, Şehir).

## EPIC-4: İLAN DETAY VE ETKİLEŞİM (ÖNCELİK: ORTA)
İlanın detaylarının görüntülenmesi.

- [ ] **TASK-4.1:** İlan Detay Ekranı UI (Fotoğraf Slider, Açıklama, Harita).
- [ ] **TASK-4.2:** "Sahiplen" butonu aksiyonu ve iletişim dialog'u.
- [ ] **TASK-4.3:** Favorilere Ekleme (Room DB local storage).

## EPIC-5: İLAN OLUŞTURMA (ÖNCELİK: ORTA)
Kullanıcının yeni ilan girmesi.

- [ ] **TASK-5.1:** Fotoğraf Seçici (Photo Picker) entegrasyonu.
- [ ] **TASK-5.2:** İlan Formu UI (Stepper yapısı).
- [ ] **TASK-5.3:** Firebase Storage'a fotoğraf yükleme mantığı.
- [ ] **TASK-5.4:** İlanı backend'e (Firestore) kaydetme.

## EPIC-6: PROFİL (ÖNCELİK: DÜŞÜK)
Kullanıcı ayarları.

- [ ] **TASK-6.1:** Profil Ekranı UI.
- [ ] **TASK-6.2:** Kullanıcının İlanlarım Listesi.
- [ ] **TASK-6.3:** Çıkış Yap (Logout) fonksiyonu.

---
**NOT:** Her task için Anayasa Madde 4.2 uyarınca ayrı bir "Görev Emri" oluşturulacaktır.
