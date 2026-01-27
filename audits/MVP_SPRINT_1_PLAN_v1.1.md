# MVP İNŞASI (SPRINT 1) — ANAYASAL PLAN v1.1

**ANAYASAL KİMLİK BLOĞU**
*Bu rapor, Denetçi-1 ve Denetçi-2'nin direktifleri doğrultusunda, Sprint 1'in ilk adımı olan Domain Katmanı inşasının anayasal çerçevesini ve icra planını tanımlar.*

---

- **FAZ:** MVP İNŞASI (Sprint 1) - Planlama
- **ROL:** Anayasa Uygulama Ajanı / Mimar
- **DAYANILAN MADDELER:** Denetçi-1 Şartlı Onay Raporu, Denetçi-2 İcra Emri, ARCHITECTURE_DECISION.md
- **HUKUKİ TÜR:** Planlama Raporu (EXECUTION)

---

## ADIM 1: DOMAIN KATMANI İNŞASI (SÖZLEŞME ve KANIT ENTEGRASYONLU)

**Hedef:** `:core:domain` modülü içinde "Bir kullanıcı olarak, bir hesap oluşturabilir ve giriş yapabilirim" kullanıcı hikayesinin iş mantığını kurmak.

### 1.1. Üretilecek Anayasal Varlıklar ve Kodlar

1.  **`AuthResult.kt` (Sealed Interface):**
    *   **Anayasal Rol:** Veri Sözleşmesi. Giriş işleminin sonuçlarını (Success, Error, Loading) standartlaştırır.
    *   **İhlal Senaryosu:** Bu arayüz dışındaki bir tiple (örn: `Boolean`) sonuç döndürmek, `E-CONTRACT` (Sözleşme İhlali) hatasıdır.
2.  **`AuthRepository.kt` (Interface):**
    *   **Anayasal Rol:** Modül Arayüz Sözleşmesi. Data katmanının ne yapması gerektiğini tanımlar, nasıl yapacağını söylemez.
    *   **Sözleşme:** `suspend fun login(email: String, pass: String): AuthResult` ve `suspend fun register(...): AuthResult` fonksiyonlarını içerecektir.
3.  **`LoginUseCase.kt` (Class):**
    *   **Anayasal Rol:** İş Kuralı Motoru. Sadece giriş işleminin validasyon ve orkestrasyon mantığını içerir.
    *   **Sözleşme:** `AuthRepository` arayüzünü enjekte alır, asla implementasyonunu bilmez. E-posta formatı, şifre uzunluğu gibi validasyonları yapar.

### 1.2. Mock / Fake Yaşam Döngüsü Bloğu

*   **Kural:** Bu Domain katmanı inşası sırasında, `:core:data` modülünde **`MockAuthRepository.kt`** adında bir sahte implementasyon oluşturulacaktır.
*   **Anayasal Kilit:** Bu dosya, `build.gradle.kts` içinde `debugImplementation` ile eklenecek ve şu annotasyon ile işaretlenecektir:
    ```kotlin
    @Simulated(status = Lifecycle.UNTIL_BACKEND_CONNECTED, ticket = "TICKET-123")
    ```
*   **Yaptırım:** `verifyNoSimulatedInRelease` Gradle görevi, bu annotasyona sahip hiçbir dosyanın `release` build'e girmemesini garanti edecektir. Bu, **Gerçeklik Ayrıştırma Protokolü**'nün icrasıdır.

### 1.3. GATE-M ve İCRA_ENVANTERİ Entegrasyon Bloğu

*   **Kanıt Üretimi:** Bu adım tamamlandığında aşağıdaki kanıtlar üretilecektir:
    *   Yeni oluşturulan 3 Kotlin dosyasının içeriği.
    *   `:core:domain` modülünün `assemble` görevinin başarılı olduğuna dair log çıktısı **[Kanıt Türü: Build Kanıtı]**.
*   **Envanter Güncellemesi:** Üretilen kanıtlar ve dosyalar, `/audits/ICRA_ENVANTERİ.md` dosyasına şu şekilde işlenecektir:

| Varlık ID | Anayasal Tür | Fiziksel Yol | Durum |
| :--- | :--- | :--- | :--- |
| `DO-01` | Sözleşme | `.../domain/AuthResult.kt` | Tanımlandı & Doğrulandı |
| `DO-02` | Sözleşme | `.../domain/repository/AuthRepository.kt` | Tanımlandı & Doğrulandı |
| `DO-03` | İş Kuralı | `.../domain/usecase/LoginUseCase.kt` | Tanımlandı & Doğrulandı |

*   **GATE-M Etkisi:** Bu adım, `GATE-M` için gerekli olan **"Modül içi tutarlılık"** ve **"Sözleşme varlığı"** kanıtlarını üreterek, kapının gelecekte açılmasına zemin hazırlayacaktır.

---

**TALEP:** Bu genişletilmiş ve anayasal olarak kilitlenmiş planın onaylanarak, **"ADIM 1: DOMAIN KATMANI İNŞASI"** görevinin başlatılması için nihai icra yetkisinin verilmesi talep edilmektedir.
