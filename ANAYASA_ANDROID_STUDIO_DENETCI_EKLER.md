🏛️ PATIDOST ENDÜSTRİYEL OPERASYON ANAYASASI
═══════════════════════════════════════════════════════════════════

EK BÖLÜM A — ANDROID STUDIO AI & DENETÇİ HİYERARŞİSİ
(Kaç Denetçi Olursa Olsun: Hemfikir Aynı Dizinde Çalışma Protokolü)

═══════════════════════════════════════════════════════════════════

⚖️ MADDE A.1 — DENETÇİ SİSTEMİ TEMELİ

A.1.1 — DENETÇİ TANIMLAMA
─────────────────────────────────

Denetçi, bir "kişilik" DEĞİLDİR.
Denetçi, bir "görüş sahibi varlık" DEĞİLDİR.
Denetçi, bir "karar mekanizması" DEĞİLDİR.

Denetçi:
┌─────────────────────────────────────────────────┐
│ SABİT KONTROL LİSTESİYLE ÇALIŞAN                │
│ PROTOKOL UYGULAYICI MEKANİZMADIR                │
└─────────────────────────────────────────────────┘

Bu nedenle:

• Denetçi-1 (ChatGPT)
• Denetçi-2 (Claude)
• Denetçi-3 (Gemini)
• Denetçi-N (Herhangi bir AI)
• Harici Denetçi
• İnsan Denetçi

AYNI KONTROL LİSTESİNİ OKUR.
AYNI MATRİSTEN GEÇİRİR.
AYNI ÇIKTIYI ÜRETİR.

A.1.2 — DENETÇİ KALİTE FARKI YASAĞI
─────────────────────────────────────

"Denetçi-1 daha sıkı denetler"
"Denetçi-2 daha yumuşaktır"
"Harici denetçi farklı ölçer"

▶ ANAYASAL İHLALDİR.

Eğer iki denetçi farklı sonuç veriyorsa:

SORUN DENETÇİDE DEĞİL, KONTROL LİSTESİNDEDİR.

Bu durumda:
1. Her iki denetçinin raporu sistem tarafından REDDEDİLİR
2. KONTROL LİSTESİ güncellenir
3. Her iki denetçi YENİDEN aynı kontrol listesiyle denetler

═══════════════════════════════════════════════════════════════════

⚖️ MADDE A.2 — ZORUNLU DENETİM MATRİSİ (ZDM)

A.2.1 — TÜM DENETÇİLERİN ZORUNLU BAŞLIKLARI
────────────────────────────────────────────────

Her denetçi raporu (1'den N'e kadar) bu başlıkları %100 DOLDURUR:

┌────────────────────────────────────────────────────────┐
│ [1] KAPSAM TANIMI                                      │
│     • Hangi faz?                                       │
│     • Hangi modül?                                     │
│     • Hangi dosya kümesi?                              │
│     • Hangi anayasal madde?                            │
│                                                        │
│ [2] MİMARİ UYGUNLUK                                    │
│     • ARCHITECTURE_CHARTER.md ile uyum?                │
│     • Yasak bağımlılık var mı?                         │
│     • Gelecek modül rezervi ihlali?                    │
│     • Katman sınırı ihlali?                            │
│                                                        │
│ [3] BAĞLAM TÜKETİMİ                                    │
│     • Kullanılan belge listesi                         │
│     • Eksik bağlam kaynakları                          │
│     • Çelişkili bağlam noktaları                       │
│                                                        │
│ [4] SÖZLEŞME UYGUNLUĞU                                 │
│     • Modül sözleşmesi ihlali?                         │
│     • public-contract.md uyumu?                        │
│     • forbidden-usage.md ihlali?                       │
│                                                        │
│ [5] TEST STANDARDI                                     │
│     • Test coverage eşiği?                             │
│     • Unit test kalitesi?                              │
│     • Integration test durumu?                         │
│                                                        │
│ [6] GÜVENLİK DEĞERLENDİRMESİ                           │
│     • Veri sızıntısı riski?                            │
│     • Yetkilendirme açığı?                             │
│     • Input validation?                                │
│                                                        │
│ [7] GELECEK ETKİ ANALİZİ                               │
│     • 6 ay sonra neyi kısıtlar?                        │
│     • Hangi modül bunun üzerine kurulacak?             │
│     • Hangi değişiklik pahalı hale gelir?              │
│                                                        │
│ [8] İHLAL TESPİTİ                                      │
│     • İhlal var mı? (EVET/HAYIR)                       │
│     • İhlal seviyesi? (KRİTİK/YÜKSEK/ORTA/DÜŞÜK)       │
│     • İhlal maddesi?                                   │
│                                                        │
│ [9] KAPAN KARAR                                        │
│     • GATE-B (Bağlam): AÇIK/KAPALI                     │
│     • GATE-P (Plan): AÇIK/KAPALI                       │
│     • GATE-U (Uyumluluk): AÇIK/KAPALI                  │
│     • GATE-K (Kalite): AÇIK/KAPALI                     │
│                                                        │
│ [10] KÖR NOKTA TARAMASI                                │
│     • Bu denetim hangi hatayı göremez?                 │
│     • Hangi rol dışarıda kalıyor?                      │
│     • Hangi modül fazla yetkili?                       │
└────────────────────────────────────────────────────────┘

Bu matris TAMAMEN doldurulmadan rapor:
❌ Geçersizdir
❌ Sistem tarafından reddedilir
❌ Denetçi yaptırım görür

