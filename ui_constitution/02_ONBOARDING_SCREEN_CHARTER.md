# EKRAN SÖZLEŞMESİ (SCREEN CHARTER)

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md
- **NORM TÜRÜ:** Sözleşme
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §LXXIX, §LXXX, UI_REALITY_LAW
- **GEÇERLİ FAZLAR:** FAZ-B (İskelet İnşaatı), FAZ-C (Canlandırma)
- **BAĞLADIĞI ROLLER:** UI/UX, Android Studio AI, QA Automation, Legal
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## 1. EKRAN KİMLİĞİ

*   **Görsel ID / Dosya Adı:** `loginsonrasi.png`
*   **Ekran Adı (Ürün Dili):** `Onboarding / Kullanıcı Sözleşmesi`
*   **Anayasal Rota (Route ID):** `auth.onboarding`

## 2. KULLANICI ANI ve İŞ DEĞERİ

*   **Kullanıcı Anı:** Kullanıcının başarılı bir kimlik doğrulama sonrası karşılaştığı, uygulamanın temel kurallarını ve kullanım koşullarını kabul ettiği ekran.
*   **Çözülen Problem:** Kullanıcı ile platform arasında yasal ve operasyonel bir sözleşme akdetmek. Kullanıcıyı ana uygulama deneyimine hazırlamak.
*   **İş Değeri:** Hukuki uyumluluğu sağlar, kullanıcı beklentilerini yönetir ve ana uygulama akışına geçiş için son kapıdır.

## 3. ANAYASAL STATÜ ve KAPSAM

*   **Son Kullanıcıya Çıkacak Mı:** Evet
*   **Veri Gerçeklik Kapsamı (Fake/Real):** REAL_DATA_REQUIRED (Gösterilen sözleşme metinleri ve kullanıcının onayı gerçek olmalıdır).
*   **Play Store Etkisi:** `Kritik` - Kullanıcı sözleşmelerinin ve gizlilik politikasının sunulması, Play Store politikaları gereği zorunludur. Bu adımın atlanması uygulamanın askıya alınmasına neden olabilir.

## 4. FONKSİYONEL GEREKSİNİMLER

*   **Zorunlu Fonksiyonlar:**
    *   Kullanım Koşulları metnini gösterebilmeli.
    *   Gizlilik Politikası metnini gösterebilmeli.
    *   Kullanıcının sözleşmeleri onaylaması için bir kabul butonu bulunmalı.
    *   Kabul sonrası ana uygulama akışına yönlendirmeli.
*   **Zorunlu Durumlar (States):**
    *   Yükleniyor (Sözleşme metinleri çekilirken)
    *   Hazır (Metinler ve butonlar görünür)
    *   Hata (Sözleşme metinleri yüklenemezse)

## 5. BAĞLI OLDUĞU ANAYASA MADDELERİ

*   **PRIVACY_LAW / REGULATORY_SCOPE:** Bu ekran, projenin gizlilik ve regülasyon uyumunun merkezindedir.
*   **UI_REALITY_LAW:** Bu ekranda gösterilen metinler `FAKE` olamaz. Canlı ve geçerli hukuki metinler olmalıdır.
*   **USER_TRUST_MODEL:** Kullanıcıya şeffaf bir sözleşme sunmak, güven modelinin temelini oluşturur.
