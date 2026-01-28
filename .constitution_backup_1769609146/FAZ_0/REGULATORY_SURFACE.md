# FAZ-0: REGÜLASYON YÜZEYİ (REGULATORY_SURFACE.md)

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** GLOBAL_PRE_EMPTIVE_CONSTITUTION.md
- **NORM TÜRÜ:** Hukuki Sözleşme
- **ANAYASAL KAYIT ID:** PIN-005

---

## AMAÇ: "DOĞMADAN ÖNCE HUKUK"

Bu belge, Patidost projesinin uymak zorunda olduğu temel yasal ve düzenleyici çerçeveleri tanımlar. Bu çerçeveye uymayan hiçbir özellik veya veri modeli, sistem evreninde varlık kazanamaz.

## BÖLÜM 1: UYGULANACAK HUKUK SİSTEMLERİ

*   **KVKK (Kişisel Verilerin Korunması Kanunu):** Türkiye Cumhuriyeti vatandaşlarının verileri için geçerli olan birincil hukuk sistemi.
*   **GDPR (General Data Protection Regulation):** Avrupa Birliği vatandaşlarının verileri için geçerli olan ikincil hukuk sistemi.
*   **COPPA (Children's Online Privacy Protection Act):** 13 yaş altı kullanıcı verileri için geçerli olan (varsa) üçüncül hukuk sistemi.

## BÖLÜM 2: VERİ SINIFLANDIRMASI VE RİSK MATRİSİ

| Veri Türü | Örnek | Hassasiyet | Hukuki Risk | Anayasal Önlem |
| :--- | :--- | :--- | :--- | :--- |
| **Kişisel Kimlik Bilgisi (PII)** | Email, Ad, Soyad | **KRİTİK** | Yüksek | Şifreli saklama, Sınırlı erişim |
| **Konum Verisi** | GPS koordinatları | **KRİTİK** | Yüksek | Sadece anlık kullanım, Asla depolamama |
| **Kullanıcı Üretimi İçerik (UGC)** | Pet profili, Mesajlar | Yüksek | Orta | Moderasyon, Şikayet mekanizması |
| **Davranışsal Veri** | Swipe, Tıklama | Orta | Düşük | Anonimleştirme, Toplulaştırma |

## BÖLÜM 3: YASAKLI VERİ TOPLAMA

Sistem, kullanıcının açık ve bilgilendirilmiş rızası olmadan aşağıdaki verileri **ASLA** toplayamaz, işleyemez veya saklayamaz:

*   Cihazdaki diğer uygulamaların listesi.
*   Kişi listesi (Rehber).
*   Kesin ve sürekli arka plan konumu.
*   Mikrofon veya kamera erişimi (kullanıcı tarafından başlatılan bir eylem dışında).

---
**YAPTIRIM:** Bu sözleşmeyi ihlal eden her türlü kod, plan veya talep, `PRE_GENESIS_CONSTITUTION` uyarınca **doğmadan önce yok hükmündedir**.