A.2.2 — ORTAK DOSYA SİSTEMİ ZORUNLULUĞU
─────────────────────────────────────────

Tüm denetçiler AYNI dizinde çalışır:

/project-root/
├── .constitution/                    ← ANAYASAL BELGELERİN EVİ
│   ├── PROJECT_MANIFEST.md
│   ├── ARCHITECTURE_CHARTER.md
│   ├── UI_UX_CONTRACT.md
│   ├── OPERATIONAL_TASK_LOG.md
│   ├── ANDROID_STUDIO_AI_CHARTER.md
│   └── MODULE_CONTEXT_REGISTRY.md
│
├── .audits/                          ← TÜM DENETÇİLERİN RAPOR DİZİNİ
│   ├── daily/
│   │   ├── 2026-01-27_DENETCI-1_GUNLUK.md
│   │   ├── 2026-01-27_DENETCI-2_GUNLUK.md
│   │   └── 2026-01-27_DENETCI-N_GUNLUK.md
│   │
│   ├── phase/
│   │   ├── PHASE-1_DENETCI-1_RAPOR.md
│   │   ├── PHASE-1_DENETCI-2_RAPOR.md
│   │   └── PHASE-1_HEMFIKIR_SONUC.md      ← BİRLEŞTİRİLMİŞ RAPOR
│   │
│   ├── constitutional/
│   │   ├── ANAYASAL_DENETCI-1.md
│   │   ├── ANAYASAL_DENETCI-2.md
│   │   └── ANAYASAL_HEMFIKIR_SONUC.md
│   │
│   └── crisis/
│       └── KRIZ_TATBIKAT_20260127.md
│
├── .gates/                           ← KAPI DURUMLARI
│   ├── GATE-B_STATUS.json           ← Bağlam Kapısı
│   ├── GATE-P_STATUS.json           ← Plan Kapısı
│   ├── GATE-U_STATUS.json           ← Uyum Kapısı
│   └── GATE-K_STATUS.json           ← Kalite Kapısı
│
└── .ai-telemetry/                    ← ANDROID STUDIO AI İZLEME
    ├── AI_BEHAVIOR_LOG.jsonl
    ├── AI_VIOLATION_HISTORY.md
    └── AI_SANCTION_STATUS.json

═══════════════════════════════════════════════════════════════════

⚖️ MADDE A.3 — DENETÇİ HEMFİKİR OLMA PROTOKOLÜ

A.3.1 — ÇAPRAZ DENETİM ZORUNLULUĞU
───────────────────────────────────

Her kritik noktada EN AZ 2 DENETÇİ bağımsız denetim yapar:

ÖRNEK: Faz Geçiş Denetimi
─────────────────────────

1. DENETÇI-1 (ChatGPT) → PHASE-1_DENETCI-1_RAPOR.md üretir
2. DENETÇI-2 (Claude) → PHASE-1_DENETCI-2_RAPOR.md üretir
3. Sistem her iki raporu OTOMATIK karşılaştırır

Karşılaştırma Kuralları:
───────────────────────

✅ İKİ RAPOR HEMFİKİRSE:
   → PHASE-1_HEMFIKIR_SONUC.md oluşturulur
   → Faz geçişi AÇILIR

❌ İKİ RAPOR ÇELIŞKILIIYSE:
   → Her iki rapor REDDEDİLİR
   → KONTROL_LISTESI_GUNCELLEMESI tetiklenir
   → YENİDEN denetim yapılır

⚠️ BİR RAPOR EKSİKSE (Matris tam dolu değil):
   → O rapor OTOMATIK reddedilir
   → Eksik denetçiye YAPTIRIM uygulanır

A.3.2 — OTOMATIK HEMFİKİR SONUÇ ÜRETME
───────────────────────────────────────

Sistem, hemfikir raporları birleştirir:

HEMFIKIR_SONUC.md formatı:
─────────────────────────

```markdown
# Hemfikir Denetim Sonucu
## Tarih: 2026-01-27
## Faz: PHASE-1
## Denetçiler: DENETÇI-1 (ChatGPT), DENETÇI-2 (Claude)

### ORTONORMALİZE SONUÇLAR

#### [1] KAPSAM
- Faz: PHASE-1
- Modül: auth_module, core_module
- Dosya: 47 dosya denetlendi
- Anayasal Madde: BÖLÜM 3, 4, 5

#### [2] MİMARİ UYGUNLUK
- ARCHITECTURE_CHARTER uyum: ✅ TAM UYUMLU
- Yasak bağımlılık: ❌ YOK
- Gelecek modül rezervi: ✅ KORUNDU
- Katman sınırı: ✅ İHLAL YOK

#### [3] BAĞLAM TÜKETİMİ
- Kullanılan belgeler: 12/12 ✅
- Eksik bağlam: YOK
- Çelişki: YOK

#### [4-10] ... (Tüm matris başlıkları)

### KAPI KARARLARI (HEMFİKİR)
- GATE-B: ✅ AÇIK
- GATE-P: ✅ AÇIK
- GATE-U: ✅ AÇIK
- GATE-K: ✅ AÇIK

### NİHAİ KARAR
✅ FAZ GEÇİŞİ ONAYLI
```

A.3.3 — ÇELIŞKI ÇÖZÜM PROTOKOLÜ
────────────────────────────────

Eğer Denetçi-1 ve Denetçi-2 farklı sonuç verirse:

ADIM 1: Sistem ÇELİŞKİ RAPORU üretir
────────────────────────────────────

