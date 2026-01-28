# PROTOKOL: ÇÖKÜŞ SINIFLANDIRMA VE KRİZ MODU DETAYLARI (P-04)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/SYSTEM_RESILIENCE_AND_COLLAPSE_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Prosedürü
- **ETKİ ALANI:** Kriz Yönetimi, DevOps, AI Ajanları
- **RİSK SEVİYESİ:** Kritik

---

## 1. DETAYLI ÇÖKÜŞ HARİTASI (FAILURE TAXONOMY)

### 1.1. TİP-1: YAPISAL ÇÖKÜŞ (Structural Collapse)
*   **Tanım:** Sistemin iskeletinin (Build, Gradle, Modül Bağları) kırılması.
*   **Belirtiler:** `Build Failed`, `Unresolved Reference`, `Plugin not found`.
*   **Otomatik Tepki:** `FAIL-FAST`. Derleme anında durur.
*   **Çözüm Protokolü:** `SYSTEM_RESTORATION_CHARTER` (Restorasyon).

### 1.2. TİP-2: VERİ ÇÜRÜMESİ (Data Rot)
*   **Tanım:** Veritabanı şemasının kodla uyumsuzlaşması, "Hayalet Veri" (silinmesi gereken verinin kalması) veya veri bütünlüğünün bozulması.
*   **Belirtiler:** `JsonDataException`, `RoomSchemaMismatch`, UI'da yanlış/eski veri gösterimi.
*   **Otomatik Tepki:** `CIRCUIT-BREAKER`. İlgili modülün veri akışı kesilir, UI "Bakım Modu"na geçer.
*   **Çözüm Protokolü:** `DATA_MIGRATION_POLICY` ve `DATA_DESTRUCTION_PROTOCOL`.

### 1.3. TİP-3: SESSİZ BOZULMA (Silent Decay)
*   **Tanım:** Sistemin çalışıyor görünmesi ama yanlış sonuç üretmesi (Örn: Yanlış hesaplanan puan, gönderilmeyen bildirim).
*   **Belirtiler:** Artan kullanıcı şikayeti, düşen metrikler (Retention), loglarda anomali yokluğu.
*   **Otomatik Tepki:** `OBSERVER-ALERT`. Sistem çalışmaya devam eder ama "Yüksek Risk" bayrağı açılır. Denetçi incelemesi zorunludur.

## 2. ÖZEL KRİZ MODLARI VE TEKNİK KARŞILIKLARI

### 2.1. READ-ONLY ANAYASAL MOD
*   **Ne Zaman:** Anayasal bütünlük şüphesi olduğunda (Checksum hatası).
*   **Kısıt:** `write_file` ve `git commit` yetkileri tüm AI ajanlarından alınır. Sadece `read_file` serbesttir.
*   **Amaç:** Kanıtların bozulmasını önlemek.

### 2.2. GÖZLEMCİ KİLİDİ (OBSERVER LOCK)
*   **Ne Zaman:** "Sessiz Bozulma" tespit edildiğinde.
*   **Kısıt:** Yeni özellik (Feature) geliştirme durdurulur. Sadece `Log`, `Analytics` ve `Test` kodları yazılabilir.
*   **Amaç:** Sistemi değiştirmeden sorunu izlemek.

### 2.3. FONKSİYONEL AMPUTASYON (MODÜL KAPATMA)
*   **Ne Zaman:** Bir modül (Örn: `feature:chat`) tüm sistemi çökertiyorsa.
*   **Eylem:** `settings.gradle.kts` dosyasından ilgili modülün `include` satırı yorumlanır. Ana uygulamadaki giriş noktası (Navigation) devre dışı bırakılır.
*   **Amaç:** "Kol'u kesip hastayı kurtarmak".

---
**YÜRÜRLÜK:** Bu protokol, `PIN_TABLE`'a işlendiği andan itibaren geçerlidir.
