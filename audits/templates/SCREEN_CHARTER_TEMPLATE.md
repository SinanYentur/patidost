# EKRAN SÖZLEŞMESİ (SCREEN CHARTER)

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md
- **NORM TÜRÜ:** Sözleşme
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §LXXIX, §LXXX, §LXXXI
- **GEÇERLİ FAZLAR:** FAZ-B (İskelet İnşaatı), FAZ-C (Canlandırma)
- **BAĞLADIĞI ROLLER:** UI/UX, Android Studio AI, QA Automation
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## 1. EKRAN KİMLİĞİ

*   **Görsel ID / Dosya Adı:** [Örn: `01_login_screen.png`]
*   **Ekran Adı (Ürün Dili):** [Örn: `Giriş Ekranı`]
*   **Anayasal Rota (Route ID):** [Örn: `auth.login`]

## 2. KULLANICI ANI ve İŞ DEĞERİ

*   **Kullanıcı Anı:** [Örn: `Kullanıcı, uygulamayı ilk kez açtığında veya oturumu kapandığında karşılaştığı ilk ekran.`]
*   **Çözülen Problem:** [Örn: `Kullanıcının sisteme güvenli bir şekilde kimliğini doğrulayarak girmesini sağlamak.`]
*   **İş Değeri:** [Örn: `Kullanıcıları sisteme dahil ederek etkileşim ve değer üretimini başlatmak.`]

## 3. ANAYASAL STATÜ ve KAPSAM

*   **Son Kullanıcıya Çıkacak Mı:** [Evet / Hayır]
*   **Veri Gerçeklik Kapsamı (Fake/Real):** [FAKE_ONLY / PRE-REAL / REAL_DATA_REQUIRED]
*   **Play Store Etkisi:** [Düşük / Orta / Yüksek / Kritik - Örn: `Kritik - Uygulamanın giriş kapısı olduğu için çalışmaması, kullanıcıyı tamamen engeller.`]

## 4. FONKSİYONEL GEREKSİNİMLER

*   **Zorunlu Fonksiyonlar:**
    *   [Örn: `Kullanıcı adı ve şifre ile giriş yapabilmeli.`]
    *   [Örn: `"Şifremi Unuttum" akışını başlatabilmeli.`]
    *   [Örn: `"Kayıt Ol" ekranına yönlendirebilmeli.`]
*   **Zorunlu Durumlar (States):**
    *   [Örn: `Boş (Initial) Durum`]
    *   [Örn: `Yükleniyor (Loading) Durumu`]
    *   [Örn: `Hata (Error) Durumu - Yanlış şifre`]
    *   [Örn: `Başarı (Success) Durumu`]

## 5. BAĞLI OLDUĞU ANAYASA MADDELERİ

*   [Örn: `UI_REALITY_LAW - Bu ekranın veri gerçekliği FAKE_ONLY olarak tanımlanmıştır.`]
*   [Örn: `SECURITY_LAW - Şifre alanı güvenli giriş kurallarına uymalıdır.`]
