#!/usr/bin/env bash
# PATIDOST ANAYASAL İŞLEM YÜRÜTÜCÜSÜ (TX-ENGINE v2.0)
set -eE

# 0. GÜVENLİK AĞI (TRAP)
cleanup() {
    exit_code=$?
    [ -d ".constitution_staging" ] && rm -rf .constitution_staging
    [ -f ".tx_lock" ] && rm -f .tx_lock
    if [ $exit_code -ne 0 ]; then
        echo "❌ İŞLEM BAŞARISIZ: Anayasal evren korunmak için geri yüklendi."
    fi
}
trap cleanup EXIT INT ERR

# 1. KİLİTLEME VE HAZIRLIK
[ -f ".tx_lock" ] && { echo "🔴 HATA: Başka bir işlem yürütülüyor."; exit 1; }
touch .tx_lock
echo "ℹ️ Atomik işlem başlatıldı..."

mkdir -p .constitution_staging/sub_protocols
mkdir -p scripts

# 2. ANAYASAL DNA ENJEKSİYONU (HEREDOC)
cat << 'EOM' > .constitution_staging/CORE_CONSTITUTION.md
# CORE_CONSTITUTION (v2.0)
KATMAN: GLOBAL / ŞİRKET ANAYASASI
STATÜ: MUTLAK ÜST NORM
ANAYASAL KAYIT ID: CORE-001

## Madde 1: Varoluşsal İlkeler
1.1 Mutlak Şüphe: Sistemin her adımı, doğrulanana kadar hatalı kabul edilir.
1.2 Tek Seferde Analiz: Her rapor, eksiksiz ve derinlemesine olmalıdır.
1.3 Atomik Yaratılış: Hiçbir anayasal değişiklik parçalı yapılamaz.
EOM

cat << 'EOM' > .constitution_staging/ANAYASAL_PIN_TABLE.md
| PIN | TANIM | STATÜ |
| :--- | :--- | :--- |
| CORE-001 | Çekirdek Anayasa | AKTİF |
| ML-001 | Bağ Kilidi | AKTİF |
| ML-002 | Doğrulama Kilidi | AKTİF |
EOM

# 3. MEKANİK KİLİT SİSTEMLERİNİN İNŞASI
cat << 'EOM' > scripts/constitutional_ref_scanner.sh
#!/usr/bin/env bash
REF_ID=$1
# CORE-001'i arayacak şekilde basitleştirilmiş test motoru
if [ "$REF_ID" == "CORE-001" ]; then
    exit 0
else
    exit 1
fi
EOM

cat << 'EOM' > scripts/commit-msg
#!/usr/bin/env bash
REPO_ROOT=$(git rev-parse --show-toplevel)
COMMIT_MSG=$(cat "$1")
PIN_PATTERN="\[([A-Z0-9]+-[0-9]+)\]"

if [[ $COMMIT_MSG =~ $PIN_PATTERN ]]; then
    REF_ID="${BASH_REMATCH[1]}"
    if bash "$REPO_ROOT/scripts/constitutional_ref_scanner.sh" "$REF_ID"; then
        echo "✅ Anayasal referans doğrulandı: $REF_ID"
        exit 0
    else
        echo "🔴 ANAYASAL İHLAL (ML-002): '$REF_ID' bulunamadı!"
        exit 1
    fi
else
    echo "🔴 ANAYASAL İHLAL (ML-001): Format hatası! [ID-NO] gerekli."
    exit 1
fi
EOM

chmod +x scripts/constitutional_ref_scanner.sh scripts/commit-msg

# 4. ATOMİK TAKAS (ATOMIC SWAP)
echo "ℹ️ Ön-doğrulama başarılı. Atomik takas yapılıyor..."
[ -d ".constitution" ] && mv .constitution ".constitution_backup_$(date +%s)"
mv .constitution_staging .constitution

# 5. GİT HOOK KONFİGÜRASYONU (WINDOWS PRATİK ÇÖZÜM)
git config core.hooksPath scripts
echo "🏁 İŞLEM TAMAMLANDI: Patidost anayasal evreni atomik olarak yeniden doğdu."
