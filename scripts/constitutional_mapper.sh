#!/usr/bin/env bash
# MAP-001: Anayasal Haritalama Motoru v7.1 (Feature Katmanı Taraması)

set -euo pipefail

# --- Konfigürasyon ---
REPO_ROOT=$(git rev-parse --show-toplevel)
REPORTS_DIR="$REPO_ROOT/reports"
REPORT_FILE="$REPORTS_DIR/CONSTITUTIONAL_COVERAGE.md"
ORPHANED_FILE_LOG="$REPORTS_DIR/ORPHANED_FILES.log"

mkdir -p "$REPORTS_DIR"

# BEYAZ LİSTE (GENİŞLETİLMİŞ): Artık feature katmanları da anayasal denetime tabidir.
TARGET_DIRS=("app/src" "core" "feature")

# --- Motor Fonksiyonları ---

echo "[1/2] Stratejik ve Fonksiyonel katmanlar taranıyor..."
GREP_PATTERN="@pin:"
# ONARIM v4: find komutunu doğrudan TARGET_DIRS ile kullanmak, Windows yollarında daha stabil çalışır.
FOUND_REFS_WITH_PATHS=$(find "${TARGET_DIRS[@]}" -type f -print0 | xargs -0 grep -H -E -o "$GREP_PATTERN \\[([A-Z0-9-]+)\\]" || true)


echo "[2/2] İstatistikler ve Yetim Dosya Analizi yapılıyor..."

FOUND_COUNT=$(echo -n "$FOUND_REFS_WITH_PATHS" | wc -l | tr -d ' ')

# Yetim Dosyaları Bul (Aynı genişletilmiş kapsamda)
> "$ORPHANED_FILE_LOG"
find "${TARGET_DIRS[@]}" -path "*/build" -prune -o -type f \( -name "*.kt" -o -name "*.xml" \) -print0 | xargs -0 grep -L "$GREP_PATTERN" > "$ORPHANED_FILE_LOG" || true
TOTAL_ORPHANS=$(wc -l < "$ORPHANED_FILE_LOG" | tr -d ' ')

{
    echo "# ANAYASAL KAPSAMA RAPORU (MAP-001) - FAZ-3 BAŞLANGIÇ";
    echo "*Oluşturma Tarihi: $(date)*";
    echo "";
    echo "## 📊 Genel Metrikler (app, core, feature)";
    echo "- **Tespit Edilen Toplam Anayasal Referans Sayısı (Kodda):** **$FOUND_COUNT**";
    echo "- **Tespit Edilen Yetim Dosya Sayısı:** **$TOTAL_ORPHANS**";
    echo "";
    echo "--- ";
    echo "";
    echo "## 🗺️ Anayasal Referans Haritası";
    echo "*Projede bulunan tüm anayasal etiketler ve bulundukları yerler:*" ;
    echo "\`\`\`";
    echo "$FOUND_REFS_WITH_PATHS";
    echo "\`\`\`";
} > "$REPORT_FILE"

echo "✅ Rapor başarıyla oluşturuldu: $REPORT_FILE"

# Raporun içeriğini de göster
cat "$REPORT_FILE"
