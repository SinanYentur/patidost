#!/usr/bin/env bash
# MAP-001: Anayasal Haritalama Motoru v3.1 (Sertleştirilmiş)

set -e

# --- Konfigürasyon ve Güvenlik ---
REPO_ROOT=$(git rev-parse --show-toplevel)
REPORTS_DIR="$REPO_ROOT/reports"
CONSTITUTION_DIR="$REPO_ROOT/.constitution"
INDEX_FILE="$CONSTITUTION_DIR/.index"
REPORT_FILE="$REPORTS_DIR/CONSTITUTIONAL_COVERAGE.md"

mkdir -p "$REPORTS_DIR" "$CONSTITUTION_DIR"

# --- Motor Fonksiyonları ---

echo "[1/4] Anayasal harita taranıyor..."
# HATA YAKALAMA: `grep` hiçbir şey bulamazsa script'in ölmesini engellemek için `|| true` eklenmiştir.
grep -rPh "\[(CORE|FAZ|P|SP|PIN)-[A-Z0-9-]+\]" "$REPO_ROOT" --exclude-dir={".git",".idea",".gradle"} > "$INDEX_FILE" || true

echo "[2/4] Rapor dosyası hazırlanıyor..."
echo "# ANAYASAL KAPSAMA RAPORU (MAP-001)" > "$REPORT_FILE"
echo "*Oluşturma Tarihi: $(date)*" >> "$REPORT_FILE"

echo "[3/4] İstatistikler hesaplanıyor..."
FOUND_COUNT=$(wc -l < "$INDEX_FILE" | tr -d ' ')

{
    echo "";
    echo "## 📊 Özet Metrikler";
    echo "- **Tespit Edilen Toplam Anayasal Referans Sayısı:** **$FOUND_COUNT**";
    echo "";
    echo "--- ";
    echo "";
    echo "## 🗺️ Anayasal Referans Haritası";
    echo "*Projede bulunan tüm anayasal etiketler ve bulundukları yerler:*" ;
    echo "\`\`\`";
    cat "$INDEX_FILE";
    echo "\`\`\`";
} >> "$REPORT_FILE"


echo "[4/4] Rapor mühürleniyor..."
if [ "$FOUND_COUNT" -eq 0 ]; then
    echo "" >> "$REPORT_FILE"
    echo "⚠️ **KRİTİK UYARI: Projede henüz HİÇBİR anayasal PIN bulunamadı! Sistem 'Sıfır Meşruiyet' durumundadır.**" >> "$REPORT_FILE"
fi

echo "✅ Rapor başarıyla oluşturuldu: $REPORT_FILE"
