# İSİMLENDİRME SÖZLEŞMESİ (NAMING CONVENTION CHARTER)

**ANAYASAL KİMLİK BLOĞU**
*Bu belge, PATIDOST Anayasası uyarınca bağlayıcıdır ve sistemdeki tüm varlıkların isimlendirme kurallarını tanımlar.*

---

- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION §11 (Altyapı Bütünlüğü)
- **NORM TÜRÜ:** Sözleşme
- **BAĞLI OLDUĞU MADDELER:** ANAYASAL_EK_PROTOKOL §1.2 (Sistem Gerçekliği Önceliği)
- **GEÇERLİ FAZLAR:** Tüm Fazlar
- **BAĞLADIĞI ROLLER:** Tüm Roller (İnsan Operatör, Denetçiler, AI Ajanları)
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## 1. Anayasal Gerekçe

Projenin otomasyon (script, CI/CD) ve platformlar arası (Windows, Linux, macOS) bütünlüğünü garanti altına almak, "Hayalet Varlık" ve "Sessiz Hata" krizlerini önlemek amacıyla, tüm anayasal ve teknik varlıklar için evrensel ve kararlı bir isimlendirme standardı zorunludur.

## 2. Temel Hükümler

*   **Madde 1 (ASCII Zorunluluğu):** Proje kök dizini altındaki tüm dosya ve klasör adları, yalnızca standart ASCII karakter setini (`a-z`, `A-Z`, `0-9`, `-`, `_`, `.`) kullanmalıdır. Türkçe karakterler (`ç`, `ğ`, `ı`, `ö`, `ş`, `ü`, `Ç`, `Ğ`, `İ`, `Ö`, `Ş`, `Ü`) ve boşluk karakteri **kesinlikle yasaktır**.

*   **Madde 2 (İsimlendirme Standardı):** Dosya adları, içeriklerini ve amaçlarını yansıtacak şekilde, **BüyükHarfleBaşlayanKelime (PascalCase)** veya **büyük_harfli_alt_çizgili (SCREAMING_SNAKE_CASE)** formatında olmalıdır.
    *   **Örnek (Doğru):** `SYSTEM_INTEGRITY_REPORT.md`, `ScreenCharterTemplate.md`
    *   **Örnek (Yanlış):** `sistem bütünlük raporu.md`, `screen_charter-template.md`

## 3. Anayasal Etki ve Yaptırım

*   **Madde 3.1:** Bu sözleşmenin yürürlüğe girmesiyle birlikte, bu kurallara uymayan mevcut tüm dosyalar "ANAYASAL-OLARAK-BOZUK" statüsüne girer ve onarılması zorunludur.
*   **Madde 3.2:** `verifyConstitutionState` Gradle görevi, bu isimlendirme kurallarını ihlal eden bir dosya tespit ettiğinde derlemeyi **durdurur** ve `EVIDENCE-NAMING_VIOLATION.md` kanıtını üretir.

## 4. Yürürlük

Bu sözleşme, Denetçi-1, Denetçi-2 ve İnsan Operatör tarafından onaylandıktan sonra yürürlüğe girer ve geriye dönük olarak uygulanır.
