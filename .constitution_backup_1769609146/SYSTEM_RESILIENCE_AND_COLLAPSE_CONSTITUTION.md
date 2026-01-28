# ANAYASA: FAZ-4 (SİSTEMSEL DAYANIKLILIK VE YIKILMA SENARYOLARI SÖZLEŞMESİ)

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** CORE_CONSTITUTION.md
- **NORM TÜRÜ:** Uygulama Anayasası
- **ANAYASAL KAYIT ID:** FAZ4-001

---

## BÖLÜM 1: FAILURE TAXONOMY (ÇÖKÜŞ HARİTASI)

*   **Madde 1.1 (Zorunlu Sınıflandırma):** Her potansiyel hata, şu sınıflardan birine bağlanmalıdır: Yapısal Çöküş, Veri Çürümesi, İnsan Kaynaklı Yıkım, Sessiz Bozulma.

## BÖLÜM 2: SİSTEM YENİDEN DOĞUŞ PROTOKOLLERİ (PHOENIX PROTOCOLS)

*   **Madde 2.1 (Phoenix Boot):** Geri dönülemez bir kriz anında, sistemi bilinen en son stabil anayasal duruma geri döndüren bir `scripts/phoenix_boot.sh` script'i bulunmalıdır.
*   **Madde 2.2 (Fonksiyonel Amputasyon):** Kriz anında, çekirdek işlevi korumak amacıyla, kritik olmayan modüllerin derleme dışı bırakılmasına İnsan Operatör karar verebilir.

## BÖLÜM 3: OTOMATİK KENDİNİ TEŞHİS KATMANI

*   **Madde 3.1 (Zorunlu Gözlemciler):** CI pipeline, anayasal sapmaları (`architecturalDriftDetector`) sürekli denetleyen görevler içermelidir.

## BÖLÜM 4: DELİL VE OLAY ZİNCİRİ

*   **Madde 4.1 (Kriz Kayıt Formatı):** Her kriz, `.dna/evidence/CRISIS-<ID>.md` formatında bir kanıt dosyası üretir.
