# PROJE CHIMERA - ANAYASAL DEVİR VE MİRAS PROTOKOLÜ (v1.0)

## GİRİŞ

Bu belge, "PROJE CHIMERA" fabrikasının sahipliğinin, yönetiminin ve kritik güvenlik varlıklarının, birincil operatörün yokluğunda veya yetki devri durumunda, başka bir kişiye nasıl güvenli ve anayasal olarak aktarılacağını tanımlar. Bu protokolün amacı, "Otobüs Faktörü"nü (Bus Factor) ortadan kaldırmaktır.

## 1. GİTHUB SECRETS'İN GÜVENLİ YEDEKLEMESİ VE DEVREDİLMESİ

**RİSK:** `ANDROID_KEYSTORE_BASE64` gibi kritik sırlar, sadece GitHub arayüzünde saklanır. Birincil operatörün hesabına erişim kaybedilirse, fabrika **sonsuza kadar kilitlenir**.

**Protokol:**

1.  **Yedekleme:** Tüm GitHub Secrets (`KEYSTORE_PASSWORD`, `ANDROID_KEYSTORE_BASE64` vb.), **1Password, Bitwarden** gibi güvenli, şifre korumalı bir "vault" (kasa) uygulamasına kopyalanır.
2.  **Acil Durum Erişimi:** Bu vault uygulamasının "Acil Durum Erişimi" (Emergency Access) özelliği kullanılır. Bu özellik, belirlediğiniz güvenilir bir ikinci kişiye (varis), sizin belirlediğiniz bir bekleme süresi sonunda (örn: 30 gün) vault'a erişim hakkı tanır.
3.  **Devir:** Yetki devri planlı ise, sırlar doğrudan yeni operatöre bu güvenli vault üzerinden aktarılır. Yeni operatör, bu sırları kendi GitHub hesabındaki repo ayarlarına yeniden girer.

## 2. GİTHUB REPOSITORY SAHİPLİĞİNİN DEVREDİLMESİ

**RİSK:** Proje deposu, birincil operatörün kişisel hesabına bağlıysa, o hesaba erişim kaybedildiğinde proje sahipsiz kalır.

**Protokol:**

1.  **Organizasyon Kurulumu:** Proje, kişisel bir hesap yerine, bir **GitHub Organizasyonu** altında barındırılmalıdır.
2.  **Çoklu Sahip (Owner):** Bu organizasyona, en az iki farklı kişi "Owner" (Sahip) rolüyle eklenmelidir. Bu, bir hesabın kaybedilmesi durumunda diğerinin tam yetkiyle devam etmesini sağlar.
3.  **Devir:** Yetki devri durumunda, yeni operatör bu organizasyona "Owner" olarak eklenir ve eski operatör (istenirse) rolden çıkarılır.

## 3. FABRİKA YÖNETİM BİLGİSİNİN (KNOW-HOW) DEVREDİLMESİ

**RİSK:** Fabrikanın nasıl çalıştığı, komutların ne anlama geldiği ve kriz anında ne yapılacağı sadece bir kişinin zihnindedir.

**Protokol:**

1.  **Canlı Belgeler:** Bu `governance` klasöründeki belgeler (`FABRIKA_OPERATOR_KILAVUZU.md`, `IMPARATORLUK_KRİZ_YONETIMI.md`) her zaman güncel tutulur.
2.  **Devir Süreci:**
    *   Yeni operatöre bu belgeler okutulur.
    *   Yeni operatörle birlikte, "Yeni Bir Proje Doğurma" ve "CI/CD Başarısızlık Senaryosu" gibi temel operasyonlar pratik olarak uygulanır.
    *   Yeni operatörün, anayasal `commit` mesajı formatını (`feat: [CORE-XXX][PATI-XXX]...`) anladığından ve uyguladığından emin olunur.

Bu protokol, fabrikanın sadece koddan değil, aynı zamanda bilgi ve yetkiden oluşan bir bütün olduğunu ve bu bütünün, kişilerden bağımsız olarak hayatta kalabileceğini garanti altına alır.
