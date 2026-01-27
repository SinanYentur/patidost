# EKRAN SÖZLEŞMESİ (SCREEN CHARTER)

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md
- **NORM TÜRÜ:** Sözleşme
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §LXXIX, OFFLINE_SURVIVAL_POLICY
- **GEÇERLİ FAZLAR:** FAZ-B (İskelet İnşaatı), FAZ-C (Canlandırma)
- **BAĞLADIĞI ROLLER:** UI/UX, Android Studio AI, QA Automation
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## 1. EKRAN KİMLİĞİ

*   **Görsel ID / Dosya Adı:** `alarma.png`
*   **Ekran Adı (Ürün Dili):** `Alarmlar ve Hatırlatmalar`
*   **Anayasal Rota (Route ID):** `life.alarms`

## 2. KULLANICI ANI ve İŞ DEĞERİ

*   **Kullanıcı Anı:** Kullanıcının, evcil hayvanlarının mama, su, tuvalet, aşı gibi rutin ihtiyaçları için hatırlatıcılar kurduğu ve yönettiği alan.
*   **Çözülen Problem:** Evcil hayvan sahiplerinin, yoğun hayat temposu içinde hayvanlarının temel ihtiyaçlarını unutmasını veya aksatmasını önlemek.
*   **İş Değeri:** Kullanıcıların uygulamayı günlük bir yardımcı araç olarak benimsemesini sağlar, uygulama ile olan bağını güçlendirir ve hayvan refahını doğrudan destekler.

## 3. ANAYASAL STATÜ ve KAPSAM

*   **Son Kullanıcıya Çıkacak Mı:** Evet
*   **Veri Gerçeklik Kapsamı (Fake/Real):** REAL_DATA_REQUIRED. Kurulan alarmlar ve zamanlamaları gerçek ve cihaza özel olmalıdır.
*   **Play Store Etkisi:** `Orta` - Uygulamanın temel işlevlerinden biri olmasa da, vadedilen bu özelliğin çalışmaması veya yanlış çalışması (örn: alarmların çalmaması) kullanıcı güvenini sarsar.

## 4. FONKSİYONEL GEREKSİNİMLER

*   **Zorunlu Fonksiyonlar:**
    *   Yeni bir alarm/hatırlatıcı oluşturabilmeli (örn: Mama saati, Aşı tarihi).
    *   Mevcut alarmları listeleyebilmeli.
    *   Alarmları düzenleyebilmeli veya silebilmeli.
    *   Zamanı geldiğinde kullanıcıya bir bildirim (notification) göndermeli.
*   **Zorunlu Durumlar (States):**
    *   Boş (Hiç alarm kurulmamışsa).
    *   Liste Dolu (Kurulmuş alarmlar görünür).

## 5. BAĞLI OLDUĞU ANAYASA MADDELERİ

*   **OFFLINE_SURVIVAL_POLICY:** Bu ekranın temel işlevi olan alarmlar, cihaz internete bağlı değilken bile güvenilir bir şekilde çalışmak zorundadır. Bu, `WorkManager` veya `AlarmManager` gibi Android Framework bileşenlerinin kullanılmasını gerektirir.
*   **NOTIFICATION_GOVERNANCE:** Alarmların üreteceği bildirimler, kullanıcıyı rahatsız etmeyecek ve bilgilendirici olacak şekilde anayasal bildirim kurallarına uymalıdır.
*   **DATA_SOVEREIGNTY_LAW:** Alarm verileri, kullanıcıya aittir ve cihazda lokal olarak (örn: `Room` veya `DataStore`) saklanmalıdır.
