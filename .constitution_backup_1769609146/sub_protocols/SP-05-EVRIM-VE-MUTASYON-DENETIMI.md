# ALT PROTOKOL: EVRİM, MUTASYON VE BORÇ YÖNETİMİ (SP-05)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/SYSTEM_EVOLUTION_AND_CHANGE_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Detay Protokolü
- **ETKİ ALANI:** Mimari, Refactor, Planlama
- **RİSK SEVİYESİ:** Yüksek

---

## 1. KATMAN İHLAL TESPİTİ (LAYER VIOLATION DETECTION)

### 1.1. YASAKLI ERİŞİMLER
Aşağıdaki erişim desenleri, derleme zamanında (`Lint` veya `ArchUnit` ile) engellenmelidir:
*   `UI` -> `Database` (Asla!)
*   `UI` -> `Network` (Asla!)
*   `Domain` -> `Android Framework` (Context, View vb. yasak)
*   `Data` -> `UI` (Ters akış yasak)

### 1.2. YAPTIRIM
Bir commit bu kuralları ihlal ederse:
1.  CI build **BAŞARISIZ** olur.
2.  `EVIDENCE-ARCH-VIOLATION.md` raporu üretilir.
3.  İhlal düzeltilmeden `merge` yapılamaz.

## 2. TEKNİK BORÇ KRİZ PROTOKOLÜ

### 2.1. BORÇ LİMİTİ
Sistemin toplam "Teknik Borç Puanı" (TDP), belirlenen eşiği (Örn: 1000 Puan) aşarsa:
*   **Otomatik Kilit:** Yeni özellik (Feature) geliştirme branch'leri kilitlenir.
*   **Zorunlu Refactor:** Sprint eforunun %100'ü borç ödemeye ayrılır.
*   **Çıkış:** TDP, güvenli seviyeye (Örn: 500 Puan) düşene kadar kilit açılmaz.

## 3. PLATFORM GÖÇ HUKUKU (MIGRATION LAW)

### 3.1. ZORUNLU GÜNCELLEME
Android veya Kotlin'in yeni bir majör sürümü çıktığında (Örn: Android 16, Kotlin 2.0):
1.  Sistem **"GÖÇ HAZIRLIK MODU"**na girer.
2.  `MIGRATION_PLAN.md` oluşturulur.
3.  Eski sürümde kalmak, her ay artan bir "Teknik Borç Cezası" (Faiz) üretir.

### 3.2. EVRİM ABORT KRİTERLERİ
Bir göç veya refactor işlemi sırasında:
*   Build süresi %50 artarsa,
*   Crash oranı %1'i geçerse,
*   Ana akış testleri (Core Flows) başarısız olursa,
İşlem **İPTAL EDİLİR (ABORT)** ve sistem bir önceki stabil sürüme (`ROLLBACK`) döner.

## 4. DEĞİŞİM KARANTİNASI

Kırıcı (Breaking) değişiklikler içeren bir modül, ana sisteme entegre edilmeden önce 1 hafta boyunca **"Karantina Branch"**inde bekletilir. Bu sürede sadece test ve yük denemeleri yapılır.

---
**OPERASYONEL KARŞILIK:** `scripts/check_layer_violations.sh`, `DEBT_REGISTER.md`
**FAZ GEÇİŞ ŞARTI:** Borç limiti aşılmamış olmalı.
