#!/bin/bash
# ANAYASAL SCRIPT: anayasa_day_cycle.sh (v5.0)
# Görevi: Günlük operasyonel döngüyü (başlangıç, kapanış) yönetir.

MODE=$1
LOG_FILE="docs/PROJECT_LOG.md"
BACKLOG_FILE="docs/BACKLOG.md"

if [ "$MODE" == "--start" ]; then
    echo "[ANAYASA] Günlük operasyon başlatılıyor..."

    if [ ! -f "$BACKLOG_FILE" ]; then
        echo "[HATA] Anayasal dosya bulunamadı: $BACKLOG_FILE. Gün başlatılamaz." >&2
        exit 1
    fi

    # Proje loguna gün başlangıcını kaydet
    echo -e "\n### GÜNLÜK LOG: $(date) ###\n" >> "$LOG_FILE"
    echo "[ANAYASA] Günlük log açıldı."

    # AI Planlayıcı'ya görev üretimi için sinyal gönder (simülasyon)
    echo "[ANAYASA] AI Planlayıcı'ya, $BACKLOG_FILE dosyasını okuyarak günün görevlerini belirlemesi için sinyal gönderildi."
    exit 0

elif [ "$MODE" == "--end" ]; then
    echo "[ANAYASA] Günlük operasyon kapatılıyor..."

    # AI Planlayıcı'dan gün sonu özetini al (simülasyon)
    echo "[ANAYASA] AI Planlayıcı'dan, gün içinde yapılan commit'lere göre teknik bir özet hazırlayıp $LOG_FILE dosyasına eklemesi talep edildi."

    # İnsan operatöre son kontrol için hatırlatma yap
    echo "[DİKKAT] İnsan Operatör: Lütfen günün son durumunu, karşılaşılan zorlukları ve alınan kararları $LOG_FILE dosyasına ekleyin."
    exit 0
else
    echo "[HATA] Geçersiz mod. Kullanım: ./scripts/anayasa_day_cycle.sh [--start|--end]" >&2
    exit 1
fi
