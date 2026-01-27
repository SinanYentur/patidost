# UI/UX SÖZLEŞMESİ

## Navigasyon Akışları
1.  **Onboarding Akışı:** `Splash -> Login -> Register`
2.  **Ana Akış:** `Discovery (Feed) -> PetDetail`
3.  **Profil Akışı:** `Profile -> Settings`

## Ekran Tipleri
- **Liste Ekranları:** `LazyColumn` / `LazyRow` kullanılacak.
- **Detay Ekranları:** `Column` içinde `Scrollable` olacak.
- **Form Ekranları:** State yönetimi `ViewModel`'de olacak, validasyon anlık yapılacak.

## Tasarım Tokenları (Tasarım Sistemi)
- **Renkler:** `core/ui/theme/Color.kt` dosyasından okunacak. Serbest renk kullanımı yasaktır.
- **Tipografi:** `core/ui/theme/Type.kt` dosyasından okunacak. Serbest font/boyut kullanımı yasaktır.
- **Boşluklar (Spacing):** 4dp, 8dp, 16dp, 24dp, 32dp standartları kullanılacak.

## UX İlkeleri
- **Netlik:** Kullanıcı ne yapacağını her zaman bilmeli.
- **Geri Alınabilirlik:** Yanlış bir aksiyon kolayca geri alınabilmeli.
- **Tek Odak:** Her ekranın birincil bir amacı olmalı.

## Erişilebilirlik Şartları
- Tüm görseller `contentDescription` içermelidir.
- Tüm tıklanabilir alanlar minimum `48dp` yüksekliğinde olmalıdır.
- Renk kontrast oranları WCAG AA standardına uymalıdır.
