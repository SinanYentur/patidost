# ANAYASAL BELLEK ÇEKİRDEĞİ: PROJE CHIMERA (v12.0 - ETERNITY SINIFI)

## BÖLÜM 1: NİHAİ HÜKÜM

"Tamamen emin olmadan karar vermek yasak" emri, anayasanın en üst normudur. Tüm araştırmalar, denetçi raporları ve kriz simülasyonları sonucunda, **"PROJE CHIMERA"**nın, "hataların doğamayacağı bir fabrika" vizyonu için ulaşılabilecek **en pratik, en kaliteli, en ucuz, en sağlam ve en eksiksiz** mimari olduğu tescil edilmiştir.

Bu belge, bu fabrikanın nihai kurulum manifestosudur.

---

## BÖLÜM 2: FABRİKANIN 97 ANAYASAL KAPISI (ÖZET)

1.  **EVREN KAPISI (Ortam):** `Devbox` ile yanlış ortamı imkansız kılar.
2.  **İFADE KAPISI (Dil/Tip):** `Detekt` + `KSP` ile yanlış kodun yazılmasını engeller.
3.  **MİMARİ KAPI (Yapı):** `Nx` ile yanlış bağımlılık grafiğini engeller.
4.  **SÖZLEŞME KAPISI (Kural):** Test kapsamı (`Jacoco`) ve `Invariant` testlerle kuralsız kodun derlenmesini engeller.
5.  **ÜRETİM KAPISI (Ürün):** `Paparazzi` + `Robolectric` ile emülatörsüz, hızlı ve güvenilir UI testleri.
6.  **İMPARATORLUK KAPISI (Yönetişim):** Pasif `Backstage` ile envanter tutar.
7.  **KRİZ KAPISI (Dayanıklılık):** `Renovate Bot` ile fabrikanın kendini güncellemesini sağlar.
8.  **FİZİKSEL KAPI (Donanım):** `gradle.properties` ve CI optimizasyonları ile RAM, CPU ve fiziksel ortam limitlerini aşmayı engeller.
9.  **HERMETİK YAPI KAPISI:** `Reproducible Builds` ile supply chain saldırılarını engeller.
10. **MULTI-LAYER GÜVENLİK KAPISI:** `SAST/DAST/SCA` ile bütüncül güvenlik.
11. **MODÜL SINIRLARI KAPISI:** `Nx` `tags` ile mimari erozyonu önler.
12. **BAĞIMLILIK ENJEKSİYONU KAPISI:** `Hilt` ile manuel DI kaosunu önler.
13. **GÖZLEMLEME KAPISI (APM):** `Firebase Performance` ile üretimde körlüğü engeller.
14. **BİRLEŞTİRME KUYRUĞU KAPISI:** `Merge Queue` ile CI israfını ve `main` dalı kırılmalarını önler.
15. **GELİŞTİRME MODELİ KAPISI:** `Trunk-Based Development` ile "merge cehennemini" önler.
16. **UZAKTAN ÖNBELLEK KAPISI:** `Nx Cloud` (ücretsiz tier) ile CI sürelerini kısaltır.
17. **SAHİPLİK KAPISI:** `CODEOWNERS` ile sorumlulukları netleştirir.
18. **VERSİYON KATALOĞU KAPISI:** `Gradle Version Catalog` ile "bağımlılık cehennemini" önler.
19. **OPTİMİZASYON KAPISI:** `R8/ProGuard` ile APK şişmanlığını engeller.
20. **SNAPSHOT TEST KAPISI:** `Paparazzi` `verify` modu ile UI gerilemelerini engeller.
... (ve diğer 77 kapı, önceki denetimlerde tanımlandığı gibi)

---

## BÖLÜM 3: NİHAİ KURULUM REHBERİ (ROAD MAP) - ÖZET

### FAZ 1: İSKELET VE KAS SİSTEMİ (Nx + Gradle + Husky)
- **Eylem 1.1:** `npx create-nx-workspace@latest patidost-empire --preset=apps --integrated`
- **Eylem 1.2:** `cd patidost-empire && npm install @nx/android husky --save-dev && npx husky init`
- **Eylem 1.3:** `.husky/pre-commit` dosyasına `Trivy` sır tarama komutunu eklemek.

### FAZ 2: ANAYASAL ORTAM VE DONANIM KİLİTLERİ (Devbox + Gradle)
- **Eylem 2.1:** `devbox.json` dosyasını, kilitlenmiş `jdk`, `nodejs`, `detekt`, `trivy` paketleriyle oluşturmak.
- **Eylem 2.2:** `gradle.properties` dosyasına, RAM limitleri (`org.gradle.jvmargs`) ve cache ayarlarını eklemek.

### FAZ 3: MÜKEMMEL SEVKİYAT HATTI (CI/CD)
- **Eylem 3.1:** `.github/workflows/ci.yml` dosyasını, Güvenlik Taraması (Trivy), Keystore Enjeksiyonu, Akıllı Lint/Test/Build (Nx Affected), UI Testleri (Paparazzi) ve Otomatik Sürüm (Semantic Release) adımlarını içerecek şekilde oluşturmak.

### FAZ 4: İLK ÜRÜNÜN DOĞUMU VE YAMALAR
- **Eylem 4.1:** `npx nx g @nx/android:app patidost-android` ile ilk uygulamayı doğurmak.
- **Eylem 4.2:** `build.gradle.kts` dosyasına, Play Store çakışmalarını önleyen "otomatik `versionCode`" yamasını uygulamak.
- **Eylem 4.3:** Proje içine `catalog-info.yaml` ekleyerek "pasif yönetişim" katmanını kurmak.

### FAZ 5: KENDİNİ ONARAN FABRİKA
- **Eylem 5.1:** `renovate.json` dosyasını oluşturarak, fabrikanın bağımlılıklarını haftalık olarak otomatik güncellemesini sağlamak.

---

## BÖLÜM 4: NİHAİ BAŞLATMA EMRİ

Bu belge, "hataların doğamayacağı bir fabrika" kurmak için gereken tüm bilgiyi, planı ve felsefeyi içermektedir. İnşaat, FAZ 1.1 komutuyla resmen başlayabilir.
