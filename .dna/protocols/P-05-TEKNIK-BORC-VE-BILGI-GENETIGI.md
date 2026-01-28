# PROTOKOL: TEKNİK BORÇ FAİZ MODELİ VE BİLGİ GENETİĞİ (P-05)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/SYSTEM_EVOLUTION_AND_CHANGE_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Prosedürü
- **ETKİ ALANI:** Mimari, Planlama, Kod Kalitesi
- **RİSK SEVİYESİ:** Yüksek

---

## 1. TEKNİK BORÇ FAİZ MODELİ

Teknik borç, finansal borç gibidir; ödenmezse faiz işler.

### 1.1. FAİZ HESAPLAMA YÖNTEMİ
*   **Düşük Faiz (%10/Sprint):** "TODO: Refactor later" notları, küçük kod tekrarları.
*   **Orta Faiz (%50/Sprint):** Test eksikliği (`Coverage < %80`), Modül sınır ihlalleri (Geçici `api` kullanımı).
*   **Yüksek Faiz (%100/Sprint):** "Hayalet Dosya", "Fake Veri Sızıntısı", "Anayasal Doküman Eksikliği". Bu borçlar, her hafta sistemin karmaşıklığını ve kırılganlığını ikiye katlar.

### 1.2. BORÇ TAVANI VE İFLAS
*   **Borç Tavanı:** `DEBT_REGISTER.md` dosyasındaki toplam "Puan", projenin toplam efor kapasitesinin %30'unu aşamaz.
*   **Teknik İflas:** Borç tavanı aşıldığında, sistem **"BORÇ ÖDEME MODU"**na girer. Yeni özellik geliştirme **YASAKLANIR**. Tüm efor, borçları temizlemeye ayrılır.

## 2. BİLGİ GENETİĞİ (DECISION DNA)

Bir kararın "neden" alındığı, kararın kendisinden daha önemlidir.

### 2.1. KARAR MİRASI ZİNCİRİ
Her yeni mimari karar (`ADR`), kendinden önceki kararlara referans vermek zorundadır:
*   **Parent Decision:** Bu karar, hangi eski kararın üzerine bina edildi? (Örn: "MVI mimarisi (ADR-002), Clean Architecture (ADR-001) üzerine kurulmuştur.")
*   **Mutation Reason:** Neden değişiklik yapıldı? (Örn: "LiveData yetersiz kaldığı için StateFlow'a geçildi.")

### 2.2. KAYIP HALKA TESPİTİ
Eğer bir kod parçası veya modül, herhangi bir `ADR` veya `Charter` belgesine dayandırılamıyorsa, o parça **"Genetik Mutasyon"** (Kanser) olarak kabul edilir ve karantinaya alınır.

---
**YÜRÜRLÜK:** Bu protokol, `PIN_TABLE`'a işlendiği andan itibaren geçerlidir.
