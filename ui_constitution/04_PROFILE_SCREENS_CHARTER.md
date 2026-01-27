# EKRAN SÖZLEŞMESİ (SCREEN CHARTER) - BİRLEŞİK PROFİL

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md
- **NORM TÜRÜ:** Sözleşme
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §LXXIX, PRIVACY_LAW
- **GEÇERLİ FAZLAR:** FAZ-B (İskelet İnşaatı), FAZ-C (Canlandırma)
- **BAĞLADIĞI ROLLER:** UI/UX, Android Studio AI, QA Automation, Security, Data Governance
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## 1. EKRAN KİMLİĞİ

*   **Görsel ID / Dosya Adı:** `profilkullanici.png`, `profilkullaniciiki.png`, `petsprofil_ekrani.png`
*   **Ekran Adı (Ürün Dili):** `Profil Ekranları (Kullanıcı ve Evcil Hayvan)`
*   **Anayasal Rota (Route ID):** `profile.user`, `profile.pet`

## 2. KULLANICI ANI ve İŞ DEĞERİ

*   **Kullanıcı Anı:** Kullanıcının kendi kişisel bilgilerini, ayarlarını ve sahip olduğu evcil hayvanların profillerini görüntülediği, oluşturduğu ve düzenlediği merkezi alan.
*   **Çözülen Problem:** Kullanıcı ve evcil hayvan kimliklerinin dijital olarak yönetilmesi. Güven oluşturmak için şeffaf ve doğrulanabilir profil bilgileri sağlamak.
*   **İş Değeri:** Kullanıcı bağlılığının merkezidir. Veri bütünlüğünü ve topluluk güvenini sağlar. "Pati Puanı" gibi ekonomi sistemleri için temel veri kaynağıdır.

## 3. ANAYASAL STATÜ ve KAPSAM

*   **Son Kullanıcıya Çıkacak Mı:** Evet
*   **Veri Gerçeklik Kapsamı (Fake/Real):** REAL_DATA_REQUIRED. Bu ekranlarda gösterilen tüm veriler (kullanıcı adı, pet resmi vb.) gerçek ve kullanıcıya ait olmalıdır.
*   **Play Store Etkisi:** `Kritik` - Kullanıcı verilerinin işlendiği ana ekranlardır. Yanlış veya güvensiz veri işleme, Play Store politikalarının ve KVKK/GDPR gibi yasaların doğrudan ihlaline yol açar.

## 4. FONKSİYONEL GEREKSİNİMLER

*   **Zorunlu Fonksiyonlar (Kullanıcı Profili):**
    *   Kullanıcı profil resmini, adını ve diğer kişisel bilgilerini görüntüleyebilmeli.
    *   Profil bilgilerini düzenleyebilmeli.
    *   Uygulama ayarları (bildirimler, gizlilik) ekranına yönlendirebilmeli.
    *   Sistemen çıkış yapabilmeli (Logout).
*   **Zorunlu Fonksiyonlar (Evcil Hayvan Profili):**
    *   Yeni bir evcil hayvan profili oluşturabilmeli.
    *   Mevcut evcil hayvan profillerini listeleyebilmeli ve düzenleyebilmeli.
    *   Profilde hayvanın resimleri, adı, cinsi, yaşı, sağlık bilgileri (aşılar vb.) yer almalı.
*   **Zorunlu Durumlar (States):**
    *   Yükleniyor (Profil verileri çekilirken)
    *   Boş (Henüz hiç evcil hayvan eklenmemişse)
    *   İçerik Dolu (Profil bilgileri görünür)
    *   Hata (Veri çekilemediğinde)

## 5. BAĞLI OLDUĞU ANAYASA MADDELERİ

*   **PRIVACY_LAW & DATA_PROTECTION_MAP:** Bu ekranlar, kullanıcı verilerinin işlendiği en hassas alanlardır. Tüm veri toplama ve gösterme işlemleri bu hukuka uygun olmalıdır.
*   **USER_ENTITY_MODEL & PET_ENTITY_MODEL:** Bu ekranlarda gösterilecek veri yapıları, bu anayasal modellerle birebir uyumlu olmalıdır.
*   **UI_REALITY_LAW:** Bu ekranlarda FAKE veri kullanımı kesinlikle yasaktır. Sadece `PRE-REAL` (kullanıcının girdiği ama henüz kaydedilmemiş veri) veya `REAL` veri gösterilebilir.
*   **ABUSE_PREVENTION_LAW:** Sahte veya yanıltıcı profil oluşturmayı engelleyecek mekanizmalar (örn: fotoğraf analizi) bu ekranların backend entegrasyonunda düşünülmelidir.
