# ALT PROTOKOL: ANAYASAL KARAR AKIŞI VE YETKİ SINIRLANDIRMA (SP-07)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/META_GOVERNANCE_AND_CONTROL_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Detay Protokolü
- **ETKİ ALANI:** Karar Mekanizması, Yetki Kontrolü, Kriz Tetikleme
- **RİSK SEVİYESİ:** Stratejik (Sistemik Kilit)

---

## 1. KARAR SINIFLANDIRMA MATRİSİ (DECISION MATRIX)

Her eylem, başlamadan önce aşağıdaki sınıflardan birine atanmak zorundadır:

| Eylem Türü | Aktif Faz | Sorumlu Rol | Zorunlu Kapı (Gate) | Kriz Karşılığı |
| :--- | :--- | :--- | :--- | :--- |
| **Kod Üretimi** | `NORMAL` / `BÜYÜME` | İcra Ajanı | `GATE-1` (Derleme), `GATE-K` (Kalite) | `KRİZ-RESTORASYON` |
| **Mimari Değişim** | `NORMAL` | Mimar | `GATE-M` (Mimari Bağlanırlık) | `KRİZ-DENETİM` (Bloke) |
| **Hata Onarımı** | `KRİZ-RESTORASYON` | Kriz Subayı | `GATE-1` | `KRİZ-DENETİM` (Geri Çekilme) |
| **Veri Yapısı Değişimi** | `NORMAL` | Veri Mimarı | `GATE-3` (Veri Bütünlüğü) | `TİP-2` (Veri Çürümesi) |
| **Faz Geçişi** | *Tüm Fazlar* | İnsan Operatör | `DENETÇİ ONAYI` | `ANAYASAL KİLİTLENME` |

## 2. OTOMATİK YETKİ SORGUSU (AUTHORITY CHECK)

Her eylem öncesi, ajan şu sorguyu çalıştırmak zorundadır:

1.  **FAZ KONTROLÜ:** "Şu anki faz (`CURRENT_PHASE`), bu eylemi (`ACTION_TYPE`) destekliyor mu?"
    *   *Örn:* `KRİZ-DENETİM` fazında `Kod Üretimi` talebi gelirse -> **RED (YETKİSİZ EYLEM)**.
2.  **ROL KONTROLÜ:** "Benim şu anki rolüm (`CURRENT_ROLE`), bu eylem için yetkili mi?"
    *   *Örn:* `İcra Ajanı`, `Faz Geçişi` kararı veremez -> **RED (YETKİ AŞIMI)**.
3.  **DAYANAK KONTROLÜ:** "Bu eylemi meşru kılan anayasa maddesi (`CONSTITUTION_REF`) nedir?"
    *   *Örn:* Referans yoksa -> **RED (MEŞRUİYET EKSİKLİĞİ)**.

## 3. İHLAL OTOMASYONU VE KRİZ TETİKLEME

Yetkisiz veya anayasaya aykırı bir eylem tespit edildiğinde:

1.  **OTOMATİK DURDURMA:** Eylem derhal iptal edilir.
2.  **KAYIT:** Olay, `docs/VIOLATION_LOG.md` dosyasına "Anayasal İhlal Girişimi" olarak işlenir.
3.  **KRİZ MODU:** İhlal "Kritik" seviyedeyse (Örn: İzinsiz veri silme, Yetkisiz faz değişimi), sistem otomatik olarak **`KRİZ-DENETİM`** fazına geçer ve **`FREEZE`** (Dondurma) uygular.

---
**OPERASYONEL KARŞILIK:** `scripts/verify_authority.sh`
**FAZ GEÇİŞ ŞARTI:** Açık bir yetki ihlali kaydı bulunmamalıdır.
