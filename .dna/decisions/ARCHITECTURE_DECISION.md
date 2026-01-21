# MİMARİ KARAR RAPORU

**PROTOKOL ID:** ANAYASA-ICRA: KANITLI-USTALIK
**ADIM:** 2/5

## 1. Karar Girdileri

1.  **Gereksinim Analizi Raporu:** `REQUIREMENTS_ANALYSIS.md`
2.  **Kanıt Havuzu:** `EVIDENCE-JUNIOR_BLINDNESS_*.md`, `EVIDENCE-GLOBAL_BLINDNESS_*.md`, `EVIDENCE-ARCHITECTURE_*.md` (ve diğerleri).
3.  **Proje Parametreleri (Varsayılan):** Küçük takım, çevik metodoloji, orta ölçek hedefi.

## 2. Karar Matrisi ve Analiz

| Gereksinim/Kanıt | MVVM Etkisi | MVI Etkisi | Karar Üzerindeki Ağırlığı |
| :--- | :--- | :--- | :--- |
| **Karmaşık State Yönetimi** (Pati Ekonomisi) | Yönetilebilir, ancak `LiveData` ile çoklu event ve state birleşimi karmaşıklaşabilir. | **POZİTİF**. Tek bir state objesi ve döngüsel yapı (`Intent` -> `Model` -> `State`) bu tür karmaşıklığı yönetmek için daha öngörülebilir ve test edilebilirdir. | **YÜKSEK** |
| **Çevrimdışı Yetenek** (Alarmlar) | Mimari deseninden bağımsızdır, `Repository` katmanında çözülür. | Mimari deseninden bağımsızdır, `Repository` katmanında çözülür. | NÖTR |
| **Test Edilebilirlik** | İyi. `LiveData` observer'larını test etmek bazen ek boilerplate gerektirir. | **ÇOK POZİTİF**. Kullanıcı niyetleri (`Intent`) ve sonuçta oluşan state'ler (`State`) saf birer obje olduğu için, `(Girdi) -> (Çıktı)` şeklinde fonksiyonel test yazmak çok daha kolaydır. | **YÜKSEK** |
| **Tek Gerçeklik Kaynağı** (Offline-First Kanıtı) | Destekler. ViewModel, `Repository`'den `Flow` veya `LiveData` observe eder. | **POZİTİF**. `StateFlow` gibi modern ve coroutine tabanlı akışlarla doğal olarak entegre çalışır. State redüksiyonu, bu akışlardan gelen veriye dayanır. | **ORTA** |
| **Küçük Takım & Öğrenme Eğrisi** | Endüstri standardı, kaynak bol. Öğrenme eğrisi daha düşük. | **NEGATİF**. MVI konsepti, standart MVVM'e göre daha soyut ve daha fazla boilerplate gerektirebilir. Küçük bir takım için başlangıçta yavaşlatıcı olabilir. | **ORTA** |

## 3. Nihai Mimari Kararı ve Gerekçelendirme

*   **Seçilen Mimari:** **Clean Architecture tabanlı, Modüler, Offline-First bir MVI (Model-View-Intent)**.

*   **Gerekçe:** `PatiDost` projesinin en belirleyici teknik zorlukları, **karmaşık ve tutarlı state yönetimi** (ekonomi, bildirimler) ve buna bağlı olarak **yüksek test edilebilirlik** ihtiyacıdır. MVI, bu iki alanda MVVM'e göre anayasal olarak kanıtlanmış bir üstünlük sunmaktadır. Kullanıcı aksiyonlarının (`Intent`) ve UI durumlarının (`State`) tek bir akış üzerinden yönetilmesi, uygulamanın davranışını son derece öngörülebilir kılar. Bu, özellikle `Pati Puanı` gibi hassas bir ekonominin ve `Abuse` tespiti gibi kritik sistemlerin geliştirilmesinde hayati önem taşır.

*   **Risk Yönetimi (Öğrenme Eğrisi):** MVI'nın başlangıçtaki karmaşıklığı, proje için standartlaştırılmış bir `BaseViewModel` ve `MviFragment`/`MviScreen` oluşturularak ve bu yapının dökümantasyonu `.dna/docs/` altında yapılarak minimize edilecektir. Bu, takımın tekrar tekrar aynı boilerplate'i yazmasını önleyecek ve MVI prensiplerini proje genelinde tutarlı bir şekilde uygulamasını sağlayacaktır.

Bu karar, projenin uzun vadeli sağlığını, test edilebilirliğini ve bakımını, başlangıçtaki potansiyel yavaşlamaya tercih ederek alınmıştır. Bu, anayasanın ruhuna uygundur.
