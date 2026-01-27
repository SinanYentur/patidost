# İNSAN GİRDİSİ ve FORM DAYANIKLILIK STANDARDI

**Madde 1 (Veri Kaybı Yasağı):** Ekran döndüğünde, klavye kapandığında veya uygulama arka plana atıldığında, form alanlarındaki veriler kaybolamaz. `rememberSaveable` veya `ViewModel` state restorasyonu zorunludur.

**Madde 2 (Rage-Tap Koruması):** Tüm birincil aksiyon butonları (Giriş Yap, Kaydet vb.) çift tıklamayı engelleyen `debounce` mekanizmasına sahip olmalıdır.
