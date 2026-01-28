#!/usr/bin/env bash
# MAP-001: Anayasal Haritalama Motoru v7.0 (Lazer Odaklı Tarama)

set -euo pipefail

# --- Konfigürasyon ---
REPO_ROOT=$(git rev-parse --show-toplevel)
REPORTS_DIR="$REPO_ROOT/reports"
REPORT_FILE="$REPORTS_DIR/CONSTITUTIONAL_COVERAGE.md"
ORPHANED_FILE_LOG="$REPORTS_DIR/ORPHANED_FILES.log"

mkdir -p "$REPORTS_DIR"

# BEYAZ LİSTE (LAZER ODAKLI): Sadece anayasal olarak en kritik olan Data ve Domain katmanları.
TARGET_DIRS=("core/data/src" "core/domain/src")

# --- Motor Fonksiyonları ---

echo "[1/2] Stratejik katmanlar (Data/Domain) taranıyor..."
GREP_PATTERN="@pin:"
# Sadece beyaz listedeki dizinleri tara
FOUND_REFS_WITH_PATHS=$(grep -r -H -E -o "$GREP_PATTERN \\[([A-Z0-9-]+)\\]" "${TARGET_DIRS[@]}" || true)

echo "[2/2] Stratejik İstatistikler ve Yetim Dosya Analizi yapılıyor..."

FOUND_COUNT=$(echo -n "$FOUND_REFS_WITH_PATHS" | wc -l | tr -d ' ')

# Yetim Dosyaları Bul (Sadece Data ve Domain'i hedef al)
> "$ORPHANED_FILE_LOG"
find "${TARGET_DIRS[@]}" -type f \( -name "*.kt" \) -print0 | xargs -0 grep -L "$GREP_PATTERN" > "$ORPHANED_FILE_LOG" || true
TOTAL_ORPHANS=$(wc -l < "$ORPHANED_FILE_LOG" | tr -d ' ')

{
    echo "# ANAYASAL KAPSAMA RAPORU (MAP-001) - STRATEJİK ODAK";
    echo "*Oluşturma Tarihi: $(date)*";
    echo "";
    echo "## 📊 Stratejik Metrikler (Data & Domain)";
    echo "- **Tespit Edilen Stratejik Referans Sayısı:** **$FOUND_COUNT**";
    echo "- **Tespit Edilen Stratejik Yetim Dosya Sayısı:** **$TOTAL_ORPHANS**";
    echo "";
    echo "--- ";
    echo "";
    echo "## 🗺️ Stratejik Anayasal Referans Haritası";
    echo "*Data ve Domain katmanlarında bulunan anayasal etiketler:*" ;
    echo "\`\`\`";
    echo "$FOUND_REFS_WITH_PATHS";
    echo "\`\`\`";
} > "$REPORT_FILE"

echo "✅ Rapor başarıyla oluşturuldu: $REPORT_FILE"

# Raporun içeriğini de göster
cat "$REPORT_FILE"
