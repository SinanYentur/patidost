# İCRA ENVANTERİ (EXECUTION INVENTORY) v1.0

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** ANAYASAL_EK_PROTOKOL.md
- **NORM TÜRÜ:** Anayasal Kayıt
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §III
- **GEÇERLİ FAZLAR:** Tüm Fazlar
- **BAĞLADIĞI ROLLER:** Android Studio AI, Denetçiler, CI/CD
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Otomatik Güncellenir (İnsan müdahalesi yasaktır)

---

*Bu belge, projenin derleme anındaki fiziksel gerçekliğinin tekil kaydıdır. Dokümanlardaki beyanlar değil, bu envanterdeki durum esastır.*

## 0. ANAYASAL VARLIK ENVANTERİ (Hukuki Statü)

| Varlık ID | Anayasal Tür | Fiziksel Yol | Durum |
| :--- | :--- | :--- | :--- |
| `SC-01` | Sözleşme | `/ui_constitution/01_LOGIN_SCREEN_CHARTER.md` | Tanımlandı |
| `SC-02` | Sözleşme | `/ui_constitution/02_ONBOARDING_SCREEN_CHARTER.md` | Tanımlandı |
| `SC-03` | Sözleşme | `/ui_constitution/03_DISCOVERY_SCREEN_CHARTER.md` | Tanımlandı |
| `SC-04` | Sözleşme | `/ui_constitution/04_PROFILE_SCREENS_CHARTER.md` | Tanımlandı |
| `SC-05` | Sözleşme | `/ui_constitution/05_ALARMS_SCREEN_CHARTER.md` | Tanımlandı |

## 1. MODÜL BAĞLANIRLIK HARİTASI

*Bu bölüm, `gradle :app:dependencies` komutunun çıktısını yansıtır.*

| Kaynak Modül | Hedef Modül | Konfigürasyon (api/impl) | Durum (Görünüyor/Görünmüyor) |
| :--- | :--- | :--- | :--- |
| `:app` | `:feature:auth` | `implementation` | **Bilinmiyor** |
| `:app` | `:feature:discovery` | `implementation` | **Bilinmiyor** |
| `:app` | `:feature:pet_detail`| `implementation` | **Bilinmiyor** |
| `:app` | `:feature:profile` | `implementation` | **Bilinmiyor** |

## 2. FEATURE API YÜZEYİ

*Bu bölüm, her feature modülünün dışarıya açtığı `public` arayüzleri listeler.*

| Feature Modülü | Public API (Composable Fonksiyon) | Durum |
| :--- | :--- | :--- |
| `:feature:auth` | `AuthScreen` | **Doğrulanmadı** |
| `:feature:discovery` | `DiscoveryScreen` | **Doğrulanmadı** |
| `:feature:profile` | `ProfileScreen` | **Doğrulanmadı** |
| `:feature:pet_detail` | `PetDetailScreen` | **Doğrulanmadı** |

## 3. CONVENTION PLUGIN ETKİ MATRİSİ

*Bu bölüm, `buildSrc` içindeki her plugin'in hangi modüllere hangi yetenekleri kazandırdığını gösterir.*

| Convention Plugin | Uygulandığı Modül | Kazandırdığı Kimlik |
| :--- | :--- | :--- |
| `patidost.android.application` | `:app` | Kotlin, Compose, Hilt |
| `patidost.android.library` | `:core:*`, `:feature:*` | Kotlin, Compose, Hilt |

## 4. GATE-M DURUMU

*   **Son Denetim ID:** Yok
*   **Durum:** **KAPALI**
*   **Kanıt Dosyaları:** Henüz Üretilmedi
