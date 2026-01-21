# KANIT RAPORU: Küresel Körlük - Kültürel Hassasiyet

**PROTOKOL ID:** AI-GLOBAL-ULTRA-PRO
**KANIT ID:** E-GB-001
**DÖNGÜ:** 1/5

## 1. Körlük Tanımı

**Kültürel Körlük:** Renklerin, ikonların, sayı/tarih formatlarının ve sembollerin, geliştiricinin kendi kültürel varsayımlarına göre tasarlanması. Bu durum, başka kültürlerde uygulamanın yanlış anlaşılmasına, itici bulunmasına veya hakaret olarak algılanmasına yol açabilir.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `android/guide/topics/resources/internationalization`
    *   **Bulgu:** Doküman, Android'in uluslararasılaştırma desteği için **ICU (International Components for Unicode)** ve **CLDR (Common Locale Data Repository)** projelerini kullandığını belirtmektedir.
    *   **Anayasal Sonuç:** Bu, formatlama işlemlerinin (`String.format`, `DecimalFormat`, `SimpleDateFormat`) manuel olarak yapılmaması gerektiğinin en temel kanıtıdır. Android platformu, tarih, saat, sayı ve para birimi gibi verileri kullanıcının kendi lokaline (kültürüne) göre doğru formatta göstermek için yerleşik mekanizmalara sahiptir. Bu mekanizmaları kullanmamak, anayasal bir suç olan "Kültürel Körlük" fiilini oluşturur.

*   **Kanıt Referansı 2:** `android/develop/ui/compose/components/datepickers`
    *   **Bulgu:** Doküman, modern `DatePicker` (Tarih Seçici) bileşenini tanıtmaktadır.
    *   **Anayasal Sonuç:** Bu bileşen, ICU ve CLDR'ı temel alarak, gösterdiği takvimi (Gregoryen, Hicri, vb.), ay isimlerini ve gün sıralamasını kullanıcının lokaline göre otomatik olarak ayarlar. Manuel olarak bir tarih seçici arayüzü çizmeye çalışmak, kaçınılmaz olarak kültürel körlüğe yol açacaktır. Her zaman platformun sağladığı standart bileşenler tercih edilmelidir.

*   **Kanıt Referansı 3:** `android/studio/write/create-app-icons` ve `android/develop/ui/views/launch/icon_design_adaptive`
    *   **Bulgu:** Dokümanlar, ikonların farklı cihazlarda ve temalarda nasıl uyumlu görüneceğini (Adaptive Icons) anlatmaktadır. Ancak ikonların *kültürel anlamları* hakkında doğrudan bir teknik kural sunmamaktadır.
    *   **Anayasal Sonuç (Sentez):** Teknik olarak standart ikon setleri (örn: Material Icons) genellikle evrensel olarak kabul edilebilir olsa da, projenin `PatiDost` gibi duygusal ve sosyal bir bağlamı olduğu için, el, onay/ret işaretleri veya belirli hayvan figürleri gibi ikonların kültürel anlamları **insan yetki alanında** (UX niyeti) denetlenmelidir. AI, bu ikonları teknik olarak doğru uygulayabilir, ancak kültürel uygunluk onayı insan sorumluluğundadır.

## 3. Anayasal Kural Seti

1.  **VERİ FORMATLAMA YASAĞI:** Tarih, sayı ve para birimleri asla manuel olarak `String`'e çevrilmeyecektir. Her zaman `java.text.DateFormat`, `java.text.NumberFormat` gibi lokal farkındalığı olan sınıflar veya bunların `java.time` ve Jetpack karşılıkları kullanılacaktır.
2.  **STANDART BİLEŞEN ZORUNLULUĞU:** Tarih seçici, zaman seçici gibi bileşenler için her zaman Android'in standart, lokal farkındalığı olan bileşenleri kullanılacaktır.
3.  **İKON DENETİMİ:** Kullanılacak tüm ikonlar, özellikle insan jestleri veya dini/mitolojik semboller içerenler, "evrensel" olarak kabul edilmedikçe, bir "kültürel hassasiyet" denetiminden geçmelidir. Bu denetim, `.dna/contracts/ASSET_CONTRACT.yml` içinde belgelenecektir.
