# MİMARİ SÖZLEŞME (ARCHITECTURE CHARTER)

## 1. Katman Diyagramı
- **Sunum (Presentation):** Android UI (Jetpack Compose), ViewModel
- **Alan (Domain):** UseCase'ler, İş Kuralları, Saf Kotlin Modeli
- **Veri (Data):** Repository Pattern, Veri Kaynakları (Ağ, Yerel)

## 2. Modül Sınırları
- `:app`: Ana uygulama, navigasyon grafiği.
- `:core:ui`: Ortak UI bileşenleri, Tema.
- `:core:domain`: İş mantığı, arayüzler (Repository, UseCase).
- `:core:data`: Veri katmanı implementasyonları, veritabanı, ağ.
- `:feature:*`: Belirli bir özelliğin tüm UI ve ViewModel mantığı.

## 3. Yasaklı Bağımlılıklar
- **KESİNLİKLE YASAK:** `:feature` -> `:feature` (Feature modülleri birbirini tanıyamaz).
- **KESİNLİKLE YASAK:** `:core:domain` -> Android Framework (Domain katmanı saf Kotlin kalmalıdır).
- **KESİNLİKLE YASAK:** `:presentation` (ViewModel/UI) -> `:core:data` (Sunum katmanı sadece Domain ile konuşur).

## 4. Veri Akış Yönleri
UI -> ViewModel -> UseCase -> Repository -> DataSource

## 5. Teknoloji Gerekçeleri
- **UI:** Jetpack Compose (Modern, deklaratif)
- **DI:** Hilt (Standart, basit)
- **Async:** Kotlin Coroutines & Flow (Modern, yapısal)
- **Database:** Room (Android standardı)

## 6. Gelecek Modül Rezervleri
- `:feature:messaging`
- `:feature:map`
- `:core:analytics`

---
**İNSAN ONAYI:** [Bu bölüm, İnsan Operatör tarafından doldurulmadan ve imzalanmadan hiçbir kod üretilemez.]
