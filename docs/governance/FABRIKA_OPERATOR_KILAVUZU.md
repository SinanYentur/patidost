# PROJE CHIMERA - FABRİKA OPERATÖR KILAVUZU (v1.0)

## GİRİŞ

Bu belge, "PROJE CHIMERA" fabrikasının temel operasyonel komutlarını ve süreçlerini, birincil operatör (veya gelecekteki herhangi bir halef) için basit ve anlaşılır bir dilde açıklar.

## 1. YENİ BİR PROJE (UYGULAMA) NASIL DOĞURULUR?

Fabrika, yeni projelerin anayasal olarak doğru bir şekilde doğmasını garanti eder. Manuel klasör oluşturmak **YASAKTIR**.

**Komut:**

```bash
# Projenin kök dizinindeyken çalıştırın
npx nx g @nx/android:app <uygulama-adi> --directory=apps/<uygulama-adi>
```

**Örnek:**

```bash
npx nx g @nx/android:app pettaksi --directory=apps/pettaksi
```

Bu komut, yeni uygulama için gerekli tüm klasörleri, `build.gradle.kts` dosyalarını ve temel testleri otomatik olarak oluşturacaktır.

## 2. YENİ BİR KÜTÜPHANE (LIBS) NASIL OLUŞTURULUR?

Paylaşılan kodlar (`core`, `shared-ui` vb.), `libs/` altında yaşar.

**Komut:**

```bash
npx nx g @nx/android:library <kutuphane-adi> --directory=libs/<kutuphane-adi>
```

## 3. BİR PROJEYİ NASIL DENETLERİM (LINT)?

Sadece değiştirdiğiniz veya değişiklikten etkilenen projeleri denetlemek için:

```bash
npx nx affected -t lint
```

Tüm imparatorluğu denetlemek için:

```bash
npx nx run-many -t lint
```

## 4. CI/CD NEDEN BAŞARISIZ OLDU? (TEMEL KONTROL LİSTESİ)

1.  **Lint Hatası mı?** -> `npx nx affected -t lint` komutunu yerelde çalıştırıp hataları görün.
2.  **Test Hatası mı?** -> `npx nx affected -t test` komutunu yerelde çalıştırıp başarısız testleri analiz edin.
3.  **Güvenlik Hatası mı?** -> `Trivy` raporunu kontrol edin. Yasaklı bir kütüphane mi eklediniz?
4.  **Sır Sızıntısı mı?** -> `Husky pre-commit` raporunu inceleyin. Koda yanlışlıkla bir `API_KEY` mi yapıştırdınız?
