#!/bin/bash
# ANAYASAL SCRIPT: anayasa_build_check.sh (v5.0)
# Görevi: Otomatik olarak build alır, APK üretir ve denetim yapar.

set -e # Herhangi bir komut başarısız olursa script'i durdur.

MODE=${1:-"--mode debug"}

run_task() {
    TASK_NAME=$1
    echo "[ANAYASA] Görev başlatılıyor: $TASK_NAME..."
    ./gradlew $TASK_NAME
    if [ $? -ne 0 ]; then
        echo "[HATA] Görev başarısız: $TASK_NAME. Lütfen logları kontrol edin." >&2
        # AI Kodlayıcı'ya hata analizi için sinyal gönder (simülasyon)
        echo "[ANAYASA] AI Kodlayıcı'ya build hatasını analiz etmesi için sinyal gönderildi."
        exit 1
    fi
    echo "[ANAYASA] Görev başarıyla tamamlandı: $TASK_NAME"
}

if [ "$MODE" == "--mode production" ]; then
    echo "[ANAYASA] Production build başlatılıyor..."
    run_task "assembleRelease"

elif [ "$MODE" == "--mode full_check" ]; then
    echo "[ANAYASA] Tam denetim build'i başlatılıyor..."
    run_task "lintDebug"
    run_task "testDebugUnitTest"
    run_task "assembleDebug"

else
    echo "[ANAYASA] Debug build başlatılıyor..."
    run_task "assembleDebug"
fi

# APK yolunu bul ve raporla
APK_PATH=$(find app/build/outputs/apk -name "*.apk" | head -n 1)
if [ -z "$APK_PATH" ]; then
    echo "[HATA] Üretilen paket dosyası bulunamadı." >&2
    exit 1
fi

echo "[ANAYASA] Build başarılı. Üretilen paket: $APK_PATH"
echo "[DİKKAT] İnsan Operatör: Lütfen bu paketi fiziksel bir cihazda test edin."
exit 0