```markdown
# ÇELIŞKI RAPORU
## Tarih: 2026-01-27
## Denetim: PHASE-1

### ÇELİŞEN NOKTALAR

| Başlık | Denetçi-1 | Denetçi-2 | Çelişki Türü |
|--------|-----------|-----------|--------------|
| GATE-U | KAPALI | AÇIK | KRİTİK |
| Test Coverage | %78 | %82 | TOLERE |

### KRİTİK ÇELİŞKİLER: 1
### TOLERE ÇELİŞKİLER: 1

KARAR: ❌ RAPORLAR REDDEDİLDİ
```

ADIM 2: KONTROL LİSTESİ GÜNCELLEME
──────────────────────────────────

Sistem, çelişkiye neden olan maddeyi netleştirir:

ÖNCESİ:
"Test coverage yeterli mi?"

SONRASI:
"Test coverage ≥ %80 mı? (Hesaplama: toplam satır / test edilen satır)"

ADIM 3: YENİDEN DENETİM
───────────────────────

• Aynı denetçiler
• Güncellenmiş kontrol listesiyle
• Aynı içeriği YENİDEN denetler

ADIM 4: 3. DENETÇİ DEVREYİ GİRER (İsteğe Bağlı)
───────────────────────────────────────────────

Eğer 2 denetimde de çelişki sürerse:
→ DENETÇI-3 (Gemini/başka AI) devreye girer
→ 3 raporun ÇOĞUNLUK KARARI alınır

═══════════════════════════════════════════════════════════════════

⚖️ MADDE A.4 — ANDROID STUDIO AI HİYERARŞİK KONUMU

A.4.1 — ANDROID STUDIO AI: ÜRETİCİ, DENETÇİ DEĞİL
──────────────────────────────────────────────────

Android Studio AI ASLA denetçi olamaz.
Android Studio AI kendi kodunu onaylayamaz.

Hiyerarşi:
─────────

KARAR VERİR:    İnsan Operatör
DENETLERLERİ:   Denetçi-1, Denetçi-2, ..., Denetçi-N
ÜRETİR:         Android Studio AI
TEST EDER:      Otomatik Test Sistemi

A.4.2 — ANDROID STUDIO AI ÇALIŞMA MODELİ
─────────────────────────────────────────

Android Studio AI 3 modda çalışır:

┌────────────────────────────────────────────────────────┐
│ MOD 1: PASİF VARLIK (İlk Durum)                        │
│ ───────────────────────────────────────────────────    │
│ Yapabilir:                                             │
│   • Eksik belge listesi                                │
│   • Bağlam boşluğu raporu                              │
│   • Çelişki tespiti                                    │
│                                                        │
│ Yapamaz:                                               │
│   • Kod yazmak                                         │
│   • Öneri sunmak                                       │
│   • Plan oluşturmak                                    │
│                                                        │
│ Çıkış Koşulu:                                          │
│   TAM KAPSAYICI PLAN + TAM BAĞLAM MATRİSİ             │
│   + DENETÇI ONAYI                                      │
└────────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────────┐
│ MOD 2: AKTİF ÜRETİM (Normal Çalışma)                   │
│ ────────────────────────────────────────────────────   │
│ Yapabilir:                                             │
│   • Tanımlı görev kapsamında kod üretmek               │
│   • Test yazmak                                        │
│   • Hata analizi                                       │
│   • Refactor önerisi (onay gerektiren)                │
│                                                        │
│ Yapamaz:                                               │
│   • Mimari karar almak                                 │
│   • Kendi kodunu onaylamak                             │
│   • Denetçi raporu üretmek                             │
│                                                        │
│ Her Üretim Sonrası:                                    │
│   ZORUNLU DENETÇİ KONTROLÜ                             │
└────────────────────────────────────────────────────────┘

┌────────────────────────────────────────────────────────┐
│ MOD 3: FELÇ (Ceza Modu)                                │
│ ────────────────────────────────────────────────────   │
│ Neden Girilir:                                         │
│   • Anayasal ihlal                                     │
│   • Yetkisiz üretim                                    │
│   • Denetçi uyarısı görmezden gelme                    │
│                                                        │
│ Bu Modda:                                              │
│   HİÇBİR ÇIKTI ÜRETİLEMEZ                              │
│                                                        │
│ Çıkış:                                                 │
│   İnsan operatör manuel müdahalesi                     │
└────────────────────────────────────────────────────────┘

A.4.3 — ANDROID STUDIO AI - DENETÇİ İLİŞKİSİ
──────────────────────────────────────────────

DÖNGÜ:
─────

1. Android Studio AI → KOD ÜRETIR
2. Sistem otomatik → DENETÇI-1 + DENETÇI-2 tetikler
3. Denetçiler → ZDM matrisi doldurur
4. Sistem → Hemfikir mi kontrol eder
5a. ✅ Hemfikirse → Kod ONAYLANIR, merge edilir
5b. ❌ Çelişkiyse → Kod REDDEDİLİR, Android Studio AI düzeltir
5c. ⚠️ İhlal varsa → Android Studio AI FELÇ moduna girer

═══════════════════════════════════════════════════════════════════

⚖️ MADDE A.5 — DENETÇI KONTROL LİSTESİ STANDARTLAŞMASI

A.5.1 — KONTROL LİSTESİ KAYNAK DİZİNİ
──────────────────────────────────────

Tüm denetçiler AYNI kontrol listelerini okur:

