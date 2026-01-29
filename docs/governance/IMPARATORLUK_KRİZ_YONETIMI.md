# PROJE CHIMERA - İMPARATORLUK KRİZ YÖNETİMİ (v1.0)

## GİRİŞ

Bu belge, "PROJE CHIMERA" fabrikasının en yaygın hata senaryolarını ve bu kriz anlarında operatörün izlemesi gereken anayasal protokolleri tanımlar. Amaç, panik anında bile doğru ve ölçülü adımlar atılmasını sağlamaktır.

## SENARYO 1: CI/CD Sürekli Kırmızı (Başarısız)

**Teşhis:** GitHub Actions sekmesindeki iş akışları (workflows) sürekli olarak başarısız oluyor.

**Eylem Protokolü:**

1.  **Suçlu Komutu Yerelde Çalıştır:** CI log'larında başarısız olan adımı (`npx nx affected -t lint` gibi) kendi makinenizde, `devbox shell` içinde çalıştırın. Hatanın aynısını almanız gerekir.
2.  **"Affected" Komutunu Atla (Geçici):** Sorunun `affected` (sadece değişenleri tara) komutunda mı yoksa genel bir problemde mi olduğunu anlamak için, tüm projeleri hedef alan komutu çalıştırın: `npx nx run-many -t lint`.
3.  **Önbelleği Temizle (Nükleer Seçenek):** Eğer sorun hala devam ediyorsa, Nx'in önbelleği bozulmuş olabilir. Hafızayı sıfırlayın: `npx nx reset`. Bu işlemden sonra komutları tekrar çalıştırın.

## SENARYO 2: "Hayalet Dosya" Geri Döndü (`git add .` Çöküyor)

**Teşhis:** `git add .` komutu `error: open("...")` gibi bir hata ile çöküyor.

**Eylem Protokolü:**

1.  **Adli Tespit:** "Hayalet" dosyanın tam adını ve `inode` numarasını bulun.
    ```bash
    ls -li
    ```
2.  **Inode Üzerinden İmha:** Dosyayı, ismini kullanarak değil, doğrudan `inode` numarasını hedef alarak silin.
    ```bash
    # 1234567 yerine doğru inode numarasını yazın
    find . -inum 1234567 -exec rm -i {} \;
    ```
3.  **Git Hafızasını Sıfırla:** Eğer sorun devam ederse, Git'in hafızasını (`index`) imha edip yeniden kurun.
    ```bash
    rm .git/index
    git reset
    ```

## SENARYO 3: Geliştirme Ortamı (`devbox`) Başlamıyor

**Teşhis:** `devbox shell` komutu hata veriyor veya ortam düzgün kurulmuyor.

**Eylem Protokolü:**

1.  **Paketleri Güncelle:** Devbox'ın paket listesini güncelleyin.
    ```bash
    devbox update
    ```
2.  **Zorla Yeniden Kurulum:** Devbox'ın indirdiği tüm araçları silip baştan kurmasını sağlayın.
    ```bash
    rm -rf .devbox
    devbox shell
    ```
3.  **Nix Paket Deposunu Kontrol Et:** Sorun devam ederse, Nix paket deposunun (`status.nixos.org`) ayakta olup olmadığını kontrol edin. Eğer genel bir sorun varsa, beklemek tek çözümdür.
