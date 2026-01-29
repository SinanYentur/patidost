# ANAYASAL ENJEKSİYON PLANI (v3.1 - İLK TEMAS)

**ANAYASAL KİMLİK BLOĞU**
---
- **FAZ:** FAZ-3: Fonksiyonel Doğum
- **AMAÇ:** Feature ve App katmanlarındaki kritik "Yetim Dosyalar"ı anayasal güvenceye almak.
- **DAYANAK:** `reports/ORPHANED_FILES.log` (46 Yetim Dosya Tespiti), Denetçi-1 Şartlı Onay Raporu.

---

## BÖLÜM 1: PIN SINIFLARI VE HUKUKİ TANIMLAR (v1.0)

Bu operasyonda kullanılacak PIN'ler aşağıdaki hukuki sınıflara aittir:

- **ENFORCE:** Bu PIN'in referans verdiği kural, CI/CD veya gelecekteki bir kilit (ML-004+) tarafından mekanik olarak zorlanacaktır. İhlali, build veya deploy işlemini durdurur.
- **SCAN:** Bu PIN, sadece MAP-001 (Haritalama Motoru) tarafından okunur. Anayasal kapsama ve izlenebilirlik sağlar, ancak anlık bir mekanik engelleme yapmaz.

## BÖLÜM 2: DOSYA BAZLI ENJEKSİYON HARİTASI

| Dosya | Risk Sınıfı | Enjekte Edilecek PIN | PIN TÜRÜ | Anayasal Amaç |
| :--- | :--- | :--- | :--- | :--- |
| `app/.../AppNavGraph.kt` | Navigasyon Kaosu | `[FAZ3-NAV-001]` | `ENFORCE` | Uygulama içi akışların anayasal haritaya uygunluğunu zorunlu kılmak. |
| `feature/.../AuthViewModel.kt` | Domain Sızıntısı | `[FAZ3-AUTH-001]` | `ENFORCE` | Kimlik doğrulama mantığının, `core/domain` dışına sızmadan, anayasal sözleşmelere uygun icra edilmesini sağlamak. |
| `feature/.../LoginScreen.kt` | Kritik Arayüz | `[FAZ3-AUTH-002]` | `SCAN` | Giriş ekranının, `FAZ0`'da tanımlanan temel kullanıcı deneyimi ve güvenlik ilkeleriyle olan bağını izlemek. |

## BÖLÜM 3: İLK TEMAS GERİ DÖNÜŞ PROTOKOLÜ (ROLLBACK)

- **Fail Senaryosu:** Bu enjeksiyonları içeren `commit` sonrası, projenin `build` veya `test` adımlarında beklenmedik bir çöküş yaşanırsa, operasyon "Başarısız" kabul edilir.
- **Geri Alma Adımı:** Operatör, `git revert <commit_hash>` komutu ile bu enjeksiyonları içeren `commit`'i geri alır. Gerekçe olarak "FAZ-3 İlk Temas Başarısızlığı" belirtilir.
- **Kanıt Saklama:** Başarısız olan build logları, `audits/failures/` dizini altına kaydedilir.

---
**SONRAKİ ADIM:** Bu nihai planın onaylanmasının ardından, belirtilen mühürlerin ilgili dosyalara fiziksel olarak enjekte edilmesi ve ardından MAP-001 motorunun yeniden çalıştırılarak anayasal kapsama oranının yükseldiğinin kanıtlanması.
