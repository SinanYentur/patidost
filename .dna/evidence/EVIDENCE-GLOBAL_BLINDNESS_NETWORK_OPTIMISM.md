# KANIT RAPORU: Küresel Körlük - Ağ Optimizmi

**PROTOKOL ID:** AI-GLOBAL-ULTRA-PRO
**KANIT ID:** E-GB-002
**DÖNGÜ:** 2/50

## 1. Körlük Tanımı

**Ağ Optimizmi Körlüğü:** Uygulamanın her zaman stabil, hızlı ve kesintisiz bir internet bağlantısına sahip olacağı varsayımıyla geliştirilmesi. Bu körlük, uygulamanın yavaş ağlarda (2G/3G), kesintili bağlantılarda (metro, asansör) veya tamamen çevrimdışı durumlarda kullanılamaz hale gelmesine neden olur.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `android/topic/architecture/data-layer/offline-first`
    *   **Bulgu:** Doküman, "Offline-first" (Önce Çevrimdışı) mimarisini, "uygulamanın internet erişimi olmadan temel işlevlerinin tamamını veya kritik bir alt kümesini gerçekleştirebilmesi" olarak tanımlar. Bu mimarinin temelinin Veri Katmanı (Data Layer) olduğunu belirtir.
    *   **Anayasal Sonuç:** Bu, projenin mimari temelinin "Önce Çevrimdışı" olması gerektiğinin en güçlü anayasal kanıtıdır. UI, her zaman önce yerel bir veritabanından (tek gerçeklik kaynağı - single source of truth) veri okumalıdır. Ağ, sadece bu yerel veritabanını güncellemek için kullanılan bir detaydır. UI'ın doğrudan ağdan veri okuması, bu körlüğün bir semptomudur ve anayasal suçtur.

*   **Kanıt Referansı 2:** `android/docs/quality-guidelines/build-for-billions/connectivity`
    *   **Bulgu:** Doküman, "Dünya genelindeki tüm kullanıcıların yarısından fazlası uygulamanızı 2G bağlantı üzerinden deneyimleyecektir" gibi kritik bir istatistik sunar. Veri depolamayı, istekleri sıraya koymayı ve resimleri optimize etmeyi önermektedir.
    *   **Anayasal Sonuç:** Ağ Optimizmi bir tercih değil, küresel bir gerçekliktir. Bu, resimlerin WebP formatında sunulması, dinamik olarak boyutlandırılması ve `WorkManager` gibi araçlarla isteklerin ağ durumu iyileştiğinde gönderilmek üzere sıraya konması gibi optimizasyonları anayasal bir zorunluluk haline getirir.

*   **Kanıt Referansı 3:** `android/topic/libraries/architecture/paging/v3-network-db`
    *   **Bulgu:** Paging 3 kütüphanesi için sunulan bu kılavuz, `RemoteMediator` API'sini kullanarak ağdan ve veritabanından aynı anda veri çekme (sayfalama) stratejisini anlatır. Strateji, UI'ın veriyi daima veritabanı önbelleğinden (cache) okuması ve sadece veritabanında veri kalmadığında ağa başvurması üzerine kuruludur.
    *   **Anayasal Sonuç:** Bu, "Önce Çevrimdışı" mimarisinin pratik bir uygulamasıdır. Sonsuz kaydırma (infinite scroll) gibi listeler, her seferinde ağa gitmemelidir. Önce lokal önbellek gösterilmeli, yeni veri arka planda ağdan çekilip veritabanına yazılmalı ve UI, veritabanındaki değişikliği gözlemleyerek (observing) güncellenmelidir. Bu, "Veri Egemenliği" (Madde 7) ilkesini güçlendirir.

## 3. Anayasal Kural Seti

1.  **TEK GERÇEKLİK KAYNAĞI (SINGLE SOURCE OF TRUTH) ZORUNLULUĞU:** Tüm uygulama verileri için tek gerçeklik kaynağı, cihazdaki yerel veritabanı (Room) olacaktır. UI, veriyi ağdan değil, bu veritabanından gözlemleyerek (observe) alacaktır.
2.  **DEPO (REPOSITORY) PATERNİ ZORUNLULUĞU:** Veri Katmanı, Depo (Repository) deseni ile soyutlanacaktır. Repository, veriyi önce yerel kaynaktan mı yoksa ağdan mı alacağına karar veren mantığı içerecek ve bu detayı ViewModel'den gizleyecektir.
3.  **ARKA PLAN SENKRONİZASYON ZORUNLULUĞU:** Sunucudan veri çekme ve sunucuya veri gönderme gibi işlemler, `WorkManager` kullanılarak, ağ durumu gibi kısıtlamalara (constraints) bağlı, ertelenebilir ve garantili arka plan görevleri olarak planlanmalıdır.
4.  **AĞ TESTİ ZORUNLULUĞU:** **GATE-3**'te kurulacak CI pipeline'ı, "Network Throttling" (ağ yavaşlatma) ile çalışan UI testlerini içermek zorundadır. Bu testler, uygulamanın 2G hızlarında nasıl davrandığını otomatik olarak doğrulamalıdır.
