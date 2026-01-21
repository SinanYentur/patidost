# KANIT RAPORU: Küresel Körlük - Tek Veri Merkezi Krallığı

**PROTOKOL ID:** AI-GLOBAL-ULTRA-PRO
**KANIT ID:** E-GB-003
**DÖNGÜ:** 3/50

## 1. Körlük Tanımı

**"Tek Veri Merkezi Krallığı" Dogması:** Tüm backend altyapısını, geliştiricinin bulunduğu veya ilk aklına gelen tek bir coğrafi bölgeye (örn: `us-east-1` veya `europe-west`) kurma eğilimi. Bu dogma, uygulamanın küresel hedef kitlesini göz ardı eder ve sunucuya coğrafi olarak uzak kullanıcılar için yüksek gecikme (latency) ve daha düşük güvenilirlik (reliability) sorunlarına yol açar.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `firebase/docs/firestore/locations`
    *   **Bulgu:** Doküman, bir veritabanı örneği oluştururken "Gecikmeyi azaltmak ve kullanılabilirliği artırmak için verilerinizi, ona ihtiyaç duyan kullanıcılara ve hizmetlere yakın bir yerde saklayın" (To reduce latency and increase availability, store your data close to the users and services that need it) şeklinde net bir direktif vermektedir.
    *   **Anayasal Sonuç:** Bu, "Tek Veri Merkezi Krallığı" dogmasını doğrudan çürüten, otorite bir kaynaktan gelen birinci dereceden bir kanıttır. Gecikme, sadece bir performans metriği değil, aynı zamanda kullanıcı deneyiminin temel bir parçasıdır. Yüksek gecikme, "Performans Dokunulmazlığı" (Madde 9) ilkesini ihlal eder.

*   **Kanıt Referansı 2:** `firebase/docs/firestore/enterprise/locations` (MongoDB uyumlu)
    *   **Bulgu:** Bu doküman, ilkiyle aynı prensibi tekrar eder ve ek olarak "Çok Bölgeli" (multi-region) ve "Bölgesel" (regional) konum türlerini açıklar. Çok bölgeli konumlar, daha yüksek kullanılabilirlik ve daha düşük küresel gecikme sağlar.
    *   **Anayasal Sonuç:** Projenin backend altyapısı, PatiDost'un küresel hedef kitlesi göz önüne alındığında, tek bir bölgeye hapsedilemez. "Çok Bölgeli" bir veritabanı konumu, anayasal bir gereklilik olarak değerlendirilmelidir.

*   **Kanıt Referansı 3:** `firebase/docs/firestore/solutions/serve-bundles`
    *   **Bulgu:** Bu çözüm kılavuzu, herkese aynı içeriğin sunulduğu durumlar için (örn: en son haberler, en popüler ürünler), her kullanıcının aynı sorguyu tekrar tekrar yapmasını önlemek amacıyla "İçerik Paketlerini bir CDN'den sunmayı" (Serve bundled Firestore content from a CDN) önermektedir.
    *   **Anayasal Sonuç:** Bu, gecikmeyi azaltmak için sadece veritabanı konumunun değil, aynı zamanda statik veya yarı-statik verilerin bir **İçerik Dağıtım Ağı (CDN)** aracılığıyla kullanıcının coğrafi konumuna en yakın "uç" (edge) noktasından sunulması gerektiğinin kanıtıdır. Bu, özellikle hayvanların profil resimleri gibi medya içerikleri için kritik bir anayasal zorunluluktur.

## 3. Anayasal Kural Seti

1.  **ÇOK BÖLGELİ VERİTABANI ZORUNLULUĞU:** Projenin ana veritabanı (Firestore), tek bir bölgeye değil, küresel kullanıcı kitlesine hizmet verecek şekilde "Çok Bölgeli" (multi-region) bir konumda yapılandırılmalıdır.
2.  **CDN KULLANIMI ZORUNLULUĞU:** Tüm statik ve yarı-statik medya varlıkları (profil resimleri, post resimleri/videoları), bir İçerik Dağıtım Ağı (CDN) üzerinden sunulmalıdır. Cihaz, veriyi doğrudan ana sunucudan değil, kendisine en yakın CDN uç noktasından talep etmelidir.
3.  **GECİKME METRİĞİ (LATENCY METRIC) ZORUNLULUĞU:** **GATE-6 (Üretim Hazırlık)** fazında kurulacak izleme (monitoring) sistemi, dünyanın farklı bölgelerinden (örn: Asya, Avrupa, Kuzey Amerika) yapılan API isteklerinin 95. persentil gecikme sürelerini ölçecek metrikleri içermek zorundadır. Bu metrikler için bir Hizmet Seviyesi Hedefi (SLO) belirlenmelidir.
