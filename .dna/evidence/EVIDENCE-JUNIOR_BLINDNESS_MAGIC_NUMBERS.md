# KANIT RAPORU: Junior Körlüğü - Sihirli Sayılar ve String'ler

**PROTOKOL ID:** AI-PROTOCOL: WEB-EVIDENCE-CONTINUOUS-v2026.1
**KANIT ID:** E-JB-002
**DÖNGÜ:** 7/50

## 1. Körlük Tanımı

**Sihirli Sayı/String Körlüğü:** Kod içerisinde, ne anlama geldiği bağlamından hemen anlaşılamayan, çıplak sayılar veya metinler kullanma hatası. Örneğin, `if (user.status == 2)` veya `bundle.putString("user_profile_type", "guest_user")` gibi. Bu değerlerin neyi temsil ettiği, kodun başka bir yerinde veya dokümantasyonda açıklanmadıkça anlaşılamaz. Bu durum, kodun okunabilirliğini, bakımını ve hataya dayanıklılığını ciddi şekilde zayıflatır.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `android/privacy-and-security/risks/hardcoded-cryptographic-secrets`
    *   **Bulgu:** Doküman, kriptografik anahtar gibi sırların kod içine `String` veya `byte array` olarak gömülmesinin ne kadar tehlikeli olduğunu vurgular.
    *   **Anayasal Sonuç:** Bu, "sihirli string" körlüğünün en tehlikeli tezahürüdür. Sadece okunabilirlik değil, aynı zamanda projenin güvenliğini de doğrudan tehdit eder. API anahtarları, şifreleme sırları gibi değerlerin kod içinde çıplak olarak bulunması mutlak bir anayasal suçtur ve "Güvenlik Doğuştandır" (Madde 10) ilkesini ihlal eder.

*   **Kanıt Referansı 2:** `android/develop/ui/compose/text/display-text` (Önceki döngülerden çapraz referans)
    *   **Bulgu:** Doküman, `Text("Hello World")` gibi hard-coded string'ler yerine `string resources` (`R.string.hello_world`) kullanılmasını önermektedir.
    *   **Anayasal Sonuç:** Bu, sadece çeviri (lokalizasyon) için değil, aynı zamanda kodun merkezileştirilmesi ve okunabilirliği için de bir anayasal gerekliliktir. UI metinleri, kodun içinde sihirli bir şekilde belirmemeli, `strings.xml` gibi merkezi bir sözleşme dosyasından referans alınmalıdır.

*   **Anayasal Sentez (Genel Yazılım Prensibi):** "Sihirli Sayı" kavramı, Clean Code gibi temel yazılım mühendisliği prensiplerinde de en temel "code smell" (kötü kod kokusu) olarak kabul edilir. Bir sayının (örn: `86400`) `SECONDS_IN_A_DAY` gibi isimlendirilmiş bir sabite dönüştürülmesi, kodun kendini belgelemesini sağlar.

## 3. Anayasal Kural Seti

1.  **SIFIR TOLERANS YASAĞI:** Kod tabanında, anlamı isminden belli olmayan hiçbir çıplak sayı veya metin bulunamaz. İstisnalar: `0`, `1`, `-1`, `""` (boş string) gibi evrensel ve bağlamdan bağımsız olarak anlamı açık olan değerler.
2.  **SABİT (CONSTANT) ZORUNLULUĞU:** Tüm sihirli sayılar, `UPPER_SNAKE_CASE` formatında isimlendirilmiş `const val` olarak tanımlanmak zorundadır. Bu sabitler, ait oldukları bağlama göre bir `companion object` içinde veya merkezi bir `Constants.kt` dosyasında gruplandırılmalıdır.
3.  **KAYNAK (RESOURCE) ZORUNLULUĞU:** Kullanıcıya gösterilen tüm metinler, `res/values/strings.xml` dosyasında tanımlanmak zorundadır. `Bundle` anahtarları, `SharedPreferences` anahtarları gibi uygulama içi anahtar-değer çiftleri için de `strings.xml` veya özel bir `Constants.kt` dosyası kullanılmalıdır.
4.  **GÜVENLİK SIRLARI YASAĞI:** API anahtarları, şifreleme anahtarları gibi sırlar, kodun veya kaynak dosyalarının hiçbir yerinde bulunamaz. Bu tür sırlar, `local.properties` gibi sürüm kontrolüne dahil edilmeyen dosyalardan `build.gradle` aracılığıyla `BuildConfig` alanlarına enjekte edilmeli ve bu dosyaların `.gitignore` ile korunduğu garanti edilmelidir.
5.  **STATİK ANALİZ DENETİMİ:** **GATE-3**'te kurulacak Detekt/Lint statik analiz altyapısı, "MagicNumber" ve "HardcodedText" gibi kuralları en yüksek öncelik ve `error` seviyesinde etkinleştirecektir. Bu kuralları ihlal eden hiçbir kod, derlemeden geçemeyecektir.
