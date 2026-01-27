# EKRAN SÖZLEŞMESİ (SCREEN CHARTER)

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md
- **NORM TÜRÜ:** Sözleşme
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §LXXIX, §LXXX, UI_REALITY_LAW
- **GEÇERLİ FAZLAR:** FAZ-B (İskelet İnşaatı), FAZ-C (Canlandırma)
- **BAĞLADIĞI ROLLER:** UI/UX, Android Studio AI, QA Automation, Data Scientist
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## 1. EKRAN KİMLİĞİ

*   **Görsel ID / Dosya Adı:** `homeekrani.png`, `homeiki_ekran.png`, `swipea.png`
*   **Ekran Adı (Ürün Dili):** `Keşfet`
*   **Anayasal Rota (Route ID):** `discovery.feed`

## 2. KULLANICI ANI ve İŞ DEĞERİ

*   **Kullanıcı Anı:** Kullanıcının, potansiyel olarak sahiplenebileceği veya kendi evcil hayvanına arkadaş olabilecek diğer evcil hayvan profillerini bir kart destesi arayüzüyle keşfettiği ana etkileşim ekranı.
*   **Çözülen Problem:** Kullanıcılara, ilgi alanlarına ve tercihlerine uygun olabilecek çok sayıda evcil hayvanı hızlı ve etkileşimli bir şekilde sunmak.
*   **İş Değeri:** Uygulamanın temel değer önerisinin (keşif ve eşleştirme) merkezidir. Kullanıcı etkileşimini ve uygulamada kalma süresini doğrudan artırır.

## 3. ANAYASAL STATÜ ve KAPSAM

*   **Son Kullanıcıya Çıkacak Mı:** Evet
*   **Veri Gerçeklik Kapsamı (Fake/Real):** Backend öncesi FAKE_ONLY, Backend sonrası REAL_DATA_REQUIRED.
*   **Play Store Etkisi:** `Kritik` - Uygulamanın ana fonksiyonudur. Bu ekranın yanlış çalışması veya boş olması, uygulamanın amacını tamamen ortadan kaldırır.

## 4. FONKSİYONEL GEREKSİNİMLER

*   **Zorunlu Fonksiyonlar:**
    *   Evcil hayvan profillerini bir kart destesi olarak göstermeli.
    *   Kullanıcı kartı sağa kaydırarak "beğenme" (like) eylemini gerçekleştirebilmeli.
    *   Kullanıcı kartı sola kaydırarak "pas geçme" (pass) eylemini gerçekleştirebilmeli.
    *   İki kullanıcının karşılıklı beğenmesi durumunda bir "eşleşme" (match) durumu oluşmalı ve bu kullanıcıya bildirilmeli (`swipea.png`).
    *   Bir kartın üzerine tıklandığında, o hayvanın detay sayfasına yönlendirmeli.
*   **Zorunlu Durumlar (States):**
    *   Boş (Gösterilecek hayvan kalmadığında)
    *   Yükleniyor (İlk açılışta veya yeni kartlar yüklenirken)
    *   Hata (Veri çekilemediğinde)
    *   İçerik Dolu (Kart destesi görünür)
    *   Eşleşme (Match animasyonu/ekranı)

## 5. BAĞLI OLDUĞU ANAYASA MADDELERİ

*   **UI_REALITY_LAW:** Bu ekranın Backend öncesi fazda FAKE veri ile çalışacağı, ancak canlıda REAL veri gerektireceği açıkça tanımlanmalıdır.
*   **PSYCHOLOGICAL_IMPACT_LAW:** Kart kaydırma mekaniği ve eşleşme bildirimleri, bağımlılık yaratıcı "dark pattern"ler içermemelidir. Etik denetime tabidir.
*   **RANKING_FAIRNESS_PROTOCOL:** Hayvan profillerinin gösterilme sırası, adil ve şeffaf bir algoritmaya dayanmalıdır.
