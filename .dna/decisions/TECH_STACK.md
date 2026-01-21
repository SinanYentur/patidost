# TEKNOLOJİ YIĞINI KARAR RAPORU

**PROTOKOL ID:** ANAYASA-ICRA: KANITLI-USTALIK
**ADIM:** 3/5

## 1. Karar Girdileri

1.  **Mimari Karar Raporu:** `ARCHITECTURE_DECISION.md` (Clean Architecture + MVI)
2.  **Kanıt Havuzu:** `GATE-1_WEB_VALIDATED_LIBRARIES.md` ve diğer kanıtlar.

## 2. Seçilen Teknoloji Yığını ve Gerekçelendirme

Aşağıdaki liste, seçilen mimariye hizmet edecek ve web'den doğrulanmış en güncel stabil versiyonları içeren nihai teknoloji yığınını tanımlar.

| Kategori | Kütüphane | Onaylanan Versiyon | Gerekçe ve Anayasal Bağlantı |
| :--- | :--- | :--- | :--- |
| **UI** | `androidx.compose:compose-bom` | `2026.01.00` | Modern, deklaratif UI için standart. MVI mimarisi ile state'in UI'a yansıtılması için ideal. |
| **Asenkron** | `org.jetbrains.kotlinx:kotlinx-coroutines` | `1.7.3` | Ana thread I/O yasağını uygulamak ve asenkron işlemleri yönetmek için anayasal zorunluluk. `StateFlow` kullanımı MVI için kritiktir. |
| **Bağımlılık Enjeksiyonu** | `com.google.dagger:hilt-android` | `2.58` | Clean Architecture katmanlarının birbirinden bağımsız ve test edilebilir olmasını sağlar. `ViewModel` enjeksiyonu için standart. |
| **Veri (Lokal)** | `androidx.room:room-runtime` | `2.8.4` | "Offline-First" ve "Tek Gerçeklik Kaynağı" ilkelerini uygulamak için temel. `Pati Transaction Ledger` için ACID garantisi sağlar. |
| **Veri (Ağ)** | `com.squareup.retrofit2:retrofit` | `2.9.0` | **KARAR:** Kanıtlanmış stabilite. `3.0.0` versiyonu, kanıt eksikliği nedeniyle reddedilmiştir. `suspend` fonksiyon desteği ile Coroutine'lerle tam uyumlu. |
| **JSON Serileştirme** | `com.squareup.retrofit2:converter-moshi` | `2.9.0` | `Moshi`'nin Kotlin odaklı ve performanslı olması, `Retrofit` ile doğal entegrasyonu için tercih sebebidir. |
| **Medya Yükleme** | `io.coil-kt:coil-compose` | `2.7.0` | Coroutine tabanlı, modern ve performanslı. `Pet` ve `Post` resimlerinin verimli yüklenmesi için kritik. |
| **Navigasyon** | `androidx.navigation:navigation-compose` | `2.8.0-beta02` | **KARAR:** En güncel stabil versiyon tercih edilecektir. Compose ile tam entegre, standart navigasyon çözümü. |
| **Logging** | `com.jakewharton.timber:timber` | `5.0.1` | Android'in standart `Log` sınıfını sarmalayarak daha yapılandırılmış ve üretimde kapatılabilen loglama sağlar. "Gözlemlenebilirlik" ilkesi için temel. |

## 3. Anayasal Denetim Araçları

Proje iskeletine entegre edilecek denetim araçları:

*   **Güvenlik Açığı Taraması:** `dependency-check-gradle`
*   **Lisans Uyumluluğu:** `com.github.jk1.license`
*   **Kod Stili ve Kalitesi:** `io.gitlab.arturbosch.detekt` ve `com.diffplug.spotless` (Google Stil Rehberi ile)
*   **Ana Thread Denetimi:** `StrictMode` (Debug build'ler için)
