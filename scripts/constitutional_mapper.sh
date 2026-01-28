#!/usr/bin/env bash
# MAP-001: Anayasal Haritalama Motoru v5.1 (Nihai Budama)

set -euo pipefail

# --- Konfigürasyon ---
REPO_ROOT=$(git rev-parse --show-toplevel)
REPORTS_DIR="$REPO_ROOT/reports"
REPORT_FILE="$REPORTS_DIR/CONSTITUTIONAL_COVERAGE.md"
ORPHANED_FILE_LOG="$REPORTS_DIR/ORPHANED_FILES.log"

mkdir -p "$REPORTS_DIR"

# --- Motor Fonksiyonları ---

echo "[1/2] Kod tabanındaki anayasal referanslar taranıyor (Hijyenik Mod)..."
GREP_PATTERN="@pin:"
EXCLUDE_DIRS='--exclude-dir={.git,.idea,.gradle,.constitution_backup*,reports,build}'
FOUND_REFS_WITH_PATHS=$(grep -r -E -o "$GREP_PATTERN \\[([A-Z0-9-]+)\\]" app/src core feature $EXCLUDE_DIRS || true)

echo "[2/2] İstatistikler ve Yetim Dosya Analizi yapılıyor..."

FOUND_COUNT=$(echo -n "$FOUND_REFS_WITH_PATHS" | wc -l | tr -d ' ')

# Yetim Dosyaları Bul (Sadece beyaz listedeki .kt ve .xml dosyalarını hedef al)
# ONARIM v3: -prune ile build klasörlerini tamamen yok say.
find app core feature -path "*/build" -prune -o -type f \( -name "*.kt" -o -name "*.xml" \) -print0 | xargs -0 grep -L "$GREP_PATTERN" > "$ORPHANED_FILE_LOG" || true
TOTAL_ORPHANS=$(wc -l < "$ORPHANED_FILE_LOG" | tr -d ' ')

{
    echo "# ANAYASAL KAPSAMA RAPORU (MAP-001)";
    echo "*Oluşturma Tarihi: $(date)*";
    echo "";
    echo "## 📊 Özet Metrikler";
    echo "- **Tespit Edilen Toplam Anayasal Referans Sayısı (Kodda):** **$FOUND_COUNT**";
    echo "- **Tespit Edilen Yetim Dosya Sayısı (app, core, feature):** **$TOTAL_ORPHANS**";
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
