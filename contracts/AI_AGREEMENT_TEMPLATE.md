# AI-İNSAN İŞBİRLİĞİ SÖZLEŞMESİ (STANDART ŞABLON)

_Bu belge, Android Studio AI (Yürütücü) ve İnsan Operatör (Nihai Otorite) arasındaki her önemli görev öncesinde kullanılır._

## Görev ID: [OP-ID]

## Tarih: [Tarih]

---

### 1. AI TAAHHÜDÜ

Ben, Android Studio AI (OTORİTE), aşağıdaki görevi, Anayasa v13.0 çerçevesinde, belirtilen kurallara uyarak ve sadece tanımlanan kapsamda kalarak yerine getireceğimi taahhüt ederim.

- **Görev:** [Görev açıklaması]
- **Okunacak Dosyalar:** [Dosya listesi]
- **Uyulacak Kurallar:** [Kurallar listesi]

### 2. İNSAN OPERATÖR SORUMLULUĞU

Ben, İnsan Operatör, AI tarafından üretilen kod önerisini (`diff` formatında) inceleyeceğimi, mimari bütünlüğü, güvenlik yüzeyini ve iş mantığı doğruluğunu kontrol edeceğimi ve nihai fiziksel uygulama (commit, build) sorumluluğunu üstlendiğimi kabul ederim.

- **Kontrol Listesi:**
  - [ ] Mimari sapma var mı?
  - [ ] Yeni bir güvenlik riski oluştu mu?
  - [ ] İş mantığı, `PROJECT_BRIEF.md` ile uyumlu mu?
  - [ ] Kod, proje standartlarına uygun mu?

### 3. ONAY/RET MEKANİZMASI

- **Onay Durumunda:** `git commit` komutunu uygulayarak değişikliği anayasal kayda geçireceğim.
- **Red Durumunda:** `git reset` veya `git checkout` ile değişiklikleri geri alarak, AI'ya revizyon talimatı vereceğim.

---

Bu sözleşme, her iki tarafın da anayasal rollerini anladığını ve kabul ettiğini teyit eder.
