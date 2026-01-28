# ALT PROTOKOL: ANAYASAL İŞLEM PROTOKOLÜ (SP-09) - ATOMİK GÜVENCE

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** CORE_CONSTITUTION.md
- **NORM TÜRÜ:** Çekirdek İcra Prosedürü
- **ETKİ ALANI:** Anayasa Değişikliği, Sistem Bütünlüğü
- **RİSK SEVİYESİ:** Varoluşsal

---

## 1. FELSEFE: "YA HEP YA HİÇ" (ATOMICITY)

Anayasa üzerinde yapılan değişiklikler, bir veritabanı işlemi gibi bölünemez bir bütündür. Bir işlemin herhangi bir adımı başarısız olursa, tüm işlem geri alınır ve sistemin bütünlüğü asla tehlikeye atılmaz.

## 2. İŞLEM ADIMLARI (TRANSACTION LIFECYCLE)

### ADIM 1: KİLİTLEME (BEGIN_TRANSACTION)
*   `.constitution/.tx_lock` dosyası oluşturulur.
*   Sistem "Anayasal Değişiklik" moduna geçer. Bu modda başka bir anayasal değişiklik başlatılamaz.

### ADIM 2: SAHNELEME (STAGING)
*   Tüm yeni veya güncellenmiş anayasal belgeler, `.constitution_staging/` adlı geçici bir dizine yazılır.
*   Bu aşamada ana `.constitution/` dizinine **ASLA** dokunulmaz.

### ADIM 3: DOĞRULAMA (PRE-COMMIT VERIFICATION)
*   Tüm anayasal motorlar (`generate_index`, `verify_checksum`, `gatekeeper` vb.), **`_staging` dizinini** referans alarak bir "dry-run" gerçekleştirir.
*   Bu testler, sanki değişiklikler gerçekten yapılmış gibi davranır ama ana sistemi etkilemez.

### ADIM 4: KESİNLEŞTİRME VEYA GERİ ALMA (COMMIT / ROLLBACK)
*   **Eğer Doğrulama Başarılıysa (COMMIT):**
    1.  Eski `.constitution` dizini `.constitution_backup` olarak yeniden adlandırılır.
    2.  `.constitution_staging` dizini `.constitution` olarak yeniden adlandırılır.
    3.  Eski `_backup` dizini imha edilir.
    4.  `.tx_lock` dosyası kaldırılır.
*   **Eğer Doğrulama Başarısızsa (ROLLBACK):**
    1.  `.constitution_staging` dizini tamamen imha edilir.
    2.  `.tx_lock` dosyası kaldırılır.
    3.  `CRISIS_LOG.md`'ye "Başarısız Anayasal İşlem" kaydı düşülür.

---
**GARANTİ:** Bu protokol, önceki krizlerin kök nedeni olan "yarıda kalmış işlem" riskini ortadan kaldırır. Anayasa ya tam olarak ve doğrulanmış bir şekilde güncellenir ya da hiç güncellenmez. Bu, sistemin gelecekteki başarısının somut delilidir.
