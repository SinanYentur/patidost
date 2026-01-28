# ANAYASA: FAZ-4 (SİSTEMSEL DAYANIKLILIK VE YIKILMA SENARYOLARI SÖZLEŞMESİ)

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** GLOBAL_PRE_EMPTIVE_CONSTITUTION.md
- **NORM TÜRÜ:** Uygulama Anayasası (Lex Operativa)

---

## BÖLÜM 1: FAILURE TAXONOMY (ÇÖKÜŞ HARİTASI)

*   **Madde 1.1 (Zorunlu Sınıflandırma):** Her potansiyel hata, `POST-MORTEM` raporunda aşağıdaki sınıflardan birine bağlanmak zorundadır:
    *   **Yapısal Çöküş:** Mimari, modül veya build kimliğinin kırılması.
    *   **Veri Çürümesi:** Veri bütünlüğünün veya gerçekliğinin bozulması.
    *   **İnsan Kaynaklı Yıkım:** Hatalı operatör kararları.
    *   **Sessiz Bozulma:** Belirgin bir çöküş olmadan sistemin yozlaşması.

## BÖLÜM 2: SİSTEM YENİDEN DOĞUŞ PROTOKOLLERİ (PHOENIX PROTOCOLS)

*   **Madde 2.1 (Phoenix Boot):** Geri dönülemez bir kriz anında, projenin bilinen en son stabil ve anayasal olarak temiz haline geri dönmesini sağlayan bir script (`scripts/phoenix_boot.sh`) bulunmalıdır.
*   **Madde 2.2 (Anayasal Cold-Start):** "Phoenix Boot" sonrası sistem, anayasal bütünlüğünü yeniden doğrulamadan hiçbir operasyonel faza geçemez.
*   **Madde 2.3 (Fonksiyonel Amputasyon):** Kriz anında, sistemin çekirdek işlevini korumak amacıyla, kritik olmayan modüllerin geçici olarak derleme dışı bırakılmasına İnsan Operatör karar verebilir.

## BÖLÜM 3: OTOMATİK KENDİNİ TEŞHİS KATMANI

*   **Madde 3.1 (Zorunlu Gözlemciler):** CI pipeline, anayasal sapmaları sürekli olarak denetleyen görevler içermelidir (`architecturalDriftDetector`, `dataFlowAnomalyDetector`, `roleViolationObserver`).

## BÖLÜM 4: KONSOLİDE KRİZ MODLARI

*   **Madde 4.1 (Mod Tanımları):** Sistem, aşağıdaki kriz alt statülerini tanır:
    *   **Read-Only Anayasal Mod:** Anayasal bütünlük şüphesinde, sadece okuma eylemlerine izin verilir.
    *   **Gözlemci Kilidi:** "Sessiz Bozulma" tespitinde, yeni özellik geliştirme durdurulur.
    *   **AI Yetki Düşürme:** AI ajanlarının sadece analiz yapabildiği, kod üretemediği kısıtlı mod.

## BÖLÜM 5: DELİL VE OLAY ZİNCİRİ

*   **Madde 5.1 (Kriz Kayıt Formatı):** Her kriz, `.dna/evidence/CRISIS-<ID>.md` formatında, standart başlıkları içeren bir kanıt dosyası üretir.
*   **Madde 5.2 (Denetçi Delil Paketi):** Bir denetçi bir fazı veto ettiğinde, bu vetoya neden olan tüm kanıtları içeren bir paket oluşturmakla yükümlüdür.
