# KANIT RAPORU: Küresel Körlük - İngilizce-Merkezli Mimari

**PROTOKOL ID:** AI-GLOBAL-ULTRA-PRO
**KANIT ID:** E-GB-004
**DÖNGÜ:** 4/50

## 1. Körlük Tanımı

**"İngilizce-Merkezli Mimari" Dogması:** Veritabanı şemalarını (örn: `VARCHAR(50)`), API kontratlarını ve UI bileşenlerini tasarlarken, yalnızca İngilizce dilinin kompakt ve soldan-sağa yapısını referans alma eğilimi. Bu dogma, metinlerin daha uzun olduğu (örn: Almanca), farklı karakter setleri kullanan veya sağdan-sola yazılan (örn: Arapça) dillerde UI'ın bozulmasına ve verinin kesilmesine (truncation) neden olur.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `android/guide/topics/resources/pseudolocales` (Önceki döngüden çapraz referans)
    *   **Bulgu:** `en_XA` sahte yerelleştirmesi, metinleri uzatarak ve özel karakterler ekleyerek UI'ın esnekliğini test etme imkanı sunar.
    *   **Anayasal Sonuç:** Bu aracın varlığı, Android platformunun metin uzunluğu değişkenliğinin kritik bir problem olduğunu kabul ettiğinin doğrudan kanıtıdır. UI bileşenleri, bu sahte yerelleştirme testinden geçebilecek kadar esnek tasarlanmak zorundadır. Sabit genişlikli metin alanları kullanmak anayasal ihlaldir.

*   **Kanıt Referansı 2:** `android/training/data-storage/room/defining-data`
    *   **Bulgu:** Doküman, Room `@Entity`'leri ile veritabanı şemasının nasıl tanımlanacağını gösterir.
    *   **Anayasal Sonuç (Sentez):** Doküman doğrudan bir uzunluk kuralı vermese de, şemanın tanımlandığı yer burasıdır. "İngilizce-Merkezli Mimari" körlüğünü engellemek için, buradaki `String` tipindeki alanlar (örn: `userName`, `petDescription`) için veritabanı seviyesinde katı ve kısa limitler koymaktan kaçınılmalıdır. Limitler, İngilizce'nin ortalama uzunluğuna göre değil, potansiyel en uzun çevirinin uzunluğuna göre cömertçe belirlenmelidir.

*   **Kanıt Referansı 3:** `android/develop/ui/compose/text/display-text`
    *   **Bulgu:** Doküman, `Text` kompozitinin metni `string resources`'dan almasını önermektedir.
    *   **Anayasal Sonuç:** Bu, temel bir adımdır. Ancak anayasal zorunluluk, bu `Text` bileşenini içeren üst bileşenlerin (örn: `Card`, `Row`, `Column`), içindeki metin 2 katına çıktığında dahi UI bütünlüğünü koruyacak şekilde tasarlanmasıdır. `maxLines` parametresi dikkatli kullanılmalı, `overflow` (taşma) davranışı (`TextOverflow.Ellipsis`) bilinçli bir tasarım kararı olmalıdır.

## 3. Anayasal Kural Seti

1.  **ESNEK UI ZORUNLULUĞU:** Tüm UI bileşenleri, içerecekleri metnin uzunluğunun %200 artabileceği varsayımıyla tasarlanmalıdır. `wrap_content` ve adaptif düzenler (`ConstraintLayout`, `Modifier.weight()`) temel alınmalı, sabit `dp` değerleriyle metin alanları kısıtlanmamalıdır.
2.  **CÖMERT VERİ ŞEMASI ZORUNLULUĞU:** Veritabanı şeması ve API veri modellerindeki metin alanları için tanımlanacak maksimum uzunluklar, İngilizce diline göre değil, Almanca, Rusça gibi daha uzun diller göz önünde bulundurularak belirlenmelidir. Şüphe durumunda, limit koymaktan kaçınılmalı veya çok yüksek tutulmalıdır.
3.  **SAHTE YERELLEŞTİRME (PSEUDOLOCALES) TESTİ ZORUNLULUĞU:** **GATE-3**'te kurulacak CI pipeline'ı, `pseudoLocalesEnabled = true` ile otomatikleştirilmiş UI testlerini çalıştırmak zorundadır. `en_XA` (uzunluk testi) ve `ar_XB` (RTL testi) ile yapılan testlerde bozulan her UI, bir derleme hatası (build failure) olarak kabul edilecektir.
