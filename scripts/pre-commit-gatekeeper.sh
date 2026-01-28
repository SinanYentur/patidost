#!/usr/bin/env bash
# ML-001 & ML-002 Entegre Kilidi: Patidost Anayasal Kapı Bekçisi v2.2 (GÜVENLİ)

COMMIT_MSG_FILE=$1
COMMIT_MSG=$(cat "$COMMIT_MSG_FILE")

# Gevşetilmiş Desen: Köşeli parantez içinde harf, rakam, tire içeren her şeyi kabul et.
PIN_PATTERN="\[([A-Za-z0-9_-]+)\]"

if ! [[ $COMMIT_MSG =~ $PIN_PATTERN ]]; then
    echo "----------------------------------------------------------------"
    echo "🔴 ANAYASAL İHLAL (ML-001): Commit engellendi!"
    echo "Gerekçe: Commit mesajı standart anayasal referans formatında değil."
    echo "Örnek Kullanım: 'feat: [CORE-001] yeni mekanik kilit kurulumu'"
    echo "----------------------------------------------------------------"
    exit 1
fi

REFERENCE_ID=${BASH_REMATCH[1]}
echo "✅ Anayasal bağ formatı doğrulandı (Referans: $REFERENCE_ID). İçerik doğrulanıyor..."

# ML-002 Motorunu Çalıştır ve sonucunu KONTROL ET
SCANNER_SCRIPT="$(dirname "$0")/constitutional_ref_scanner.sh"

# 'if !' yapısı, scanner script'i 'exit 1' (hata) döndürdüğünde bu bloğun çalışmasını sağlar.
if ! bash "$SCANNER_SCRIPT" "$REFERENCE_ID"; then
    echo "----------------------------------------------------------------"
    echo "🔴 ANAYASAL İHLAL (ML-002): Commit engellendi!"
    echo "Gerekçe: Belirtilen referans ($REFERENCE_ID) anayasal evrende bulunamadı veya geçersiz."
    echo "----------------------------------------------------------------"
    exit 1
fi

echo "✅ Anayasal referans geçerliliği doğrulandı. Commit onaylandı."
exit 0
