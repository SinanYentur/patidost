# İCRA ENVANTERİ (EXECUTION INVENTORY)

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

## 1. MODÜL BAĞLANIRLIK HARİTASI

*Bu bölüm, `gradle :app:dependencies` komutunun çıktısını yansıtır.*

| Kaynak Modül | Hedef Modül | Konfigürasyon (api/impl) | Durum (Görünüyor/Görünmüyor) |
| :--- | :--- | :--- | :--- |
| | | | |

## 2. FEATURE API YÜZEYİ

*Bu bölüm, her feature modülünün dışarıya açtığı `public` arayüzleri listeler.*

| Feature Modülü | Public API (Composable Fonksiyon) | Parametre Sözleşmesi |
| :--- | :--- | :--- |
| | | |

## 3. CONVENTION PLUGIN ETKİ MATRİSİ

*Bu bölüm, `buildSrc` içindeki her plugin'in hangi modüllere hangi yetenekleri kazandırdığını gösterir.*

| Convention Plugin | Uygulandığı Modül | Kazandırdığı Kimlik (Kotlin/Compose/Hilt) |
| :--- | :--- | :--- |
| | | |

## 4. GATE-M DURUMU

*   **Son Denetim ID:**
*   **Durum:** [AÇIK / KAPALI]
*   **Kanıt Dosyaları:**
    *   `BUILD_GRAPH_REPORT.md`: [Link]
    *   `APP_CLASSPATH_REPORT.txt`: [Link]
    *   `PUBLIC_API_SURFACE.md`: [Link]
    *   `BUILD_PROOF.log`: [Link]