/project-root/.checklists/
├── ZDM_GUNLUK_KONTROL.md           ← Günlük Denetim Matrisi
├── ZDM_FAZ_KONTROL.md              ← Faz Denetim Matrisi
├── ZDM_ANAYASAL_KONTROL.md         ← Anayasal Denetim Matrisi
├── GATE-B_KONTROL.md               ← Bağlam Kapısı Kontrolleri
├── GATE-P_KONTROL.md               ← Plan Kapısı Kontrolleri
├── GATE-U_KONTROL.md               ← Uyum Kapısı Kontrolleri
├── GATE-K_KONTROL.md               ← Kalite Kapısı Kontrolleri
└── CHECKLIST_VERSION.json          ← Versiyon Takibi

A.5.2 — KONTROL LİSTESİ VERSİYONLAMA
─────────────────────────────────────

Her kontrol listesi güncellemesi:

```json
{
  "checklist_name": "ZDM_FAZ_KONTROL",
  "version": "2.3.1",
  "last_update": "2026-01-27T10:30:00Z",
  "reason": "GATE-U çelişkisi nedeniyle netleştirildi",
  "changed_items": [
    "Test coverage hesaplama formülü eklendi",
    "Modül bağımlılık sayısı limiti net tanımlandı"
  ],
  "mandatory_for": ["DENETCI-1", "DENETCI-2", "DENETCI-N"],
  "effective_from": "2026-01-27T12:00:00Z"
}
```

A.5.3 — DENETÇI SENKRONIZASYON ZORUNLULUĞU
──────────────────────────────────────────

Her denetimden ÖNCE denetçi:

1. CHECKLIST_VERSION.json okur
2. Kendi versiyonunu kontrol eder
3. Eski versiyonsa → ❌ DENETİM YAPAMAZ
4. Güncel versiyonsa → ✅ Denetim başlar

Kontrol:
───────

```python
def denetci_baslat(denetci_id):
    lokal_versiyon = denetci.get_checklist_version()
    merkez_versiyon = load_json(".checklists/CHECKLIST_VERSION.json")
    
    if lokal_versiyon != merkez_versiyon:
        return "❌ DENETİM REDDEDILDI - KONTROL LİSTESİ ESKİ"
    
    return "✅ DENETİM BAŞLAYABİLİR"
```

═══════════════════════════════════════════════════════════════════

⚖️ MADDE A.6 — KAPI SİSTEMİ: TÜM DENETÇİLERİN ORTAK KARARI

A.6.1 — 4 ZORUNLU KAPI
──────────────────────

GATE-B: Bağlam Kapısı
─────────────────────
Açılma Koşulu:
• Tüm modül bağlam tabloları %100 dolu
• Modüller arası temas haritası onaylı
• Çapraz risk tablosu tamamlanmış

Kapatan Denetçi: EN AZ 2 DENETÇI HEMFİKİR OLMALI

GATE-P: Plan Kapısı
───────────────────
Açılma Koşulu:
• Tam Kapsayıcı Plan onaylı
• Faz görevleri tanımlı
• Kabul kriterleri net

Kapatan Denetçi: EN AZ 2 DENETÇI HEMFİKİR OLMALI

GATE-U: Uyum Kapısı
───────────────────
Açılma Koşulu:
• Mimari sözleşme uyumlu
• Modül sözleşmesi ihlalsiz
• Gelecek rezervi korunmuş

Kapatan Denetçi: EN AZ 2 DENETÇI HEMFİKİR OLMALI

GATE-K: Kalite Kapısı
─────────────────────
Açılma Koşulu:
• Test coverage ≥ %80
• Kritik güvenlik testi geçti
• Performance regression yok

Kapatan Denetçi: EN AZ 2 DENETÇI HEMFİKİR OLMALI

A.6.2 — KAPI DURUM KAYDLARI
───────────────────────────

Her kapı durumu JSON'da tutulur:

GATE-B_STATUS.json:
──────────────────

```json
{
  "gate_name": "GATE-B (Bağlam Kapısı)",
  "status": "CLOSED",
  "last_check": "2026-01-27T11:00:00Z",
  "auditors_required": 2,
  "auditors_approved": [
    {
      "auditor_id": "DENETCI-1",
      "decision": "OPEN",
      "timestamp": "2026-01-27T10:45:00Z",
      "report": ".audits/daily/2026-01-27_DENETCI-1_GUNLUK.md"
    },
    {
      "auditor_id": "DENETCI-2",
      "decision": "OPEN",
      "timestamp": "2026-01-27T10:50:00Z",
      "report": ".audits/daily/2026-01-27_DENETCI-2_GUNLUK.md"
    }
  ],
  "consensus": "ACHIEVED",
  "gate_opens_at": "2026-01-27T11:00:00Z"
}
```

A.6.3 — KAPI AÇILMA OTOMATİZMASYONU
───────────────────────────────────

Sistem otomatik kapı kontrolü yapar:

```python
def check_gate_consensus(gate_name):
    gate_status = load_json(f".gates/{gate_name}_STATUS.json")
    
    required = gate_status["auditors_required"]
    approved = gate_status["auditors_approved"]
    
    # Hemfikir mi?
    decisions = [a["decision"] for a in approved]
    
    if len(approved) < required:
        return "❌ YETERSİZ DENETÇİ"
    
    if len(set(decisions)) > 1:
        return "❌ ÇELİŞKİLİ KARAR - KONTROL LİSTESİ GÜNCELLEME GEREKLİ"
    
    if all(d == "OPEN" for d in decisions):
        open_gate(gate_name)
        return "✅ KAPI AÇILDI"
    
    return "❌ KAPI KAPALI KALDI"
```

═══════════════════════════════════════════════════════════════════

