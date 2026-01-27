#!/bin/bash
# ANAYASAL SCRIPT: anayasa_build_check.sh
# Görevi: Otomatik olarak build alır, APK üretir ve temel kontrolleri yapar.

MODE=${1:-"--mode debug"}

if [ "$MODE" == "--mode production" ]; then
    echo "[ANAYASA] Production build başlatılıyor..."
    TASK="assembleRelease"
else
    echo "[ANAYASA] Debug build başlatılıyor..."
    TASK="assembleDebug"
fi

# Build işlemini başlat
./gradlew $TASK

if [ $? -ne 0 ]; then
    echo "[HATA] Build başarısız. Lütfen logları kontrol edin." >&2
    # AI Kodlayıcı'ya hata analizi için sinyal gönder (simülasyon)
    echo "[ANAYASA] AI Kodlayıcı'ya build hatasını analiz etmesi için sinyal gönderildi."
    exit 1
fi

# APK yolunu bul ve raporla
APK_PATH=$(find app/build/outputs/apk -name "*.apk" | head -n 1)
if [ -z "$APK_PATH" ]; then
    echo "[HATA] Üretilen APK dosyası bulunamadı." >&2
    exit 1
fi

echo "[ANAYASA] Build başarılı. Üretilen paket: $APK_PATH"
echo "[DİKKAT] İnsan Operatör: Lütfen bu paketi fiziksel bir cihazda test edin."
exit 0
