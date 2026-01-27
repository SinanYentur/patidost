# MİMARİ KARAR KAYITLARI (ADR)

## ADR-001: Merkezi Build Mantığı (buildSrc)
**Tarih:** 2026-01-26
**Statü:** ONAYLANDI
**Karar Veren:** AI Planlayıcı → İnsan Onayı

### Bağlam
Çok modüllü yapıda build tutarlılığını sağlamak.

### Karar
`buildSrc` ve Convention Plugin'ler kullanılarak build mantığı merkezileştirildi.

### Sonuçlar
- Tekrarlı Gradle kodları temizlendi.
- Versiyon yönetimi merkezileşti.

---
## ADR-002: Mimari Pattern Seçimi (v8.0 Uyum)
**Tarih:** 2026-01-26
**Statü:** ONAYLANDI
**Karar Veren:** AI Planlayıcı → İnsan Onayı

### Karar
**MVVM + Clean Architecture + Repository Pattern** seçildi.

**Gerekçe:**
- Android Jetpack ile tam uyumlu
- Test edilebilirlik %80+
- Sürdürülebilirlik yüksek

### Uyumluluk
- ROADMAP_PHASES.md: ✅ Uyumlu
- Test stratejisi: ✅ Destekliyor
- CI/CD: ✅ Otomasyona uygun

---
**İNSAN ONAYI:** 2026-01-26 — Kratos35
"Bu mimari kararı okudum, anladım, onaylıyorum."