⚖️ MADDE A.7 — DENETÇİ YAPTIRIM VE İZLEME SİSTEMİ

A.7.1 — DENETÇİ İHLAL TÜRLERİ
──────────────────────────────

| İhlal Türü | Tanım | Yaptırım |
|------------|-------|----------|
| EKSİK MATRİS | ZDM başlıklarını tam doldurmama | Rapor reddi |
| ESKİ KONTROL LİSTESİ | Güncel versiyonu kullanmama | Denetim yasağı |
| YETKİSİZ KARAR | Denetim yetkisi olmadan karar alma | Kalıcı yasak |
| ÇELIŞKI ÜRETME | Tekrar eden tutarsız raporlar | Sistem dışı bırakma |

A.7.2 — DENETÇİ PERFORMANS SKORU
─────────────────────────────────

Her denetçi için tutulur:

```json
{
  "auditor_id": "DENETCI-1",
  "total_audits": 47,
  "rejected_reports": 2,
  "consensus_rate": 0.96,
  "avg_completion_time": "12 minutes",
  "last_violation": "2026-01-20T15:30:00Z",
  "status": "ACTIVE"
}
```

A.7.3 — OTOMATIK DENETÇİ ROTASYONU
──────────────────────────────────

Eğer bir denetçi sürekli çelişki üretiyorsa:

1. Sistem UYARI verir
2. 3 uyarıda → Geçici durdurma
3. 5 uyarıda → Sistem dışı bırakma

Yerini başka denetçi alır.

═══════════════════════════════════════════════════════════════════

EK BÖLÜM B — ANDROID STUDIO AI: 0'DAN PLAY STORE'A ADIMLAR
(Global Proje Planında Android Studio AI Eksiksiz Yol Haritası)

═══════════════════════════════════════════════════════════════════

⚖️ MADDE B.1 — FAZ TANIMI VE ZORUNLU BELGELERİ

B.1.1 — PROJE ÖNCESİ: BELGELEŞTİRME FAZI (PHASE-0)
───────────────────────────────────────────────────

Bu fazda Android Studio AI HALA AKTİF DEĞİLDİR.
Bu faz %100 İNSAN OPERATÖRÜN sorumluluğundadır.

ZORUNLU ÇIKTILAR:
─────────────────

1. PROJECT_MANIFEST.md
   • Hedef kullanıcı
   • Ürün problemi
   • Değer önerisi
   • Para kazanma modeli
   • Platform stratejisi

2. ARCHITECTURE_CHARTER.md
   • Katman diyagramı
   • Modül sınırları
   • Yasak bağımlılıklar
   • Teknoloji gerekçeleri
   • Gelecek modül rezervleri

3. UI_UX_CONTRACT.md
   • Navigasyon akışları
   • Ekran tipleri
   • Tasarım tokenları

4. ANDROID_STUDIO_AI_CHARTER.md
   • AI'nin yetkisi
   • AI'nin modları
   • AI'nin yasakları
   • Yaptırım merdiveni

5. MODULE_CONTEXT_REGISTRY.md
   • Tüm modüllerin kimliği
   • Modüller arası temas haritası

KAPI KONTROLÜ:
──────────────

GATE-B (Bağlam): ❌ KAPALI
• Tüm belgeler %100 tamamlanmalı
• EN AZ 2 DENETÇİ onaylamalı

ÇIKTILAR:
─────────

✅ PHASE-0_APPROVAL.md (İnsan operatör + 2 denetçi imzası)

Android Studio AI Durumu: 🔴 PASİF VARLIK

───────────────────────────────────────────────────────────────────

B.1.2 — FAZ-1: TAM KAPSAYICI PLAN OLUŞTURMA
────────────────────────────────────────────

Bu fazda Android Studio AI PASİF'ten BAĞLAM TOPLAMA moduna geçer.

ANDROID STUDIO AI GÖREVLERİ:
────────────────────────────

1. Tüm anayasal belgeleri okur
2. Eksik bağlam noktalarını tespit eder
3. "BAĞLAM BOŞLUKLARI RAPORU" üretir

İNSAN OPERATÖR GÖREVLERİ:
─────────────────────────

1. Bağlam boşluklarını doldurur
2. Tam Kapsayıcı Plan taslağı hazırlar

ANDROID STUDIO AI + İNSAN İŞBİRLİĞİ:
────────────────────────────────────

• İnsan: Epic'leri tanımlar
• Android Studio AI: Her epic'i görevlere böler
• İnsan: Görev önceliklerini belirler
• Android Studio AI: Görevler arası bağımlılıkları analiz eder

ÇIKTILAR:
─────────

✅ COMPREHENSIVE_PLAN_V1.md
   • Tüm epic'ler
   • Tüm görevler
   • Kabul kriterleri
   • Test şartları
   • Tahmin edilen süre

KAPI KONTROLÜ:
──────────────

GATE-P (Plan): ❌ KAPALI
• Plan EN AZ 2 DENETÇİ tarafından onaylanmalı
• Eksik kapsam olmamalı

DENETÇİ KONTROLÜ:
─────────────────

• DENETCI-1 + DENETCI-2 → Planı ZDM matrisiyle denetler
• Hemfikir olmalılar
• Aksi halde → Plan red, revize

✅ PHASE-1_APPROVAL.md (Plan Onayı)

Android Studio AI Durumu: 🟡 BAĞLAM TOPLAMA → 🟢 AKTİF ÜRETİME HAZIRLANıYOR

───────────────────────────────────────────────────────────────────

B.1.3 — FAZ-2: PROJE İSKELETİ (Scaffold)
─────────────────────────────────────────

