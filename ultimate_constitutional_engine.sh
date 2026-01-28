#!/usr/bin/env bash
# PROJE GENESIS v5: NİHAİ ATOMİK YARATICI (ULTIMATE CONSTITUTIONAL ENGINE)

# --- BÖLÜM 1: GÜVENLİK VE ATOMİKLİK (TRAP & LOCK) ---
set -eE
trap 'cleanup_and_rollback' ERR INT TERM

REPO_ROOT=$(git rev-parse --show-toplevel)
TX_LOCK_FILE="$REPO_ROOT/.tx_lock"
STAGING_DIR="$REPO_ROOT/.constitution_staging"

cleanup_and_rollback() {
    echo "🔴 KRİTİK HATA: Atomik yaratılış başarısız. Tüm izler temizleniyor..."
    rm -rf "$STAGING_DIR"
    rm -f "$TX_LOCK_FILE"
    exit 1
}

begin_transaction() {
    if [ -f "$TX_LOCK_FILE" ]; then echo "HATA: İşlem kilitli."; exit 1; fi
    touch "$TX_LOCK_FILE"
    mkdir -p "$STAGING_DIR/sub_protocols"
}

# --- BÖLÜM 2: ANAYASAL DNA (TÜM METİNLER GÖMÜLÜ) ---

write_core_constitution() {
cat << 'EOM' > "$STAGING_DIR/CORE_CONSTITUTION.md"
# CORE_CONSTITUTION (v3.0)
KATMAN: GLOBAL
STATÜ: MUTLAK ÜST NORM
ANAYASAL KAYIT ID: CORE-001

## Madde 1: Varoluşsal İlkeler
1.1 Mutlak Şüphe
1.2 Tek Seferde Analiz
1.3 Atomik Yaratılış
EOM
}

write_pin_table() {
cat << 'EOM' > "$STAGING_DIR/ANAYASAL_PIN_TABLE.md"
| PIN | TANIM | STATÜ |
|:---|:---|:---|
| CORE-001 | Çekirdek Anayasa | AKTİF |
| ML-001 | Bağ Kilidi | AKTİF |
| ML-002 | Doğrulama Kilidi | AKTİF |
EOM
}

# ... (Diğer tüm anayasa dosyalarını yazacak fonksiyonlar burada) ...

# --- BÖLÜM 3: MEKANİK KİLİT MOTORLARI (DAHİLİ) ---

generate_index_internal() {
    grep -h -r -o -E '\[(CORE|FAZ|P|SP|PIN)-[A-Z0-9-]+\]' "$STAGING_DIR" --include="*.md" | sort -u > "$STAGING_DIR/.index"
}

verify_reference_internal() {
    grep -q -x "\[$1\]" "$STAGING_DIR/.index"
}

# --- BÖLÜM 4: ANA YÜRÜTME MOTORU ---

main() {
    begin_transaction
    echo "[1/3] Anayasal DNA, staging alanına yazılıyor..."
    write_core_constitution
    write_pin_table
    # ... (Diğer tüm yazma fonksiyonları çağrılır)

    echo "[2/3] Anayasal bütünlük, staging alanında test ediliyor..."
    generate_index_internal
    if ! verify_reference_internal "CORE-001"; then
        echo "FATAL: Dahili doğrulama motoru, kendi yazdığı CORE-001'i bulamadı!"
        exit 1 # Bu, trap tarafından yakalanacak
    fi
    echo "✅ Dahili bütünlük doğrulandı."

    echo "[3/3] Atomik geçiş yapılıyor..."
    [ -d "$REPO_ROOT/.constitution" ] && mv "$REPO_ROOT/.constitution" "$REPO_ROOT/.constitution_archive_$(date +%s)"
    mv "$STAGING_DIR" "$REPO_ROOT/.constitution"

    # Son ve en önemli adım: Yeni Hook'u kur
    # ... (git config core.hooksPath veya cp komutu buraya gelecek)

    rm -f "$TX_LOCK_FILE"
    trap - ERR INT TERM # Başarılı bitişte trap'i kaldır
    echo "🏁🏁🏁 ANAYASAL EVREN BAŞARIYLA YARATILDI! 🏁🏁🏁"
}

main
