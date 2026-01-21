# KANIT RAPORU: Junior Körlüğü - Ana Thread I/O

**PROTOKOL ID:** AI-GLOBAL-ULTRA-PRO
**KANIT ID:** E-JB-001
**DÖNGÜ:** 6/50

## 1. Körlük Tanımı

**Ana Thread I/O (Input/Output) Körlüğü:** Ağ istekleri (network I/O) veya veritabanı işlemleri (disk I/O) gibi potansiyel olarak uzun sürebilecek operasyonları, kullanıcı arayüzünü (UI) yöneten ana iş parçacığı (main thread) üzerinde doğrudan çalıştırma hatası. Bu, Android'deki en temel ve en kritik performans günahıdır. Kullanıcı arayüzünün donmasına, takılmasına ve en sonunda "Application Not Responding" (ANR) diyalogunun çıkmasına neden olur.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `android/topic/performance/threads`
    *   **Bulgu:** Doküman, "Uygulamanızı başlattığınızda, Android 'ana iş parçacığı' olarak da bilinen yeni bir Linux süreci yaratır... Bu iş parçacığı çok önemlidir çünkü olayları kullanıcı arayüzü widget'larına göndermekten sorumludur... Bu nedenle, ana iş parçacığını engellememelisiniz." şeklinde net bir açıklama yapar.
    *   **Anayasal Sonuç:** Ana thread kutsaldır. Bu, anayasanın "Performans Dokunulmazlığı" (Madde 9) ilkesinin temelini oluşturan, platformun kendisi tarafından konulmuş bir kuraldır.

*   **Kanıt Referansı 2:** `android/topic/performance/vitals/anr`
    *   **Bulgu:** Doküman, bir ANR hatasının, "UI thread'i çok uzun süre engellendiğinde" tetiklendiğini belirtir. ANR'ların en yaygın nedenleri arasında "Ana thread üzerinde yavaş I/O işlemleri yapmak" maddesi yer alır.
    *   **Anayasal Sonuç:** Ana thread üzerinde yapılan I/O, bir "kötü pratik" değil, doğrudan ANR ile sonuçlanan, sistem tarafından cezalandırılan bir hatadır. Bu nedenle anayasal olarak mutlak bir yasaktır.

*   **Kanıt Referansı 3:** `android/kotlin/coroutines/coroutines-best-practices`
    *   **Bulgu:** Doküman, `Dispatchers` enjekte etmeyi ve uzun süren işlemleri `withContext(Dispatchers.IO)` veya `withContext(Dispatchers.Default)` blokları içinde çalıştırmayı bir "en iyi pratik" olarak sunar.
    *   **Anayasal Sonuç:** Kotlin Coroutine'leri, bu anayasal yasağı uygulamak için modern ve standart bir mekanizma sağlar. Tüm veritabanı ve ağ işlemleri, `suspend` olarak işaretlenmeli ve Repository veya UseCase katmanlarında `Dispatchers.IO` üzerinde çalıştırılmalıdır. ViewModel, bu operasyonları `viewModelScope` içinde ana thread'i bloke etmeden çağırmalıdır.

## 3. Anayasal Kural Seti

1.  **I/O YASAĞI:** Ana thread (UI thread) üzerinde doğrudan veya dolaylı olarak hiçbir ağ (network) veya disk (database, file) I/O operasyonu yapılamaz. Bu, mutlak bir yasaktır.
2.  **COROUTINE DISPATCHER ZORUNLULUĞU:** Tüm I/O işlemleri, `suspend` fonksiyonlar içinde ve `Dispatchers.IO` kullanılarak arka plan iş parçacıklarında çalıştırılmak zorundadır. `Dispatchers` asla `ViewModel` veya `Activity`/`Fragment` içinde hard-code edilmemeli, test edilebilirlik için bağımlılık enjeksiyonu (dependency injection) ile sağlanmalıdır.
3.  **STRİCTMODE ZORUNLULUĞU:** Geliştirme (debug) build'lerinde, `StrictMode.setThreadPolicy()` kullanılarak ana thread üzerinde disk veya ağ erişimi olması durumunda uygulamanın çökmesini (crash) sağlayan bir denetim mekanizması kurulacaktır. Bu, hataların daha geliştirme aşamasında tespit edilmesini garanti eder.
4.  **LINT KURALI AKTİVASYONU:** **GATE-3**'te kurulacak statik analiz altyapısı, ana thread üzerinde I/O işlemi tespit eden tüm Lint kurallarını `error` seviyesine yükseltecek ve bu durumda derlemenin başarısız olmasını sağlayacaktır.
