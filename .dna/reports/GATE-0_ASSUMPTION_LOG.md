# GATE-0: Varsayım Listesi (Assumption Log)

**PROTOKOL ID:** AI-GLOBAL-ULTRA-PRO
**TARİH:** 2024-05-24T12:20:00Z

Bu belge, projenin başlangıç anında doğru kabul edilen ve mimari kararları etkileyecek olan temel varsayımları listeler. Bu varsayımların geçersiz hale gelmesi, projenin yeniden değerlendirilmesini gerektirebilir.

## 1. Kullanıcı ve Cihaz Varsayımları

*   **V-1.1:** Hedef kullanıcılar, Android ve iOS işletim sistemlerine sahip modern akıllı telefonlar kullanmaktadır (Son ~5 yıl içinde üretilmiş).
*   **V-1.2:** Kullanıcıların büyük çoğunluğu, stabil bir internet bağlantısına (Wi-Fi veya 4G/5G) sahiptir. Ancak, Anayasa'nın "Ağ Optimizmi Körlüğü" maddesi gereği, sistem 2G/3G hızlarında ve offline durumlarda da işlevsel kalmalıdır.
*   **V-1.3:** Kullanıcılar, uygulama izinleri (kamera, konum, bildirim) gibi temel mobil işletim sistemi konseptlerine aşinadır.

## 2. Teknik ve Altyapı Varsayımları

*   **V-2.1:** Projenin backend altyapısı için Google Cloud Platform (Firebase/Firestore) servisleri kullanılacaktır. Bu servislerin erişilebilir ve stabil olduğu varsayılmaktadır.
*   **V-2.2:** Geliştirme ortamı, Android Studio'nun güncel stabil versiyonu ve ilişkili build araçları (AGP, Gradle) üzerine kurulacaktır.
*   **V-2.3:** Anayasa'da belirtilen güvenlik, lisans ve bağımlılık tarama araçları (OWASP Dependency-Check, Gradle License Plugin) projenin CI/CD ortamında çalıştırılabilecektir.

## 3. Ürün ve İş Modeli Varsayımları

*   **V-3.1:** Yol Haritası (A+++) belgesinde belirtildiği gibi, projenin ana gelir modeli "Gold Üyelik" veya "Abonelik" olmayacaktır. Ekonomi, "Pati Puanı" ve "Super Like" üzerine kuruludur.
*   **V-3.2:** Reklam, projenin ilk evrelerinde bir gelir modeli olarak düşünülmemektedir.
*   **V-3.3:** Veri gizliliği (GDPR/KVKK) ve kullanıcı güvenliği, ürünün temel bir özelliği olarak kabul edilir, bir "sonradan eklenecek" kalem değildir.

Bu varsayımlar, **GATE-2 (Mimari ve Veri)** fazındaki kararlar için temel oluşturacaktır.
