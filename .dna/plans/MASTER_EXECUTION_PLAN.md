# ANA İCRAAT PLANI (MASTER EXECUTION PLAN)

**PROTOKOL:** AI-PROTOCOL: AUTONOMOUS-GENESIS-v2026.3

Bu plan, `ANAYASA-ICRA: TAM-OTOMASYON` emri ile başlatılan nihai kanıt toplama sürecinin yol haritasıdır.

---

### **FAZ 0: MİMARİ VE PROJE TEMELLERİ**

1.  **Mimari Desen Karşılaştırması:** MVVM vs. MVI (State yönetimi, test edilebilirlik, boilerplate).
2.  **Clean Architecture Katmanları:** UI, Presentation (ViewModel), Domain (UseCases), Data (Repositories) katmanlarının sorumlulukları ve aralarındaki iletişim kuralları.
3.  **Modüler Mimari Stratejisi:** Özellik (Feature) ve Katman (Layer) bazlı modülleştirmenin avantaj/dezavantajları.
4.  **Bağımlılık Enjeksiyonu (DI):** Hilt kullanımı, `ViewModel` enjeksiyonu, testlerde `double` kullanımı.

---

### **FAZ 1: VERİ KATM mischievous ANI (DATA LAYER)**

1.  **Ağ İstemcisi:** `Retrofit` + `OkHttp` (Interceptor, logging, timeout, cache politikaları).
2.  **JSON Serileştirme:** `Moshi` vs. `Gson` (Kotlin uyumu, performans, adapter kullanımı).
3.  **Lokal Veritabanı:** `Room` (Entity, DAO, veritabanı migrasyonları, ilişkiler, type converter'lar).
4.  **Lokal Key-Value Depolama:** `Jetpack DataStore` (Preferences vs. Proto DataStore).

---

### **FAZ 2: ARAYÜZ KATMANI (UI LAYER)**

1.  **UI Kütüphanesi:** `Jetpack Compose` (Composable fonksiyonlar, `Modifier` kullanımı, Recomposition stratejileri).
2.  **State Yönetimi:** `StateFlow` / `SharedFlow` kullanımı, `collectAsStateWithLifecycle`, olay (event) yönetimi (tek seferlik olaylar).
3.  **Navigasyon:** `Jetpack Navigation Component` (Compose için) (NavGraph, argüman geçişi, deep link).
4.  **Asenkron Operasyonlar:** `ViewModel` içinde `viewModelScope` kullanımı, `coroutineScope`.

---

### **FAZ 3: TEST STRATEJİSİ**

1.  **Unit Testler:** JUnit 5, MockK/Mockito. ViewModel ve UseCase testleri.
2.  **Entegrasyon Testleri:** Room DAO testleri, `HiltAndroidTest`.
3.  **UI Testleri:** `ComposeTestRule`, `onNode`, `performClick`, screenshot testleri.
4.  **Asenkron Kod Testi:** `kotlinx-coroutines-test`, `runTest`, `TestDispatcher`.

---

### **FAZ 4: BUILD, GÜVENLİK VE CI/CD**

1.  **Build Sistemi:** `build.gradle.kts` (Kotlin DSL), `libs.versions.toml` (Version Catalog).
2.  **Statik Analiz:** `ktlint` ve `Detekt` entegrasyonu ve konfigürasyonu.
3.  **Güvenlik:** API anahtarlarının `BuildConfig` veya NDK ile saklanması, ProGuard/R8 ile kod gizleme.
4.  **Sürekli Entegrasyon (CI):** GitHub Actions ile otomatik build, test ve analiz pipeline'ı oluşturma.

---

### **FAZ 5: OPERASYON VE KÜRESEL KÖRLÜKLER (ÖZET)**

1.  **Gözlemlenebilirlik:** `Timber` (Logging), `Firebase Crashlytics` (Crash Raporlama).
2.  **Performans:** `Baseline Profiles`, `Macrobenchmark` ile başlangıç ve kaydırma performansı ölçümü.
3.  **Küresel Körlükler:** (Önceki döngülerde toplanan kanıtların pekiştirilmesi ve yeni kanıtlar).
