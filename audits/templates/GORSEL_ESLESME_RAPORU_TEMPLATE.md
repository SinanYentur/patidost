# GÖRSEL EŞLEŞME RAPORU

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır. İçeriğindeki boşluklar doldurulmadan ilgili kod parçası Commit edilemez.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** ANAYASAL_EK_PROTOKOL.md, UI_REALITY_LAW.md
- **NORM TÜRÜ:** Kanıt (Gate-M ve GATE-PS Delili)
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §II, PLAY_STORE_LAW §I
- **GEÇERLİ FAZLAR:** FAZ-C (Canlandırma), Sürüm Öncesi
- **BAĞLADIĞI ROLLER:** QA Automation, Android Studio AI, Denetçiler
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Otomatik Üretilir ve Mühürlenir

---

## 1. DENETİM KAPSAMI

*   **Ekran ID:** [Örn: `HOME_FEED`]
*   **Referans Görsel:** [Örn: `/ui_references/02_home_feed.png`]
*   **Referans Görsel Hash:** [SHA256 Hash]

## 2. OTOMATİK EŞLEŞME SONUCU (Piksel Karşılaştırması)

*   **Canlı Ekran Görüntüsü Hash:** [SHA256 Hash]
*   **Piksel Eşleşme Oranı:** [Örn: `%99.2`]
*   **Anayasal Eşik:** `%98.0`
*   **Sonuç:** [GEÇTİ / KALDI]

## 3. DİNAMİK ALAN MASKLEME PROTOKOLÜ

_Anayasal Referans: Denetçi-2 Zorunlu Düzeltme Talebi_

Bu denetim, piksellerin birebir aynı olmasını değil, **yapısal ve hiyerarşik bütünlüğün** korunmasını hedefler. Bu amaçla, aşağıdaki dinamik alanlar karşılaştırma sırasında otomatik olarak maskelenir ve denetim dışı bırakılır:

*   **Tüm Metin Alanları:** Kullanıcı adları, pet isimleri, tarihler, sayılar, vb.
*   **Tüm Avatarlar ve Profil Resimleri:** `AsyncImage`, `Image` gibi uzaktan yüklenen tüm görseller.
*   **Tüm Sayaçlar:** Beğeni, yorum, puan vb. dinamik sayılar.
*   **Durum Çubuğu (Status Bar):** Saat, pil, sinyal gücü gibi sistemsel ikonlar.

Karşılaştırma, bu alanlar maskelendikten sonra kalan **layout iskeleti (padding, margin, alignment, bileşen konumları, renk paleti)** üzerinden yapılır.

## 4. MANUEL AKIŞ TESTİ SONUCU

*   **Test Senaryosu:** [Örn: `Kullanıcı, kartı sağa kaydırdığında kartın kaybolması.`]
*   **Beklenen Davranış:** [Örn: `Kart ekran dışına çıkar ve yeni kart gelir.`]
*   **Gözlemlenen Davranış:** [Örn: `Kart ekran dışına çıkar ve yeni kart gelir.`]
*   **Sonuç:** [GEÇTİ / KALDI]

## 5. NİHAİ DENETİM HÜKMÜ

*   **Otomatik Test:** [GEÇTİ / KALDI]
*   **Manuel Test:** [GEÇTİ / KALDI]
*   **Genel Sonuç:** [GATE-M ONAY ADAYI / GATE-M RED]
