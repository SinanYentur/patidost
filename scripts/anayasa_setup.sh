#!/bin/bash
# ANAYASAL SCRIPT: anayasa_setup.sh
# Görevi: Belirtilen faza göre geliştirme ortamını kurar ve gerekli kontrolleri yapar.

PHASE=$1

echo "[ANAYASA] Kurulum script'i başlatıldı. Hedef Faz: $PHASE"

if [ -z "$PHASE" ]; then
    echo "[HATA] Faz belirtilmedi. Kullanım: ./scripts/anayasa_setup.sh --phase [faz_numarası]" >&2
    exit 1
fi

# Gerekli anayasal dosyaların varlığını kontrol et
FILES_TO_CHECK=("docs/PROJECT_BRIEF.md" "docs/ARCHITECTURE_DECISIONS_LOG.md" "docs/BACKLOG.md")
for FILE in "${FILES_TO_CHECK[@]}"; do
    if [ ! -f "$FILE" ]; then
        echo "[HATA] Anayasal dosya bulunamadı: $FILE. Kurulum devam edemez." >&2
        exit 1
    fi
done

# Faz-spesifik kurulum adımları (gelecekte eklenecek)
echo "[ANAYASA] Faz $PHASE için özel kurulum adımları uygulanıyor..."


echo "[ANAYASA] Kurulum tamamlandı. Sistem, Faz $PHASE için hazır."
exit 0
