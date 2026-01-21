# KANIT RAPORU: Junior Körlüğü - İsimlendirme ve Stil Kuralları

**PROTOKOL ID:** AI-PROTOCOL: GUARDIAN-EXECUTION-v2026.2
**KANIT ID:** E-JB-003
**TARİH:** 2026-05-24T14:15:00Z

## 1. Körlük Tanımı

**İsimlendirme ve Stil Körlüğü:** Kodun tutarlı, okunabilir ve platform standartlarına uygun bir şekilde yazılmaması. Anlamsız değişken isimleri (`val x`, `val temp`), yanlış `case` kullanımı (örn: `UPPER_SNAKE_CASE` yerine `camelCase` sabitler), dosya ve paket yapısında standart olmaması gibi hataları içerir. Bu, kodun anlaşılmasını ve bakımını zorlaştırır, takım çalışmasını baltalar.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `android/kotlin/style-guide` (Google Android Kotlin Stil Rehberi)
    *   **Bulgu:** Bu doküman, Google tarafından Android geliştirmede kullanılan Kotlin kodu için **mutlak ve eksiksiz** bir standartlar bütünüdür. İçeriğinde dosya yapısı, isimlendirme (paketler, sınıflar, fonksiyonlar, sabitler), formatlama, dökümantasyon (KDoc) ve her türlü dil özelliğinin nasıl kullanılacağı detaylıca anlatılmaktadır.
    *   **Anayasal Sonuç:** Bu doküman, projenin "Kod Okunabilirliği Hukuku" (Madde 8) için **Anayasanın kendisi** olarak kabul edilmelidir. Bu rehbere uymayan hiçbir kod, geçerli sayılamaz. `ktlint` gibi statik analiz araçları, bu rehberi otomatik olarak uygulamak için birincil araçtır.

*   **Kanıt Referansı 2:** `android/jetpack/compose/compose-api-guidelines` (Jetpack Compose API Rehberi)
    *   **Bulgu:** Bu rehber, özellikle Jetpack Compose için `@Composable` fonksiyonların nasıl isimlendirileceği (PascalCase ve bir isim gibi, fiil değil), `Modifier` parametresinin her zaman ilk opsiyonel parametre olması gerektiği, state ve event callback'lerinin nasıl tanımlanacağı gibi spesifik kurallar içerir.
    *   **Anayasal Sonuç:** Genel Kotlin stil rehberine ek olarak, Jetpack Compose ile UI katmanı yazılırken bu daha spesifik rehberin kuralları uygulanmak zorundadır. Bu, katmanlı bir anayasal düzenin parçasıdır: Genel kuraldan özele doğru.

## 3. Anayasal Kural Seti

1.  **MUTLAK UYUM ZORUNLULUĞU:** Projedeki tüm Kotlin kodu, istisnasız olarak `android/kotlin/style-guide` adresindeki Google Android Kotlin Stil Rehberi'ne uymak zorundadır.
2.  **COMPOSE SPESİFİK UYUM ZORUNLULUĞU:** UI katmanında yazılan tüm Jetpack Compose kodu, ek olarak `android/jetpack/compose/compose-api-guidelines` rehberine de uymak zorundadır.
3.  **OTOMATİK STİL DENETİMİ (LINTER) ZORUNLULUĞU:** **GATE-3**'te kurulacak statik analiz altyapısı, `ktlint` aracını, Google stil rehberini (`google` style) baz alacak şekilde yapılandırmak zorundadır. Stil ihlalleri, derleme hatası (build failure) olarak kabul edilecektir.
4.  **İSİMLENDİRME ANAYASASI:**
    *   **Paketler:** `com.patidost.app.feature.subfeature`
    *   **Sınıflar, Arayüzler, Enumlar:** `PascalCase`
    *   **Fonksiyonlar, Değişkenler:** `camelCase`
    *   **Sabitler (`const val`):** `UPPER_SNAKE_CASE`
    *   **Composable Fonksiyonlar:** `PascalCase` ve bir isim (örn: `UserProfileHeader`)

Bu kanıt raporu, proje DNA'sına kalıcı olarak işlenmiştir.