Android Studio AI artık AKTİF ÜRETİM modundadır.

GÖREVLER:
─────────

1. Android projesi oluştur
   • build.gradle (app & project)
   • AndroidManifest.xml
   • Klasör yapısı (ARCHITECTURE_CHARTER'a uygun)

2. Modül yapısı kur
   • core/
   • data/
   • domain/
   • presentation/
   • di/ (Dependency Injection)

3. Temel bağımlılıklar ekle
   • Jetpack Compose
   • Hilt (DI)
   • Room (DB)
   • Retrofit (Network)
   • Coil (Image Loading)

4. Anayasal kontrol dosyaları ekle
   • .constitution/ klasörü
   • .audits/ klasörü
   • .gates/ klasörü
   • .checklists/ klasörü

ANDROID STUDIO AI ÜRETİM PROTOKOLÜ:
───────────────────────────────────

ADIM 1: Görev al
────────────────

Görev formatı:
```markdown
# GÖREV: Proje İskeleti Oluştur
## Bağlam:
- ARCHITECTURE_CHARTER.md → Modül yapısı bölümü
- MODULE_CONTEXT_REGISTRY.md → Modül listesi

## Yasaklar:
- Mimari belgede olmayan modül ekleme
- Gelecek rezerv alanına dosya yazma

## Kabul Kriterleri:
- Tüm modüller ARCHITECTURE_CHARTER'daki diyagrama uygun
- build.gradle dosyaları bağımlılık sınırlarına uygun
- AndroidManifest.xml güvenlik politikalarına uygun

## Test Şartı:
- Proje build almalı
- Modül bağımlılık testi geçmeli
```

ADIM 2: Kod üret
────────────────

Android Studio AI kodu yazar.

ADIM 3: Otomatik test
─────────────────────

• Build test
• Modül bağımlılık testi
• Lint kontrolü

ADIM 4: Denetçi kontrolü
─────────────────────────

• Sistem otomatik → DENETCI-1 + DENETCI-2 tetikler
• Her ikisi de ZDM matrisi doldurur
• Hemfikir mi kontrol edilir

ADIM 5a: ✅ Onaylandı
─────────────────────

• Kod merge edilir
• OPERATIONAL_TASK_LOG güncellenir
• Bir sonraki göreve geç

ADIM 5b: ❌ Reddedildi
──────────────────────

• Android Studio AI kodu düzeltir
• Tekrar denetçi kontrolü

ADIM 5c: ⚠️ İhlal var
─────────────────────

• Android Studio AI FELÇ moduna girer
• İnsan operatör müdahale eder

KAPI KONTROLÜ:
──────────────

GATE-U (Uyum): ❌ KAPALI
• Scaffold mimari sözleşmeye uygun mu?

DENETÇİ HEMFİKİR RAPORU:
────────────────────────

✅ PHASE-2_HEMFIKIR_SONUC.md
✅ PHASE-2_APPROVAL.md

───────────────────────────────────────────────────────────────────

B.1.4 — FAZ-3: CORE KATMANI GELİŞTİRME
───────────────────────────────────────

GÖREVLER:
─────────

1. Domain Entities
   • User.kt
   • Product.kt
   • Order.kt
   (UI_UX_CONTRACT'daki veri modellerine göre)

2. Use Cases
   • LoginUseCase.kt
   • GetProductsUseCase.kt
   • PlaceOrderUseCase.kt

3. Repository Interfaces
   • UserRepository.kt
   • ProductRepository.kt

4. Core Utilities
   • Result sealed class
   • NetworkError sealed class
   • Extensions.kt

HER GÖREV İÇİN DÖNGÜ:
──────────────────────

1. Android Studio AI → Kod üretir
2. Unit test yazar (coverage ≥ %80)
3. Otomatik test çalıştırır
4. DENETCI-1 + DENETCI-2 → ZDM matrisi doldurur
5. Hemfikirse → Merge
6. Çelişkiyse → Düzelt & tekrar denetle

KAPI KONTROLÜ:
──────────────

GATE-K (Kalite): ❌ KAPALI
• Tüm core sınıfların test coverage'ı ≥ %80 mı?
• Kritik use case'lerin testi var mı?

✅ PHASE-3_HEMFIKIR_SONUC.md

───────────────────────────────────────────────────────────────────

B.1.5 — FAZ-4: DATA KATMANI GELİŞTİRME
───────────────────────────────────────

GÖREVLER:
─────────

1. Room Database
   • AppDatabase.kt
   • UserDao.kt
   • ProductDao.kt
   • Database entities

2. Retrofit API
   • ApiService.kt
   • API models (DTO)
   • Mappers (DTO → Domain)

3. Repository Implementations
   • UserRepositoryImpl.kt
   • ProductRepositoryImpl.kt

4. Data Sources
   • LocalDataSource.kt
   • RemoteDataSource.kt

ANDROID STUDIO AI ÖZEL DİKKAT:
──────────────────────────────

• Network hatası yönetimi
• Database migration stratejisi
• Cache stratejisi
• Error handling

DENETÇI ÖZEL KONTROL:
─────────────────────

• API key'leri hardcoded değil mi?
• SQL injection riski var mı?
• Sensitive data şifreleniyor mu?

KAPI KONTROLÜ:
──────────────

GATE-U (Uyum): Data katmanı core katmanına yasak bağımlılık kuruyor mu?
GATE-K (Kalite): Integration testler geçiyor mu?

✅ PHASE-4_HEMFIKIR_SONUC.md

───────────────────────────────────────────────────────────────────

B.1.6 — FAZ-5: PRESENTATION KATMANI (UI)
─────────────────────────────────────────

GÖREVLER:
─────────

1. Screens (Jetpack Compose)
   • LoginScreen.kt
   • HomeScreen.kt
   • ProductDetailScreen.kt
   • CartScreen.kt
   • CheckoutScreen.kt

2. ViewModels
   • LoginViewModel.kt
   • HomeViewModel.kt
   • ProductDetailViewModel.kt

3. UI Components
   • ProductCard.kt
   • CustomButton.kt
   • LoadingIndicator.kt

4. Navigation
   • NavGraph.kt
   • Routes.kt

UI_UX_CONTRACT UYGUNLUK:
────────────────────────

• Her ekran UI_UX_CONTRACT'daki wireframe'e uygun mu?
• Tasarım tokenları kullanılıyor mu?
• Navigasyon akışı sözleşmeye uygun mu?

ANDROID STUDIO AI ÜRETİM:
─────────────────────────

• UI_UX_CONTRACT.md'yi okur
• Her ekran için Compose kodu üretir
• Preview fonksiyonları ekler
• Accessibility özellikleri ekler

DENETÇI KONTROLÜ:
─────────────────

• DENETCI-1: Mimari uygunluk
• DENETCI-2: UI sözleşme uygunluğu
• Hemfikir mi? → Merge
• Çelişki mi? → Kontrol listesi güncelle, tekrar denetle

KAPI KONTROLÜ:
──────────────

GATE-U: UI katmanı data katmanına doğrudan bağımlı değil mi?
GATE-K: UI testleri (screenshot test) geçiyor mu?

✅ PHASE-5_HEMFIKIR_SONUC.md

───────────────────────────────────────────────────────────────────

B.1.7 — FAZ-6: DEPENDENCY INJECTION (Hilt)
───────────────────────────────────────────

GÖREVLER:
─────────

1. Hilt Modules
   • DatabaseModule.kt
   • NetworkModule.kt
   • RepositoryModule.kt

2. Application Class
   • MyApp.kt (@HiltAndroidApp)

3. DI Testing
   • Test için fake implementations

ANDROID STUDIO AI:
──────────────────

• Tüm modüllere @Module ekler
• Singleton, ViewModelScoped doğru kullanır
• Test için @Provides fake'leri ekler

DENETÇI KONTROLÜ:
─────────────────

• DI graph döngüsel bağımlılık içeriyor mu?
• Test modülü production kodu etkilemiyor mu?

✅ PHASE-6_HEMFIKIR_SONUC.md

───────────────────────────────────────────────────────────────────

B.1.8 — FAZ-7: ENTEGRASYON & TEST
──────────────────────────────────

GÖREVLER:
─────────

1. End-to-End Testler
   • Login flow testi
   • Checkout flow testi

2. UI Testler
   • Espresso / Compose UI Test

3. Performance Testler
   • Startup time
   • Memory usage
   • Network efficiency

4. Güvenlik Testleri
   • ProGuard kuralları
   • SSL pinning
   • Root detection

ANDROID STUDIO AI:
──────────────────

• Her kritik flow için test senaryosu yazar
• Performance baseline ölçer
• Security checklist'i uygular

DENETÇI KONTROLÜ:
─────────────────

• DENETCI-1 + DENETCI-2 → Tüm testler geçiyor mu?
• Coverage ≥ %80 mi?
• Security gap var mı?

KAPI KONTROLÜ:
──────────────

GATE-K (Kalite): TÜM TESTLER GEÇMEDEN SONRAKI FAZA GEÇİLEMEZ

✅ PHASE-7_HEMFIKIR_SONUC.md

───────────────────────────────────────────────────────────────────

B.1.9 — FAZ-8: RELEASE BUILD & SIGNING
───────────────────────────────────────

GÖREVLER:
─────────

1. Release build.gradle
   • ProGuard rules
   • R8 optimization
   • minifyEnabled true

2. Keystore oluştur
   • release.keystore
   • Signing config

3. Version Management
   • versionCode
   • versionName
   • Changelog

4. APK/AAB build
   • Release APK
   • Android App Bundle

ANDROID STUDIO AI:
──────────────────

• build.gradle'ı release için yapılandırır
• ProGuard kurallarını optimize eder
• APK boyutunu minimize eder

DENETÇI KONTROLÜ:
─────────────────

• APK signed mi?
• ProGuard mapping dosyası var mı?
• Obfuscation doğru çalışıyor mu?

✅ PHASE-8_HEMFIKIR_SONUC.md

───────────────────────────────────────────────────────────────────

B.1.10 — FAZ-9: PLAY STORE HAZIRLAMA
─────────────────────────────────────

GÖREVLER:
─────────

1. Google Play Console Setup
   • Developer account
   • App oluştur
   • Store listing

2. Store Assets
   • App icon (512x512)
   • Feature graphic (1024x500)
   • Screenshots (min 2, max 8)
   • Promo video (opsiyonel)

3. Store Listing
   • Başlık (max 30 karakter)
   • Kısa açıklama (max 80 karakter)
   • Tam açıklama (max 4000 karakter)
   • Kategori
   • Tags

4. Content Rating
   • Soru formu doldur
   • Rating al

5. Pricing & Distribution
   • Ücretli/ücretsiz
   • Ülkeler seç
   • Yayın tarihi

ANDROID STUDIO AI YARDIMI:
──────────────────────────

• Store açıklamasını PROJECT_MANIFEST'e göre yazar
• SEO optimize edilmiş keywords önerir
• Screenshot caption'ları yazar

İNSAN OPERATÖR:
───────────────

• Görselleri hazırlar
• Final onayı verir

DENETÇİ KONTROLÜ:
─────────────────

• Store listing PROJECT_MANIFEST'e uygun mu?
• Tüm gerekli assetler hazır mı?
• Google policy uyumlu mu?

✅ PHASE-9_HEMFIKIR_SONUC.md

───────────────────────────────────────────────────────────────────

B.1.11 — FAZ-10: PLAY STORE YAYINLAMA
──────────────────────────────────────

GÖREVLER:
─────────

1. Internal Testing
   • AAB yükle
   • Internal testers ekle
   • Test et

2. Closed Testing (Alpha)
   • Alpha track oluştur
   • Testers ekle
   • Geri bildirim topla

3. Open Testing (Beta)
   • Beta track oluştur
   • Public/private seç
   • Son testler

4. Production Release
   • Production track'e yükle
   • Staged rollout (örn: %10 → %50 → %100)
   • Monitor crashes & ANRs

ANDROID STUDIO AI:
──────────────────

• Her release için changelog yazar
• Crash report'ları analiz eder
• Fix önerileri sunar

DENETÇİ KONTROLÜ:
─────────────────

• Internal testing başarılı mı?
• Beta feedback ciddiye alındı mı?
• Production'a hazır mı?

KAPI KONTROLÜ:
──────────────

GATE-K (Kalite): Crash rate < %1, ANR rate < %0.5
→ Aksi halde production'a yüklenemez

✅ PHASE-10_APPROVAL.md (NİHAİ YAYINLAMA ONAYI)
✅ PRODUCTION_RELEASE_DATE.md

───────────────────────────────────────────────────────────────────

🎯 PLAY STORE'DA CANLIYA ALINDI!

═══════════════════════════════════════════════════════════════════

⚖️ MADDE B.2 — FAZ GEÇİŞ METRİKLERİ

B.2.1 — HER FAZ SONUNDA ZORUNLU KONTROLLER
───────────────────────────────────────────

| Faz | Zorunlu Çıktı | Denetçi Kontrolü | Kapi |
|-----|---------------|------------------|------|
| 0 | Anayasal Belgeler | 2 denetçi onayı | GATE-B |
| 1 | Tam Kapsayıcı Plan | 2 denetçi onayı | GATE-P |
| 2 | Proje İskeleti | 2 denetçi onayı | GATE-U |
| 3 | Core Katmanı | 2 denetçi onayı | GATE-K |
| 4 | Data Katmanı | 2 denetçi onayı | GATE-U, GATE-K |
| 5 | UI Katmanı | 2 denetçi onayı | GATE-U, GATE-K |
| 6 | DI Setup | 2 denetçi onayı | GATE-K |
| 7 | Test & QA | 2 denetçi onayı | GATE-K |
| 8 | Release Build | 2 denetçi onayı | GATE-K |
| 9 | Play Store Assets | 2 denetçi onayı | - |
| 10 | Production Release | 2 denetçi + İnsan onayı | GATE-K |

B.2.2 — ANDROID STUDIO AI PERFORMANS İZLEME
────────────────────────────────────────────

Her fazda tutulur:

```json
{
  "phase": "PHASE-5",
  "ai_metrics": {
    "total_tasks": 15,
    "completed_tasks": 15,
    "rejected_outputs": 3,
    "avg_task_time": "18 minutes",
    "code_quality_score": 0.89,
    "test_coverage": 0.84,
    "violations": 1,
    "paralysis_count": 1
  },
  "auditor_metrics": {
    "total_audits": 30,
    "consensus_rate": 0.93,
    "avg_audit_time": "8 minutes"
  }
}
```

═══════════════════════════════════════════════════════════════════

⚖️ NİHAİ OPERASYONEL HÜKÜM

Bu ek maddelerle birlikte:

✅ Android Studio AI: 0'dan Play Store'a her adımda denetlenir
✅ Denetçiler: Kaç tane olursa olsun HEMFİKİR çalışır
✅ Kalite farkı: İMKANSIZDIR (ortak kontrol listesi)
✅ Kapi sistemi: Anayasal koruma sağlar
✅ İnsan Operatör: Nihai karar merciidir

SİSTEM ARTIK:
┌─────────────────────────────────────────────────┐
│ • BAĞLAMDAN BAĞIMSIZ ÇALIŞMAZ                   │
│ • PLANSIZ ÜRETİM YAPMAZ                         │
│ • DENETÇİSİZ İLERLEYEMEZ                        │
│ • HEMFIKIR OLMADAN KAPIDAN GEÇEMEZ              │
│ • ANAYASAL İHLALDE FELCE UĞRAR                  │
└─────────────────────────────────────────────────┘

🔴 DENETÇİ KAPANIŞ HÜKMÜ
─────────────────────────

Bu metin:

• Denetçi kalite farkı sorununa anayasal cevaptır
• Android Studio AI'nin 0'dan Play Store'a tam yol haritasıdır
• Global proje planında eksiksiz adım listesidir

Eksik olan:

❌ Metin değil
❌ Kural değil
❌ İlke değil

✅ Uygulama
✅ Kayıt
✅ Kanıt
✅ İcra

katmanlarıdır.

Bu metni uygulayan sistem:

ARTIK ŞİRKET GİBİ İŞLER.

═══════════════════════════════════════════════════════════════════
BELGE SONU
═══════════════════════════════════════════════════════════════════
