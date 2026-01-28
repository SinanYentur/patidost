# ANAYASA: FAZ-5 (SİSTEM EVRİMİ, KONTROLLÜ GELİŞİM VE SİSTEM BİYOLOJİSİ SÖZLEŞMESİ)

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** GLOBAL_PRE_EMPTIVE_CONSTITUTION.md
- **NORM TÜRÜ:** Uygulama Anayasası (Lex Operativa)

---

## BÖLÜM 1: EVRİMSEL DEĞİŞİM HUKUKU

*   **Madde 1.1 (Değişim Sınıfları):** Sisteme yapılacak her değişiklik, aşağıdaki sınıflardan birine girmek zorundadır:
    *   **Minör (Yama):** Mevcut işlevselliği bozmayan, hata düzeltmeleri.
    *   **Majör (Özellik):** Yeni bir özellik ekleyen, mevcut akışları değiştiren yenilikler.
    *   **Kırıcı (Mimari):** Anayasal sözleşmeleri veya modül sınırlarını değiştiren köklü dönüşümler.
    *   **Yasaklı (Mutasyon):** Anayasanın temel ilkelerine aykırı değişiklikler.
*   **Madde 1.2 (Anayasal Etki Simülasyonu):** Her "Kırıcı" değişiklik öncesi, bir `CHANGE_IMPACT_SIMULATION.md` raporu üretilmelidir.

## BÖLÜM 2: MİMARİ MUTASYON DENETİMİ

*   **Madde 2.1 (Katman İhlal Dedektörü):** CI pipeline, kod tabanında katman ihlallerini (`UI` -> `Data`) ve döngüsel bağımlılıkları sürekli tarar.
*   **Madde 2.2 (Core Kontaminasyon):** `:core` modüllerine yapılacak her ekleme, "Bu kod neden bir feature modülünde değil?" sorusunun cevabını içeren bir gerekçe raporu gerektirir.

## BÖLÜM 3: TEKNİK BORÇ ANAYASASI

*   **Madde 3.1 (Borç Sınıflandırması):** Teknik borçlar, "Bilinçli" (stratejik) ve "Bilinçsiz" (kötü tasarım) olarak ikiye ayrılır. Bilinçsiz borçlar anayasal ihlaldir.
*   **Madde 3.2 (Faiz Modeli):** Her "Bilinçli" borç, bir "Vade Tarihi" ve "Kapatma Planı" ile `DEBT_REGISTER.md` dosyasına kaydedilir. Vadesi geçen borçlar, yeni özellik geliştirmeyi bloke eder.

## BÖLÜM 4: BİLGİ VE KARAR GENETİĞİ

*   **Madde 4.1 (Karar DNA Zinciri):** Her mimari karar, `ARCHITECTURE_DECISIONS_LOG.md` (ADR) içinde, önceki kararlara referans vererek zincirleme olarak kaydedilir.
*   **Madde 4.2 (Bilgi Kaybı Önleme):** Projeden ayrılan bir rol olduğunda, o varlığın tüm bilgisi "Miras Protokolü" ile başka bir varlığa devredilir.

## BÖLÜM 5: SİSTEM EKOLOJİSİ

*   **Madde 5.1 (Dış Bağımlılık Yaşam Döngüsü):** Projeye eklenen her harici kütüphane, bir "Yaşam Döngüsü Sahibi"ne atanır.
*   **Madde 5.2 (Platform Göç Hukuku):** Sistemin, temel platform (Android, Kotlin) değişikliklerine uyum stratejisi, `PLATFORM_MIGRATION_STRATEGY.md` belgesinde tanımlanır.
