#!/bin/bash
# ANAYASAL SCRIPT: anayasa_day_cycle.sh
# Görevi: Günlük operasyonel döngüyü (başlangıç, kapanış) yönetir.

MODE=$1

if [ "$MODE" == "--start" ]; then
    echo "[ANAYASA] Günlük operasyon başlatılıyor..."
    # Proje loguna gün başlangıcını kaydet
    echo -e "\n### GÜNLÜK LOG: $(date) ###\n" >> docs/PROJECT_LOG.md
    echo "[ANAYASA] Günlük log açıldı."
    # AI Planlayıcı'ya görev üretimi için sinyal gönder (simülasyon)
    echo "[ANAYASA] AI Planlayıcı'ya günün hedeflerini belirlemesi için sinyal gönderildi."
    exit 0
elif [ "$MODE" == "--end" ]; then
    echo "[ANAYASA] Günlük operasyon kapatılıyor..."
    # AI Planlayıcı'dan gün sonu özetini al (simülasyon)
    echo "[ANAYASA] AI Planlayıcı'dan gün sonu özeti talep edildi."
    # İnsan operatöre son kontrol için hatırlatma yap
    echo "[DİKKAT] İnsan Operatör: Lütfen günün son durumunu ve teknik borçları PROJECT_LOG.md dosyasına ekleyin."
    exit 0
else
    echo "[HATA] Geçersiz mod. Kullanım: ./scripts/anayasa_day_cycle.sh [--start|--end]" >&2
    exit 1
fi
