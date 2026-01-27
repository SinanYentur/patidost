# MİMARİ KARAR KAYIT DEFTERİ (ARCHITECTURE DECISIONS LOG - ADR)

_Bu belge, proje boyunca alınan önemli mimari kararları kaydeder. Her karar, gerekçesi, alternatifi ve sonucu ile belgelenir. AI Planlayıcı tarafından güncellenir._

## ADR-001: Merkezi Build Mantığı için `buildSrc` Kullanımı

- **Tarih:** 2024-05-24
- **Durum:** KABUL EDİLDİ
- **Gerekçe:** Projedeki tüm modüllerin (`:app`, `:core`, `:feature:*`) aynı build ayarlarına (SDK versiyonları, derleyici seçenekleri, bağımlılıklar) sahip olmasını garanti altına almak, kod tekrarını önlemek ve build sistemini tek bir merkezden yönetmek.
- **Sonuç:** `buildSrc` modülü oluşturuldu ve tüm anayasal build kanunları (`patidost.android.library` vb.) burada tanımlandı.

---
