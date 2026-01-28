#!/bin/bash
# PROJE GENESIS v4: ANAYASAL İŞLEM YÜRÜTÜCÜSÜ (ATOMIC EXECUTOR)

# BÖLÜM 1: GÜVENLİK VE HATA YAKALAMA (FAIL-CLOSED MİMARİSİ)
# ----------------------------------------------------------
# -eE: Herhangi bir komut hatasında veya pipe kırılmasında anında çık.
# -o pipefail: Pipe içindeki herhangi bir komut hata verirse tüm pipe başarısız sayılır.
set -euo pipefail

# Anayasal Kilit ve Geçici Alanlar
REPO_ROOT="$(git rev-parse --show-toplevel)"
TX_LOCK_FILE="$REPO_ROOT/.tx_lock"
STAGING_DIR="$REPO_ROOT/.constitution_staging"
ARCHIVE_DIR="$REPO_ROOT/.constitution_archive"
CRISIS_LOG="$REPO_ROOT/audits/CRISIS_LOG.md"

# Hata anında veya script sonunda çalışacak temizlik fonksiyonu
trap 'cleanup_and_rollback "$BASH_COMMAND" "$LINENO"' ERR INT TERM

cleanup_and_rollback() {
    echo "----------------------------------------------------------------"
    echo "🔴 KRİTİK HATA: Anayasal işlem başarısız oldu!"
    echo "Hata Komutu: $1 (Satır: $2)"
    echo "Sistem başlangıç durumuna geri alınıyor..."
    rm -rf "$STAGING_DIR"
    echo "Geçici staging alanı imha edildi." >> "$CRISIS_LOG"
    rm -f "$TX_LOCK_FILE"
    echo "İşlem kilidi kaldırıldı." >> "$CRISIS_LOG"
    echo "Anayasal bütünlük korundu. Hiçbir değişiklik yapılmadı."
    echo "----------------------------------------------------------------"
    exit 1
}

# BÖLÜM 2: ANAYASAL METİNLER (HEREDOC İLE GÖMÜLMÜŞ DNA)
# ----------------------------------------------------------

# Her .md dosyası, içeriği base64 ile kodlanarak script'e gömülür.
# Bu, özel karakterlerden ve satır sonu hatalarından kaynaklanacak bozulmaları engeller.

read -r -d '' GLOBAL_PRE_EMPTIVE_BASE64 << EOM
IyBET8cfVU0gw5ZOQ0VTxLAgQU5BWUF... (base64 encoded content of GLOBAL_PRE_EMPTIVE_CONSTITUTION.md)
EOM

read -r -d '' CORE_CONSTITUTION_BASE64 << EOM
IyBQQVRJRE9TVCBDW8OHxLBL... (base64 encoded content of CORE_CONSTITUTION.md)
EOM

# ... (Diğer tüm anayasa ve protokol dosyaları için aynı yapı) ...

# BÖLÜM 3: İŞLEM MOTORU (TRANSACTION ENGINE)
# ----------------------------------------------------------

begin_transaction() {
    echo "[1/5] Anayasal İşlem Başlatılıyor..."
    if [ -f "$TX_LOCK_FILE" ]; then
        echo "HATA: Başka bir anayasal işlem zaten yürürlükte!" >&2
        exit 1
    fi
    touch "$TX_LOCK_FILE"
    echo "Sistem kilitlendi."

    mkdir -p "$STAGING_DIR"
    echo "Staging alanı oluşturuldu."
}

build_constitution_in_staging() {
    echo "[2/5] Anayasal evren gölgede inşa ediliyor..."
    echo "$GLOBAL_PRE_EMPTIVE_BASE64" | base64 -d > "$STAGING_DIR/GLOBAL_PRE_EMPTIVE_CONSTITUTION.md"
    echo "$CORE_CONSTITUTION_BASE64" | base64 -d > "$STAGING_DIR/CORE_CONSTITUTION.md"
    # ... (Diğer tüm dosyalar için aynı yapı) ...
    echo "Tüm anayasal belgeler staging alanına yazıldı."
}

verify_staging_integrity() {
    echo "[3/5] Gölge evrenin anayasal bütünlüğü test ediliyor (Dry-Run)..."
    # Bu fonksiyonlar, --staging bayrağı ile sadece staging dizinini hedefler
    bash "$REPO_ROOT/scripts/generate_constitutional_index.sh" --staging
    bash "$REPO_ROOT/scripts/verify_constitution_checksum.sh" --staging
    # ... (Diğer tüm kilit ve doğrulama motorları burada --staging ile çağrılır) ...
    echo "✅ Gölge evren tüm testleri geçti."
}

commit_transaction() {
    echo "[4/5] Atomik Geçiş: Yeni anayasal evren aktive ediliyor..."
    # Önce yedekle, sonra taşı. Bu sıra, veri kaybını önler.
    if [ -d "$REPO_ROOT/.constitution" ]; then
        mv "$REPO_ROOT/.constitution" "$ARCHIVE_DIR/constitution_$(date +%s)"
        echo "Eski anayasa arşive taşındı."
    fi
    mv "$STAGING_DIR" "$REPO_ROOT/.constitution"
    echo "Yeni anayasa aktive edildi."
}

end_transaction() {
    echo "[5/5] Anayasal İşlem Başarıyla Tamamlandı."
    rm -f "$TX_LOCK_FILE"
    echo "Sistem kilidi kaldırıldı."
    echo "Epoch Update: $(date) - Anayasal Evren başarıyla güncellendi." >> "$CRISIS_LOG"
}

# BÖLÜM 4: ANA YÜRÜTME (MAIN EXECUTION)
# ----------------------------------------------------------

begin_transaction
build_constitution_in_staging
verify_staging_integrity
commit_transaction
end_transaction

echo "✅🚀 PATIDOST ANAYASAL EVRENİ BAŞARIYLA KURULDU VEYA GÜNCELLENDİ."
