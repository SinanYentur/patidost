# ANAYASA: FAZ-5 (SİSTEM EVRİMİ, KONTROLLÜ GELİŞİM VE SİSTEM BİYOLOJİSİ SÖZLEŞMESİ)

**ANAYASAL KİMLİK BLOĞU**
---
- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md, ANAYASAL_EK_PROTOKOL.md
- **NORM TÜRÜ:** Uygulama Anayasası (Lex Operativa)
- **ANAYASAL KAYIT ID:** SECC-001
- **PIN_TABLE REFERANSI:** `.constitution/PIN_TABLE.md`
- **BAĞLI OLDUĞU MADDELER:** OMEGA_CODEX §5, §10; COMPANY_CONSTITUTION §12
- **GEÇERLİ FAZLAR:** Tüm Fazlar (Özellikle Büyüme ve Olgunluk)
- **BAĞLADIĞI ROLLER:** Mimar, İcra Ajanı, Denetçiler, Proje Yöneticisi
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Üst Kanun (Çok Zor Değişir)

---

## BÖLÜM 1: EVRİMSEL DEĞİŞİM HUKUKU

*   **Madde 1.1 (Değişim Sınıfları):** Sisteme yapılacak her değişiklik, aşağıdaki sınıflardan birine girmek zorundadır:
    *   **Minör (Yama):** Mevcut işlevselliği bozmayan, hata düzeltmeleri veya küçük iyileştirmeler. (Denetçi onayı yeterli)
    *   **Majör (Özellik):** Yeni bir modül veya özellik ekleyen, mevcut akışları değiştiren yenilikler. (İcra Envanteri güncellemesi ve Denetçi + İnsan onayı zorunlu)
    *   **Kırıcı (Mimari):** Anayasal sözleşmeleri, modül sınırlarını veya veri yapılarını değiştiren köklü dönüşümler. (Sadece FAZ GEÇİŞİ ile ve İnsan Operatör'ün doğrudan emriyle yapılabilir)
    *   **Yasaklı (Mutasyon):** Anayasanın temel ilkelerine aykırı, geri dönüşü olmayan riskli değişiklikler. (Otomatik Red)
*   **Madde 1.2 (Anayasal Etki Simülasyonu):** Her "Kırıcı" değişiklik öncesi, değişikliğin sistemin geri kalanına etkisini gösteren bir `CHANGE_IMPACT_SIMULATION.md` raporu üretilmelidir.

## BÖLÜM 2: MİMARİ MUTASYON DENETİMİ

*   **Madde 2.1 (Katman İhlal Dedektörü):** CI pipeline, kod tabanında aşağıdaki "mutasyonları" sürekli tarar:
    *   `UI` katmanından `Data` katmanına doğrudan erişim.
    *   `Domain` katmanında Android framework bağımlılığı.
    *   Döngüsel modül bağımlılıkları.
*   **Madde 2.2 (Core Kontaminasyon):** `:core` modüllerine yapılacak her ekleme, "Bu kod neden bir feature modülünde değil?" sorusunun cevabını içeren bir gerekçe raporu gerektirir.

## BÖLÜM 3: TEKNİK BORÇ ANAYASASI

*   **Madde 3.1 (Borç Sınıflandırması):** Teknik borçlar, "Bilinçli" (stratejik hız için alınan) ve "Bilinçsiz" (kötü tasarım sonucu oluşan) olarak ikiye ayrılır. Bilinçsiz borçlar anayasal ihlaldir.
*   **Madde 3.2 (Faiz Modeli):** Her "Bilinçli" borç, bir "Vade Tarihi" ve "Kapatma Planı" ile `DEBT_REGISTER.md` dosyasına kaydedilir. Vadesi geçen borçlar, yeni özellik geliştirmeyi bloke eden bir "Borç Kriz Protokolü"nü tetikler.

## BÖLÜM 4: BİLGİ VE KARAR GENETİĞİ

*   **Madde 4.1 (Karar DNA Zinciri):** Her mimari karar, `ARCHITECTURE_DECISIONS_LOG.md` (ADR) içinde, önceki kararlarla ilişkisi ve evrimi gösterilecek şekilde zincirleme olarak kaydedilir.
*   **Madde 4.2 (Bilgi Kaybı Önleme):** Projeden ayrılan bir rol veya kapatılan bir modül olduğunda, o varlığın tüm bilgisi ve sorumlulukları, "Miras Protokolü" ile başka bir varlığa devredilir. Sahipsiz bilgi veya kod bırakılamaz.

## BÖLÜM 5: SİSTEM EKOLOJİSİ

*   **Madde 5.1 (Dış Bağımlılık Yaşam Döngüsü):** Projeye eklenen her harici kütüphane, bir "Yaşam Döngüsü Sahibi"ne atanır. Bu sahip, kütüphanenin güncelliğinden, güvenlik açıklarından ve gerekirse projeden çıkarılmasından sorumludur.
*   **Madde 5.2 (Platform Göç Hukuku):** Sistemin, temel platform (Android) veya dil (Kotlin) değişikliklerine uyum sağlama stratejisi, yıllık olarak gözden geçirilen `PLATFORM_MIGRATION_STRATEGY.md` belgesinde tanımlanır.

---

**YÜRÜRLÜK:** Bu belgenin onaylanması, FAZ-5'in eksik anayasal kilitlerinin tamamlanması için kritik bir adımdır.
