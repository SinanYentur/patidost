# KRİZ-RESTORASYON v2 FAZ GEÇİŞ TALEP RAPORU

**ANAYASAL KİMLİK BLOĞU**
*Bu rapor, Denetçi-1 ve Denetçi-2'nin onayları uyarınca, FAZ: KRİZ-RESTORASYON'u başlatmak için resmi yetki talebidir.*

---

- **FAZ:** FAZ GEÇİŞ DENETİMİ
- **ROL:** Anayasa Uygulama Ajanı
- **DAYANILAN MADDELER:** OMEGA_CODEX §204.2 (Mod Geçiş Yetkisi), Denetçi-1 Onay Raporu, Denetçi-2 Onay Raporu
- **HUKUKİ TÜR:** Talep / Faz Başlatma Protokolü

---

## 1. FAZ A (HUKUKİ ALTYAPI) KAPANIŞ ÖZETİ

**Durum:** TAMAMLANDI

**Üretilen Kanıtlar:**
*   **Anayasal Şablonlar:** `/audits/templates/` altında `SCREEN_CHARTER_TEMPLATE.md`, `ICRA_ENVANTERI_TEMPLATE.md`, `GORSEL_ESLESME_RAPORU_TEMPLATE.md`.
*   **UI Hukuku:** `/ui_constitution/` altında 5 adet ekran için (`01`'den `05`'e kadar) `Screen_Charter.md` dosyaları.
*   **İcra Kaydı:** `/audits/ICRA_ENVANTERİ.md` (v1.0), oluşturulan hukuki varlıkları kayda almıştır.

**Sonuç:** Projenin bir sonraki onarım adımı için gerekli olan tüm hukuki ve anayasal altyapı kurulmuştur.

## 2. TALEP EDİLEN FAZ: KRİZ-RESTORASYON (v2 – Bağlanırlık ve İskelet)

**Anayasal Amaç:** `İCRA_ENVANTERİ.md`'de "Bilinmiyor" ve "Doğrulanmadı" olarak işaretlenen tüm maddeleri, somut onarım eylemleriyle "Görünüyor" ve "Doğrulandı" statüsüne getirmek ve projeyi anayasal olarak "STABİL" hale getirmektir.

## 3. AÇILMASI İSTENEN İLK YETKİ ve EYLEM

**Yetki:** ONARIM

**İlk Eylem (Denetçi-2 Talebi): Anayasal Derleme Kilidinin Kurulması**

*   **Hedef:** `app/build.gradle.kts` dosyasına `checkConstitutionalCompliance` adında yeni bir Gradle görevi eklenecektir.
*   **İşlev:** Bu görev, her derleme öncesinde (`preBuild`), `/ui_constitution/` klasörünün varlığını ve içeriğini kontrol edecektir. Eğer hukuki `Screen_Charter` dosyaları mevcut değilse, bu görev bir `GradleException` fırlatarak derlemeyi **durduracaktır**.
*   **Anayasal Gerekçe:** Bu, Denetçi-2'nin "Kağıttan Koda Geçiş" ve Denetçi-1'in "İcra Gerçekliği" taleplerini karşılar. Anayasayı, niyetten çıkarıp, derleme sürecinin zorunlu bir parçası haline getirir.

---

**NİHAİ TALEP:** Bu raporun onaylanarak **FAZ: KRİZ-RESTORASYON**'un resmi olarak başlatılması ve yukarıda tanımlanan ilk onarım eylemi için icra yetkisinin verilmesi talep edilmektedir.
