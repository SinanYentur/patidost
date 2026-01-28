# ANAYASA: FAZ-4 (SİSTEMSEL DAYANIKLILIK VE YIKILMA SENARYOLARI SÖZLEŞMESİ)

**ANAYASAL KİMLİK BLOĞU**
---
- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md, ANAYASAL_EK_PROTOKOL.md
- **NORM TÜRÜ:** Uygulama Anayasası (Lex Operativa)
- **ANAYASAL KAYIT ID:** SRCC-001
- **PIN_TABLE REFERANSI:** `.constitution/PIN_TABLE.md`
- **BAĞLI OLDUĞU MADDELER:** OMEGA_CODEX §7, §96, §97; Denetçi-1 Eksik Fazlar Raporu
- **GEÇERLİ FAZLAR:** Tüm Fazlar (Özellikle Kriz Modu ve Sonrası)
- **BAĞLADIĞI ROLLER:** Kriz Subayı, İcra Ajanı, Denetçiler
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Üst Kanun (Çok Zor Değişir)

---

## BÖLÜM 1: FAILURE TAXONOMY (ÇÖKÜŞ HARİTASI)

*   **Madde 1.1 (Zorunlu Sınıflandırma):** Projede yaşanan her kritik hata, `POST-MORTEM` raporunda aşağıdaki sınıflardan en az birine bağlanmak zorundadır:
    *   **Yapısal Çöküş:** Mimari, modül veya build kimliği gibi temel iskeletin kırılması.
    *   **Veri Çürümesi:** Verinin bütünlüğünü, gerçekliğini veya yaşam döngüsünü bozan hatalar.
    *   **İnsan Kaynaklı Yıkım:** Hatalı veya yetkisiz operatör/geliştirici kararları.
    *   **Sessiz Bozulma:** Belirgin bir çöküş olmadan, sistemin zamanla performans veya mantık olarak yozlaşması.
*   **Madde 1.2 (Kanıt):** Her sınıflandırma, loglar ve anayasal belge referansları ile kanıtlanmalıdır.

## BÖLÜM 2: SİSTEM YENİDEN DOĞUŞ PROTOKOLLERİ (PHOENIX PROTOCOLS)

*   **Madde 2.1 (Phoenix Boot):** Geri dönülemez bir kriz anında, projenin bilinen en son stabil ve anayasal olarak temiz haline geri dönmesini sağlayan otomatik bir script (`scripts/phoenix_boot.sh`) bulunmak zorundadır.
*   **Madde 2.2 (Anayasal Cold-Start):** "Phoenix Boot" sonrası sistem, `constitutional_engine.sh` script'ini çalıştırarak anayasal bütünlüğünü yeniden doğrulamadan hiçbir operasyonel faza geçemez.
*   **Madde 2.3 (Fonksiyonel Amputasyon):** Kriz anında, sistemin çekirdek işlevini korumak amacıyla, anayasal olarak "DESTEK" veya "EKLENTİ" olarak işaretlenmiş modüllerin geçici olarak derleme dışı bırakılmasına İnsan Operatör karar verebilir.

## BÖLÜM 3: OTOMATİK KENDİNİ TEŞHİS KATMANI

*   **Madde 3.1 (Zorunlu Gözlemciler):** CI pipeline, aşağıdaki anayasal sapmaları sürekli olarak denetleyen görevler içermek zorundadır:
    *   `architecturalDriftDetector`: Katman ihlallerini ve yasaklı bağımlılıkları denetler.
    *   `dataFlowAnomalyDetector`: Veri akışının anayasal sözleşmelere uygunluğunu denetler.
    *   `roleViolationObserver`: Commit mesajlarındaki ve AI çıktılarındaki rol beyanlarının, aktif faza uygunluğunu denetler.

## BÖLÜM 4: KONSOLİDE KRİZ MODLARI

*   **Madde 4.1 (Mod Tanımları):** `OMEGA_CODEX`'teki kriz modlarına ek olarak, sistem aşağıdaki alt statüleri de tanır:
    *   **Read-Only Anayasal Mod:** Sadece anayasa ve kanıt dosyalarının okunabildiği, hiçbir yazma işleminin yapılamadığı en kilitli mod.
    *   **Gözlemci Kilidi:** Sadece `HARİTALA` ve `RAPORLA` komutlarına izin verilen, `PLANLA` ve `ONARIM`'ın yasak olduğu denetim modu.
    *   **AI Yetki Düşürme:** AI ajanlarının sadece analiz yapabildiği, kod veya plan üretemediği kısıtlı mod.

## BÖLÜM 5: DELİL VE OLAY ZİNCİRİ

*   **Madde 5.1 (Kriz Kayıt Formatı):** Her kriz, `.dna/evidence/CRISIS-<ID>.md` formatında, zaman damgası, tetikleyici olay, etkilenen sistemler ve sorumlu roller gibi standart başlıkları içeren bir kanıt dosyası üretir.
*   **Madde 5.2 (Denetçi Delil Paketi):** Bir denetçi, bir fazı veya eylemi veto ettiğinde, bu vetoya neden olan tüm logları, anayasa maddelerini ve kanıtları içeren bir "Delil Paketi" oluşturmakla yükümlüdür.

---

**YÜRÜRLÜK:** Bu belgenin onaylanması, FAZ-4'ün eksik anayasal kilitlerinin tamamlanması için kritik bir adımdır.
