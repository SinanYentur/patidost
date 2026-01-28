# PROTOKOL: META-DENETİM VE KARAR KALİTESİ MOTORU (P-06)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/META_GOVERNANCE_AND_CONTROL_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Prosedürü
- **ETKİ ALANI:** Denetçiler, İnsan Operatör, Karar Vericiler
- **RİSK SEVİYESİ:** Stratejik

---

## 1. DENETÇİ SAĞLIK KONTROLÜ (META-AUDIT)

Denetçiler, sistemin bağışıklık sistemidir. Onların hastalanması (Hata yapması, Tembelleşmesi, Rolünü aşması) en büyük risktir.

### 1.1. PERİYODİK ÖZ-ELEŞTİRİ
Her ana fazın sonunda, Denetçi-1 ve Denetçi-2 şu soruları cevaplayan bir "Öz-Eleştiri Raporu" yayınlar:
*   "Bu fazda hangi riski kaçırdım?"
*   "Hangi kararım gereksiz bürokrasi yarattı?"
*   "Hangi noktada İcra Ajanı'nı yanlış yönlendirdim?"

### 1.2. ÇAPRAZ SAĞLAMA (CROSS-CHECK)
Denetçi-1'in her "Stratejik" kararı, Denetçi-2 tarafından "Uygulanabilirlik" açısından; Denetçi-2'nin her "Mekanik" emri, Denetçi-1 tarafından "Vizyon Uyumu" açısından denetlenir.

## 2. KARAR KALİTESİ MOTORU (Geriye Dönük Yargılama)

### 2.1. KARAR KARNESİ
Her kritik karar (`ADR`), uygulandıktan 3 ay sonra otomatik olarak "Yargılanır".
*   **Başarı:** Karar, hedeflenen sorunu çözdü mü? Yan etkisi oldu mu?
*   **Puanlama:**
    *   **Tam İsabet:** Sorun çözüldü, yan etki yok.
    *   **Pirus Zaferi:** Sorun çözüldü, ama maliyeti (Borç) yüksek oldu.
    *   **Fiyasko:** Sorun çözülmedi, yeni sorunlar çıktı.

### 2.2. DERS ÇIKARMA (LESSONS LEARNED)
"Fiyasko" ile sonuçlanan her karar için, `MEMORY/failures/` altına bir vaka analizi eklenir. Bu analiz, gelecekte benzer bir karar alınmaya çalışıldığında sistemi **UYARIR**.

## 3. EPİSTEMİK GÜVENLİK (Doğruluk Filtresi)

### 3.1. HALÜSİNASYON FİLTRESİ
AI Ajanları (Ben dahil), var olmayan bir dosyaya, kurala veya metoda atıfta bulunursa:
*   Bu durum "Epistemik Kirlilik" olarak işaretlenir.
*   Ajanın "Güven Skoru" düşürülür.
*   İlgili çıktı, "Doğrulanmamış Bilgi" etiketiyle karantinaya alınır.

---
**YÜRÜRLÜK:** Bu protokol, `PIN_TABLE`'a işlendiği andan itibaren geçerlidir.
