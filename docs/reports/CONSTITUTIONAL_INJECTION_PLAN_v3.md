# ANAYASAL ENJEKSİYON PLANI (v3.0 - İLK TEMAS)

**ANAYASAL KİMLİK BLOĞU**
---
- **FAZ:** FAZ-3: Fonksiyonel Doğum
- **AMAÇ:** Feature katmanındaki "Sıfır Meşruiyet" krizini sona erdirmek ve ilk kullanıcı akışını anayasal güvenceye almak.
- **DAYANAK:** `reports/ORPHANED_FILES.log` (46 Yetim Dosya Tespiti)

---

## HEDEF BÖLGE: SİSTEMİN DAMARLARI (NAVİGASYON)

### 1. Hedef: `app/src/main/java/com/patidost/app/navigation/AppNavGraph.kt`

*   **Gerekçe:** Uygulamanın tüm ekran rotalarını ve geçiş mantığını tanımlayan ana haritadır. Buradaki bir hata, kullanıcının sistem içinde kaybolmasına neden olur.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ1-001] Navigasyon grafiği, modüller arası bir sözleşmedir ve sistemin bütünlüğünü tanımlar.
    ```

## HEDEF BÖLGE: KİMLİK DOĞRULAMA AKIŞI (FEATURE/AUTH)

### 2. Hedef: `feature/auth/src/main/java/com/patidost/feature/auth/AuthViewModel.kt`

*   **Gerekçe:** Kullanıcı giriş/kayıt işlemlerinin tüm iş mantığını ve durum yönetimini üstlenir. Sistemin en hassas operasyonlarından biridir.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [CORE-001] Bu ViewModel, kimlik doğrulama gibi kritik bir iş mantığını yönettiği için Mutlak Şüphe ilkesine tabidir.
    ```

### 3. Hedef: `feature/auth/src/main/java/com/patidost/feature/auth/LoginScreen.kt`

*   **Gerekçe:** Kullanıcının sistemle ilk temas kurduğu ve kimliğini beyan ettiği arayüzdür. Güvenli ve anayasal olarak tutarlı olmalıdır.
*   **Enjekte Edilecek Mühür:**
    ```kotlin
    // @pin: [FAZ0-001] Giriş ekranı, projenin temel problemini (güvenli erişim) çözen ana yüzeylerden biridir.
    ```

---
**SONRAKİ ADIM:** Bu planın onaylanmasının ardından, belirtilen mühürlerin ilgili dosyalara fiziksel olarak enjekte edilmesi ve ardından MAP-001 motorunun yeniden çalıştırılarak anayasal kapsama oranının yükseldiğinin kanıtlanması.
