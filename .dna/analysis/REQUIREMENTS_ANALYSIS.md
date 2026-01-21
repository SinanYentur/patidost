# GEREKSİNİM ANALİZİ RAPORU (Roadmap Analizi)

**PROTOKOL ID:** ANAYASA-ICRA: KANITLI-USTALIK
**ADIM:** 1/5

## 1. Anahtar Kelime ve Domain Çıkarımı

Sağlanan `PatiDost Ana Yol Haritası (A+++)` metni üzerinde yapılan NLP analizi sonucunda aşağıdaki temel konseptler ve domain'ler çıkarılmıştır:

*   **Anahtar Kelimeler:** `Pati Puanı`, `Super Like`, `Gold Üyelik Kaldırıldı`, `swipe`, `pet profili`, `kullanıcı profili`, `DM (Direct Message)`, `Post`, `Like`, `Yorum`, `Pet Alarmları`, `Bildirim`, `Abuse`, `Scam`, `Fraud`.

*   **Domain Haritası (Roadmap'ten Doğrulanan):** `User`, `Pet`, `Social` (Post, Like, Comment), `Communication` (DM, Notification), `Discovery` (Swipe, Ranking), `Adoption`, `Economy` (Pati Puanı, Wallet, Transaction), `Moderation` (Abuse, Fraud), `Life` (Alarms, Reminders).

## 2. Fonksiyonel Olmayan Gereksinimler

Metin, sadece özellikleri değil, aynı zamanda sistemin uyması gereken temel kuralları da tanımlamaktadır:

*   **Ekonomi Modeli:** Uygulama içi ekonomi, gerçek para birimi yerine geçen bir yapı değildir ("değer sinyali"). Sınırlı, izlenen ve muhasebeleşmiş bir sistem olmalıdır.
*   **Güvenlik ve Dayanıklılık:** `Abuse`, `dolandırıcılık`, `çoklu hesap`, `scam` gibi tehditler, sistemin çekirdek riski olarak kabul edilmiştir. Sistem, bu tehditlere karşı dayanıklı olmalıdır (`Global Sertleştirme` Fazı).
*   **Küresel Farkındalık:** Sağlanan ek `GLOBAL-ZERO-BLINDNESS-v3.0` protokolü, projenin `Zaman Dilimi`, `Tercüme (Plurals, RTL)`, `Kültürel Hassasiyet` ve `Ağ Optimizmi` gibi küresel körlüklere karşı en başından donanımlı olması gerektiğini anayasal bir zorunluluk haline getirmektedir.

## 3. Mimariyi Etkileyecek Anahtar Çıkarımlar

*   **Karmaşık State Yönetimi:** `Pati Puanı` ekonomisi (günlük 5 ücretsiz, cüzdan, harcama), bildirimler ve alarmlar, uygulamanın anlık durumunun (state) dikkatli ve tutarlı bir şekilde yönetilmesini gerektirir.
*   **Çevrimdışı (Offline) Yeteneği:** `Pet Alarmları` ve `Hatırlatmalar` gibi özelliklerin, cihaz çevrimdışı iken bile güvenilir bir şekilde çalışması gerekir.
*   **Veri Bütünlüğü:** `Pati Transaction Ledger` (işlem kaydı) ve `muhasebeleşmiş` ekonomi, veritabanı işlemlerinde atomiklik ve tutarlılık (ACID prensipleri) gerektirir.
*   **Modülerlik:** `DOMAIN HARİTASI`nda belirtilen `User`, `Pet`, `Social`, `Economy` gibi birbirinden ayrı domain'ler, sistemin modüler bir yapıda tasarlanmasını doğal olarak teşvik eder.
