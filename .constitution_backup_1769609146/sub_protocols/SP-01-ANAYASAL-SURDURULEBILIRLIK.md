# ALT PROTOKOL: ANAYASAL SÜRDÜRÜLEBİLİRLİK VE MEŞRUİYET (SP-01)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/CONSTITUTIONAL_LEGITIMACY_CHARTER.md`
- **NORM TÜRÜ:** Uygulama Detay Protokolü
- **ETKİ ALANI:** Anayasal Değişim, Belge Yönetimi
- **RİSK SEVİYESİ:** Stratejik

---

## 1. ANAYASA DEĞİŞİKLİK PROSEDÜRÜ (CONSTITUTIONAL CHANGE REQUEST - CCR)

Anayasa "keyfi" değişemez. Her değişiklik bir `CCR` (Change Request) süreciyle olur.

### 1.1. DEĞİŞİKLİK TALEBİ ADIMLARI
1.  **Talep:** İlgili rol, `docs/change_requests/CCR-<ID>.md` oluşturur. Gerekçe ve etki analizi zorunludur.
2.  **Denetim:** Denetçi-1 (Stratejik) ve Denetçi-2 (Mekanik), değişikliği kendi açılarından değerlendirir.
3.  **Onay:** İnsan Operatör nihai onayı verir.
4.  **İcra:** Değişiklik uygulanır ve `VERSION.lock` güncellenir.
5.  **Mühürleme:** `checksum` yeniden hesaplanır.

### 1.2. GERİ ALINAMAZ MADDELER (IMMUTABLE CLAUSES)
Aşağıdaki maddeler, proje var olduğu sürece değiştirilemez, kaldırılamaz veya zayıflatılamaz:
*   **İnsan Otoritesi:** Nihai karar insandadır.
*   **Kanıt İlkesi:** Kanıtsız ilerleme yoktur.
*   **Kriz Önceliği:** Kriz anında üretim durur.
*   **Bağlanırlık İlkesi:** Modüller sözleşmesiz konuşamaz.

## 2. YETKİSİZ DOKÜMANTASYON TESPİTİ (ROGUE DOC HUNT)

### 2.1. OTOMATİK TARAMA
CI pipeline, her build öncesi `scan_rogue_docs` görevini çalıştırır.
*   **Kriter:** `.constitution` veya `contracts` dışında, anayasal iddia taşıyan (örn: "Kural", "Yasak", "Zorunlu") belgeler taranır.
*   **Tepki:** Bulunursa, belge "Karantina"ya alınır ve build **DURDURULUR**.

### 2.2. TEMİZLİK
Yetkisiz belge ya anayasaya entegre edilir (`CCR` süreciyle) ya da silinir.

## 3. ANAYASAL ÇAKIŞMA ÇÖZÜMÜ

İki anayasal belge çelişirse:
1.  **Tarih:** Yeni olan eskisini ezer.
2.  **Hiyerarşi:** Üst Norm (Charter), Alt Normu (Protokol) ezer.
3.  **Kapsam:** Özel kural (Specific), Genel kuralı (General) ezer.

---
**OPERASYONEL KARŞILIK:** `scripts/verify_constitution_integrity.sh`
**FAZ GEÇİŞ ŞARTI:** Açık `CCR` yoksa faz geçilebilir.
