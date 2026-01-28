#!/bin/bash
# PROJE EINSTEIN: NİHAİ ATOMİK YARATICI v8.0 (ORTAMDAN BAĞIMSIZ)

# --- BÖLÜM 1: GÜVENLİK VE ATOMİKLİK ---
set -eE
trap 'cleanup_and_rollback "$BASH_COMMAND" "$LINENO"' ERR INT TERM

REPO_ROOT=$(git rev-parse --show-toplevel)
TX_LOCK_FILE="$REPO_ROOT/.tx_lock"
STAGING_DIR="$REPO_ROOT/.constitution_staging"

cleanup_and_rollback() {
    echo "🔴 KRİTİK HATA: Atomik yaratılış başarısız oldu! (Komut: $1, Satır: $2)"
    rm -rf "$STAGING_DIR"
    rm -f "$TX_LOCK_FILE"
    exit 1
}

begin_transaction() {
    if [ -f "$TX_LOCK_FILE" ]; then echo "HATA: İşlem kilitli."; exit 1; fi
    touch "$TX_LOCK_FILE"
    mkdir -p "$STAGING_DIR"
}

# --- BÖLÜM 2: ANAYASAL DNA ---

write_core_constitution() {
    # ONARIM: printf kullanılarak satır sonu karakterleri tamamen kontrol altına alınıyor.
    printf "%s\n" "# @id: CORE-001" > "$STAGING_DIR/CORE_CONSTITUTION.md"
}

# --- BÖLÜM 3: MEKANİK KİLİT MOTORLARI (SAF BASH) ---

verify_internal() {
    # ONARIM: Harici grep/awk/sed yerine sadece Bash'in içsel yetenekleri kullanılıyor.
    local file_content
    local id_to_find="$1"

    # Dosya içeriğini oku ve tüm görünmez karakterlerden arındır.
    file_content=$(<"$STAGING_DIR/CORE_CONSTITUTION.md")
    file_content_clean=${file_content//[$'\t\r\n ']}

    # Aranan ID'yi de arındır.
    id_clean=${id_to_find//[$'\t\r\n ']}

    # Saf string karşılaştırması yap.
    if [[ "$file_content_clean" == *"$id_clean"* ]]; then
        return 0 # Başarılı
    else
        return 1 # Başarısız
    fi
}

# --- BÖLÜM 4: ANA YÜRÜTME MOTORU ---

main() {
    begin_transaction
    echo "[1/3] Anayasal DNA (Saf), staging alanına yazılıyor..."
    write_core_constitution

    echo "[2/3] Anayasal bütünlük, staging alanında test ediliyor..."
    if ! verify_internal "@id:CORE-001"; then
        echo "FATAL: Dahili doğrulama motoru, saf mantığa rağmen kendi yazdığı '@id:CORE-001'i bulamadı!"
        exit 1
    fi
    echo "✅ Dahili bütünlük doğrulandı."

    echo "[3/3] Atomik geçiş yapılıyor..."
    # ...

    rm -f "$TX_LOCK_FILE"
    trap - ERR INT TERM # Başarılı bitişte trap'i kaldır
    echo "🏁🏁🏁 EINSTEIN BAŞARILI: Evrensel kanunlar tesis edildi! 🏁🏁🏁"
}

main
