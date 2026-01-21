# KANIT RAPORU: Küresel Körlük - "Sonra Ekleriz" Hukuk Dogması

**PROTOKOL ID:** AI-GLOBAL-ULTRA-PRO
**KANIT ID:** E-GB-005
**DÖNGÜ:** 5/50

## 1. Körlük Tanımı

**"Sonra Ekleriz" Hukuk Dogması:** "Önce ürünü çıkaralım, GDPR/KVKK gibi yasal işlere sonra bakarız" zihniyeti. Bu dogma, kullanıcı verilerini (profil bilgileri, konum, e-posta) topladıktan sonra bu verilerin nasıl saklandığı, kimin erişebildiği, nasıl silineceği ve yasalara uygun olarak nasıl yönetileceği konusunda bir plan olmamasını ifade eder. Bu, iflasa veya ağır yasal yaptırımlara yol açabilecek en tehlikeli körlüklerden biridir.

## 2. Kanıtlar ve Anayasal Sonuçlar

*   **Kanıt Referansı 1:** `developers/admob/android/privacy/gdpr` ve `developers/admob/android/privacy/us-states` (Önceki aramadan çapraz referans)
    *   **Bulgu:** Arama sonuçları doğrudan uygulama mimarisi hakkında olmasa da, Google'ın reklamcılık (AdMob) gibi bir servisi için dahi GDPR ve ABD eyalet yasalarına uyum sağlamak üzere detaylı kılavuzlar ve SDK'lar sunduğunu göstermektedir.
    *   **Anayasal Sonuç:** Bu, veri gizliliğinin ve yasal uyumun, uygulamanın en küçük ve en dış katmanlarında bile ne kadar kritik olduğunun dolaylı ama güçlü bir kanıtıdır. Eğer bir reklam SDK'sı bu kadar katı kurallara tabi ise, uygulamanın çekirdek veri yönetimi çok daha katı olmak zorundadır. Bu, "Privacy-by-Design" (Tasarım Odaklı Gizlilik) ilkesinin zorunluluğunu ortaya koyar.

*   **Anayasal Sentez (Kanıt Boşluğundan Çıkarım):** Android'in temel dokümantasyonunda "Uygulamanızı GDPR'a nasıl uyumlu hale getirirsiniz" şeklinde tek bir merkezi kılavuzun olmaması, bu sorumluluğun platformdan ziyade **uygulama geliştiricisine ait olduğunun** en büyük kanıtıdır. Platform, araçları (şifreleme API'leri, izinler) sağlar, ancak mimariyi kurmak geliştiricinin görevidir.

## 3. Anayasal Kural Seti

1.  **VERİ YAŞAM DÖNGÜSÜ (DATA LIFECYCLE) SÖZLEŞMESİ ZORUNLULUĞU:** Daha tek bir veri modeli oluşturulmadan önce, `.dna/security/DATA_LIFECYCLE.spec` adında bir anayasal sözleşme dosyası oluşturulacaktır. Bu dosya, toplanacak her bir veri parçası (örn: `User.email`, `Pet.location`) için aşağıdaki bilgileri tanımlamak zorundadır:
    *   **Amaç (Purpose):** Bu veri neden toplanıyor?
    *   **Saklama Süresi (Retention Period):** Bu veri ne kadar süreyle saklanacak? (örn: "Hesap aktif olduğu sürece", "İşlemden 90 gün sonra").
    *   **Erişim Kontrolü (Access Control):** Bu veriye kimler (kullanıcı, arkadaşlar, sistem yöneticisi) erişebilir?
    *   **Silinme Mekanizması (Erasure Mechanism):** Kullanıcı hesabını sildiğinde veya "unutulma hakkı"nı kullandığında bu veri nasıl kalıcı olarak yok edilecek?

2.  **ŞİFRELEME (ENCRYPTION) ZORUNLULUĞU:** Cihazda saklanan ve kişisel olarak tanımlanabilir tüm veriler (PII), Android'in `Security` (Jetpack) kütüphanesi kullanılarak şifrelenmiş dosyalarda (`EncryptedSharedPreferences`) veya şifrelenmiş bir veritabanında tutulmak zorundadır. Hassas verileri düz metin olarak saklamak anayasal suçtur.

3.  **KULLANICI RIZASI (USER CONSENT) YÖNETİMİ ZORUNLULUĞU:** Kullanıcıdan veri toplanmadan önce, hangi verinin neden toplandığını açıkça belirten bir rıza metni sunulmalı ve bu rıza kaydedilmelidir. Kullanıcı, verdiği rızayı istediği zaman geri çekebilmelidir.

4.  **VERİ MİNİMİZASYONU (DATA MINIMIZATION) İLKESİ:** Sadece uygulamanın çalışması için kesinlikle gerekli olan minimum veri toplanacaktır. "Belki ilerde lazım olur" diyerek fazladan veri toplamak yasaktır.
