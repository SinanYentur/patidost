#!/bin/bash
# ANKARA-OS GÜN AÇILIŞ RİTÜELİ

LOG_FILE="docs/PROJECT_LOG.md"
DATE=$(date +%Y-%m-%d)
TIME=$(date +%H:%M:%S)

echo "🌞 Gün açılışı başlatılıyor..."

# 1. Log dosyasına başlık at
echo "" >> $LOG_FILE
echo "## $DATE — Gün Açılışı" >> $LOG_FILE
echo "Başlangıç Saati: $TIME" >> $LOG_FILE

# 2. Son commit'i kontrol et
LAST_COMMIT=$(git log -1 --oneline)
echo "- Son Commit: $LAST_COMMIT" >> $LOG_FILE

# 3. Backlog kontrolü
TODO_COUNT=$(grep -c "\[ \]" docs/BACKLOG.md)
echo "- Bekleyen Görev Sayısı: $TODO_COUNT" >> $LOG_FILE

echo "✅ Gün açılışı PROJECT_LOG.md dosyasına işlendi."
