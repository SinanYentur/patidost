# ALT PROTOKOL: META-YÖNETİŞİM VE EPİSTEMİK GÜVENLİK (SP-06)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/META_GOVERNANCE_AND_CONTROL_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Detay Protokolü
- **ETKİ ALANI:** Denetçiler, AI, İnsan Operatör
- **RİSK SEVİYESİ:** Stratejik

---

## 1. DENETÇİ HATA MODELİ

### 1.1. YANILGI TESPİTİ
Bir denetçinin kararı, aşağıdaki durumlarda "Hatalı" olarak işaretlenir:
*   Fiziksel kanıtla (Log, Kod) çelişiyorsa.
*   Anayasa maddesini yanlış yorumluyorsa.
*   Diğer iki denetçi (Veya İnsan) ile mutabık kalamıyorsa.

### 1.2. DÜZELTME MEKANİZMASI
Hatalı karar veren denetçi:
1.  **Uyarı:** Sistem tarafından uyarılır.
2.  **Askıya Alma:** Hatada ısrar ederse, yetkileri geçici olarak dondurulur.
3.  **Sıfırlama:** Bağlamı temizlenir ve göreve yeniden başlatılır.

## 2. AI HALÜSİNASYON FİLTRESİ

### 2.1. DOĞRULUK KONTROLÜ (FACT-CHECK)
AI Ajanları tarafından üretilen her teknik iddia (Örn: "Bu kütüphane şu özelliği destekler"), şu filtrelerden geçer:
*   **Varlık Kontrolü:** Bahsedilen dosya/sınıf projede var mı?
*   **Versiyon Kontrolü:** Bahsedilen özellik, kullanılan versiyonda mevcut mu?
*   **Tutarlılık Kontrolü:** Önceki raporlarla çelişiyor mu?

### 2.2. KARANTİNA
Doğrulanamayan bilgi, `UNVERIFIED_INFO.md` dosyasına taşınır ve üretim sürecinden izole edilir.

## 3. DİJİTAL MİRAS VE DEVİR PROTOKOLÜ

### 3.1. SAHİPSİZLİK SENARYOSU
İnsan Operatör'den 30 gün boyunca "İmzalı Komut" (GPG) alınamazsa:
1.  Sistem **"KORUMA MODU"**na geçer.
2.  Tüm yazma izinleri kapatılır (Read-Only).
3.  Son stabil sürümün yedeği şifrelenerek `archived_legacy.zip` olarak saklanır.

### 3.2. MİRAS PAKETİ
Sistemin devredilmesi gerektiğinde, aşağıdaki paket otomatik hazırlanır:
*   Tüm Kaynak Kod
*   Tüm Anayasal Belgeler
*   Anahtar ve Sırlar (Şifreli)
*   Karar Geçmişi (ADR)

---
**OPERASYONEL KARŞILIK:** `scripts/verify_ai_facts.sh`, `scripts/auditor_health_check.sh`
**FAZ GEÇİŞ ŞARTI:** Denetçi sağlık skoru %100 olmalı.
