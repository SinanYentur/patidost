# ANAYASAL MEŞRUİYET VE BÜTÜNLÜK SÖZLEŞMESİ (FAZ-1)

**ANAYASAL KİMLİK BLOĞU**
---
- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md
- **NORM TÜRÜ:** Uygulama Anayasası (Lex Operativa)
- **ANAYASAL KAYIT ID:** CLC-001
- **PIN_TABLE REFERANSI:** `.constitution/PIN_TABLE.md`
- **BAĞLI OLDUĞU MADDELER:** OMEGA_CODEX §1, §2; COMPANY_CONSTITUTION §11
- **GEÇERLİ FAZLAR:** Tüm Fazlar
- **BAĞLADIĞI ROLLER:** İnsan Operatör, Denetçiler, AI Ajanları
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Üst Kanun (Çok Zor Değişir)

---

## BÖLÜM 1: ANAYASAL VERSİYONLAMA SİSTEMİ

*   **Madde 1.1 (Zorunlu Versiyonlama):** `.constitution/` altındaki her anayasal belge, adında veya içeriğinde bir `SemVer` (örn: v1.1.0) versiyon numarası taşımak zorundadır.
*   **Madde 1.2 (Sürüm Notu Kaydı):** Anayasada yapılan her değişiklik, `.constitution/VERSION.lock` dosyasına şu formatta işlenir: `[Versiyon] - [Tarih] - [Değişikliği Yapan Rol] - [Gerekçe ve Etki Özeti]`.
*   **Madde 1.3 (Kırılım Matrisi):** Her yeni anayasa versiyonu, hangi eski kuralları geçersiz kıldığını, hangi fazları ve rolleri etkilediğini açıkça belirten bir "Sürüm Kırılım Matrisi" içermek zorundadır.

## BÖLÜM 2: ANAYASAL BÜTÜNLÜK KRİPTOGRAFİSİ

*   **Madde 2.1 (Checksum Zorunluluğu):** `scripts/verify_constitution_checksum.sh` script'i, `.constitution` klasöründeki tüm `.md` dosyalarının bütünlüğünü doğrulamak için bir `SHA256` hash'i (`.checksum` dosyası) kullanır. Bu script, her `pre-commit` ve `CI` adımında çalışmak zorundadır.
*   **Madde 2.2 (İmza Mekanizması):** Anayasanın Çekirdek (Meta) belgelerinde yapılacak değişiklikler, İnsan Operatör'ün GPG anahtarı ile imzalanmış bir `commit` ile yapılmalıdır. Bu, en üst düzey anayasal değişikliklerin kaynağını kriptografik olarak kanıtlar.

## BÖLÜM 3: ANAYASAL ETKİ BEYANI (CHANGE IMPACT)

*   **Madde 3.1 (Zorunlu Belge):** Anayasayı veya Üst Kanunları etkileyen her `Pull Request` veya `merge`, kök dizinde `CHANGE_IMPACT.md` adında bir rapor içermek zorundadır.
*   **Madde 3.2 (Rapor İçeriği):** Bu rapor, asgari olarak şu başlıkları içermelidir: "Etkilenen Fazlar", "Etkilenen Roller", "Etkilenen Anayasal Sözleşmeler", "Potansiyel Kriz Senaryoları".
*   **Madde 3.3 (Otomatik Denetim):** CI pipeline, `CHANGE_IMPACT.md` dosyası olmayan veya içeriği boş olan PR'ları otomatik olarak reddeder.

---

**YÜRÜRLÜK:** Bu belgenin onaylanması, FAZ-1'in eksik anayasal kilitlerinin tamamlanması için ilk adımdır. Bu kuralları uygulayacak teknik mekanizmaların (script'ler, Gradle görevleri) oluşturulması, bir sonraki icra adımı olacaktır.
