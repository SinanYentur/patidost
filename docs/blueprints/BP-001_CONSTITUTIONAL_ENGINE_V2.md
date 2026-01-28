# MİMARİ BLUEPRINT: BP-001 (CONSTITUTIONAL ENGINE v2)

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** CORE_CONSTITUTION.md
- **İLGİLİ PROTOKOL:** SP-09-ANAYASAL-ISLEM-PROTOKOLU.md
- **AMAÇ:** Anayasal evreni atomik bir işlemle kurmak/güncellemek.

---

## 1. MİMARİ FELSEFE: ATOMİK VE FAIL-CLOSED

Bu script, bir hata anında sistemi belirsiz bir durumda bırakamaz. Ya tüm görevler %100 başarıyla tamamlanır ya da sistem başlangıç durumuna geri döner. Hiçbir ara durum meşru değildir.

## 2. FONKSİYON LİSTESİ VE İŞLEM SIRASI

1.  `main()`
    *   `trap_setup` çağrılır.
    *   `begin_transaction` çağrılır.
    *   `build_constitution_in_staging` çağrılır.
    *   `verify_staging_integrity` çağrılır.
    *   `commit_transaction` çağrılır.
    *   `cleanup` (başarılı) çağrılır.

2.  `trap_setup()`
    *   `trap 'cleanup_and_rollback' ERR INT TERM`: Hata, kesinti veya kapatma sinyalinde otomatik olarak `cleanup_and_rollback` fonksiyonunu tetikler.

3.  `begin_transaction()`
    *   `.tx_lock` dosyasının varlığını kontrol eder. Varsa, hata verip çıkar.
    *   `.tx_lock` dosyasını oluşturur.
    *   Eski `.constitution_staging` dizinini (varsa) siler.
    *   Boş bir `.constitution_staging` dizini oluşturur.

4.  `build_constitution_in_staging()`
    *   Tüm anayasal `.md` metinlerini `heredoc` ile `.constitution_staging` altına yazar.

5.  `verify_staging_integrity()`
    *   `generate_index --staging`: Staging dizininde geçici bir `.index` oluşturur.
    *   `verify_checksum --staging`: Staging dizininin geçici `checksum`'ını hesaplar.
    *   `run_gatekeeper_simulation --staging`: Staging dizinindeki anayasaya göre sahte/gerçek referanslarla test `commit`'leri simüle eder.

6.  `commit_transaction()`
    *   `mv .constitution .constitution_backup_$(date +%s)`: Mevcut anayasayı yedekler.
    *   `mv .constitution_staging .constitution`: Yeni, doğrulanmış anayasayı atomik olarak yerine koyar.

7.  `cleanup_and_rollback()`
    *   `.constitution_staging` dizinini imha eder.
    *   Eğer oluşturulmuşsa, `.constitution_backup` dizinini geri yükler.
    *   `.tx_lock` dosyasını kaldırır.
    *   `CRISIS_LOG.md`'ye başarısız işlem kaydı düşer.

## 3. ZORUNLU KONTROL NOKTALARI

- Script, `set -eE` ile çalışmalıdır (herhangi bir komut hatasında anında çık).
- Tüm dosya yolları, `git rev-parse --show-toplevel` ile üretilen mutlak yolları kullanmalıdır.

---
**ONAY:** Bu blueprint onaylandığında, `constitutional_engine_v2.sh` script'inin kod gövdesi bu plana göre inşa edilecektir.
