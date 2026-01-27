# PATIDOST TEK ve MERKEZİ OPERASYON ANAYASASI v1.0

**Sürüm:** 1.0 (Donmuş Sürüm)
**Statü:** Yürürlükte
**Amaç:** Yazılım üretimini kişisel çaba veya AI iyi niyetinden çıkarıp, zorlayıcı süreçlere, otomatik kapılara ve mimari sözleşmelere bağlamak.

---

### BÖLÜM 1: TEMEL HÜKÜMLER (LEX SUPREMA)

**Madde 1.1 (Kanıt Zorunluluğu):** Kanıtı (log, rapor, build çıktısı) olmayan hiçbir eylem (kod, karar, denetim) meşru sayılamaz.

**Madde 1.2 (Yetki Ayrımı):** Kod yazan onaylayamaz, karar veren uygulayamaz, denetleyen üretemez.

**Madde 1.3 (Mimari Üstünlük):** Çalışan kod, doğru kod değildir. Mimariye uymayan kod, kusurlu üründür.

**Madde 1.4 (Sistem Onuru):** Sistem, bilinen yalanlarla (örn: kırık build'i "önemsiz" saymak) ilerleyemez. Dürüstlük, hızdan üstündür.

---

### BÖLÜM 2: SİSTEM AKTÖRLERİ ve SINIRLARI

**Madde 2.1 (İnsan Operatör):** Nihai otoritedir. Ürün vizyonu, mimari kararlar, teknoloji seçimi, güvenlik politikaları ve kriz komutası yetkisindedir. Rutin kod üretimi yasak alanıdır.

**Madde 2.2 (Android Studio AI):** Sorumlu üretim motorudur. Tanımlı mimari içinde kod, test ve doküman üretir. Mimari seçemez, güvenlik modeli tasarlayamaz, "doğru budur" diyemez.

**Madde 2.3 (Otonom Denetçi):** Kilitleyici sistemdir. Build durdurur, merge engeller, faz geçişini bloke eder. Kod yazamaz, karar alamaz.

---

### BÖLÜM 3: ZORUNLU BELGE HİYERARŞİSİ (ANAYASAL DOSYALAR)

*Bu belgeler olmadan hiçbir operasyon başlayamaz.*

**Madde 3.1:** `docs/PROJECT_MANIFEST.md` (Ürün Anayasası)
**Madde 3.2:** `docs/ARCHITECTURE_CHARTER.md` (Mimari Sözleşme)
**Madde 3.3:** `docs/UI_UX_CONTRACT.md` (Tasarım Anayasası)
**Madde 3.4:** `docs/OPERATIONAL_TASK_LOG.md` (Operasyon Defteri)
**Madde 3.5:** `contracts/PHASE_APPROVAL_X.md` (Faz Sözleşmesi)

---

### BÖLÜM 4: OPERASYON MODELİ ve KIRILMA ÖNLEME

**Madde 4.1 (Etki Analizi Kapısı):** Her önemli değişiklik öncesi `docs/features/FEATURE_IMPACT.md` dosyası oluşturulur. Bu dosyada etkilenen modüller, riskler ve geri alma yolu belirtilir. Bu olmadan görev başlayamaz.

**Madde 4.2 (İzolasyon Zorunluluğu):** Yeni feature asla doğrudan ana akışa yazılamaz. Zorunlu yaşam döngüsü: `sandbox` -> `integration-lab` -> `main`.

**Madde 4.3 (Modül Sözleşmeleri):** Her modül, `allowed.md` (izinler) ve `forbidden.md` (yasaklar) dosyalarını taşır. Denetçi, bu sözleşmelere göre rapor yazar.

---

### BÖLÜM 5: AI YÖNETİŞİMİ ve DENETİMİ

**Madde 5.1 (AI Sorumluluk Çerçevesi):** AI, her görevde PLAN, ETKİ HARİTASI, RİSK BİLDİRİMİ ve DERLEME KANITI üretmekle yükümlüdür. Biri eksikse, AI çıktısı geçersizdir.

**Madde 5.2 (AI Hafıza Yönetimi):** AI'da bağlam çöküşü (aynı hatayı tekrar etme, eski kuralları unutma) tespit edildiğinde, `CONTEXT REFRESH` protokolü uygulanır. AI susturulur ve yalnızca çekirdek anayasa belgeleriyle yeniden başlatılır.

**Madde 5.3 (Denetçi Tembellik Kilidi):** Denetçi raporları "Genel olarak iyi" gibi ifadeler kullanamaz. Her bulgu; **KANIT -> RİSK -> ETKİ -> HÜKÜM** zincirini içermek zorundadır.

---

### BÖLÜM 6: KRİZ, DONMA ve YENİDEN İNŞA HUKUKU

**Madde 6.1 (Kriz Modu):** Sistemik bir hata (örn: aynı build hatasının 3. kez tekrarı) durumunda, sistem KRİZ MODU'na girer. Bu modda yeni feature yazmak ve refactor yapmak anayasal suçtur.

**Madde 6.2 (Freeze Core):** Projenin her zaman çalışan, en küçük, en temiz ve dokunulmaz bir çekirdek versiyonu (`FREEZE_CORE`) tanımlı olmalıdır. Büyük krizlerde sistem bu çekirdeğe geri çekilir.

---

### BÖLÜM 7: CANLI SİSTEM ve YAYIN HUKUKU

**Madde 7.1 (Yayın Genetiği - Release DNA):** Her yayın, kanıt zinciri, risk profili ve sorumluluk haritasını içeren bir `RELEASE_DNA.json` kimliği taşır.

**Madde 7.2 (Geri Alma Hakkı):** Rollback planı olmayan sürüm, canlıya çıkamaz. Canlıda kritik hata (crash > %0.5, veri kaybı riski vb.) tespit edildiğinde sistem, insan onayı beklemeden otomatik olarak geri döner.

---

### BÖLÜM 8: YÜRÜRLÜK ve DEĞİŞTİRİLEMEZLİK

**Madde 8.1:** Bu anayasa, projenin tek ve nihai kanun metnidir. Tüm eski anayasalar ve talimatlar geçersizdir.

**Madde 8.2:** Anayasanın değiştirilmesi, kendi içinde tanımlanan "Anayasa Değişiklik Protokolü"ne tabidir ve İnsan Operatör'ün nihai onayını gerektirir.
