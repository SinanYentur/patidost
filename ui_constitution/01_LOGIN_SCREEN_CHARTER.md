# EKRAN SÖZLEŞMESİ (SCREEN CHARTER)

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md
- **NORM TÜRÜ:** Sözleşme
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §LXXIX, §LXXX, UI_REALITY_LAW
- **GEÇERLİ FAZLAR:** FAZ-B (İskelet İnşaatı), FAZ-C (Canlandırma)
- **BAĞLADIĞI ROLLER:** UI/UX, Android Studio AI, QA Automation, Security
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## 1. EKRAN KİMLİĞİ

*   **Görsel ID / Dosya Adı:** `loginekrania.png`
*   **Ekran Adı (Ürün Dili):** `Giriş Ekranı`
*   **Anayasal Rota (Route ID):** `auth.login`

## 2. KULLANICI ANI ve İŞ DEĞERİ

*   **Kullanıcı Anı:** Kullanıcı, uygulamayı ilk kez açtığında veya oturumu kapandığında karşılaştığı, kimlik doğrulama gerektiren giriş kapısıdır.
*   **Çözülen Problem:** Kullanıcının sisteme güvenli bir şekilde kimliğini doğrulayarak girmesini sağlamak.
*   **İş Değeri:** Kullanıcıları sisteme dahil ederek etkileşim ve değer üretimini başlatmak. Güvenliğin ilk katmanıdır.

## 3. ANAYASAL STATÜ ve KAPSAM

*   **Son Kullanıcıya Çıkacak Mı:** Evet
*   **Veri Gerçeklik Kapsamı (Fake/Real):** REAL_DATA_REQUIRED (Kullanıcı adı ve şifre gerçek olmalıdır)
*   **Play Store Etkisi:** `Kritik` - Uygulamanın giriş kapısı olduğu için çalışmaması, kullanıcıyı tamamen engeller.

## 4. FONKSİYONEL GEREKSİNİMLER

*   **Zorunlu Fonksiyonlar:**
    *   Email ve Şifre ile giriş yapabilmeli.
    *   "Şifremi Unuttum" akışını başlatabilmeli.
    *   "Kayıt Ol" ekranına yönlendirebilmeli.
    *   Google ile giriş yapabilmeli.
    *   Facebook ile giriş yapabilmeli.
*   **Zorunlu Durumlar (States):**
    *   Boş (Initial) Durum
    *   Yükleniyor (Loading) Durumu
    *   Hata (Error) Durumu (örn: Yanlış şifre, Kullanıcı bulunamadı)
    *   Başarı (Success) Durumu (ve ana ekrana yönlendirme)

## 5. BAĞLI OLDUĞU ANAYASA MADDELERİ

*   **SECURITY_LAW:** Şifre alanı güvenli giriş kurallarına uymalı, ağ trafiği şifreli olmalıdır.
*   **PRIVACY_LAW:** Kullanıcı verilerinin (email) neden toplandığına dair bir link içermelidir.
*   **UI_REALITY_LAW:** Bu ekranda `FAKE` veri kullanılması kesinlikle yasaktır.
