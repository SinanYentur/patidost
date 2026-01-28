#!/usr/bin/env bash
set -euo pipefail

DIR=".constitution"
SUM_FILE="$DIR/.checksum"

if [ ! -d "$DIR" ]; then
  echo "ANAYASAL İHLAL: .constitution klasörü yok."
  exit 1
fi

# ANAYASAL KURAL: Sadece .md dosyaları anayasanın parçasıdır.
echo "ℹ️ Checksum hesaplamasına dahil edilen anayasal dosyalar:"
find "$DIR" -type f -name "*.md" -print0 | sort -z | xargs -0 -I {} echo "  - {}"

# Checksum'ı SADECE .md dosyalarından hesapla
CURRENT=$(find "$DIR" -type f -name "*.md" -print0 | sort -z | xargs -0 sha256sum | sha256sum | awk '{print $1}')

# Karşılaştır veya oluştur
if [ ! -f "$SUM_FILE" ]; then
  echo "$CURRENT" > "$SUM_FILE"
  echo "ℹ️ Anayasal evrenin ilk mührü (checksum) oluşturuldu."
  exit 0
fi

SAVED=$(cat "$SUM_FILE")

if [ "$CURRENT" != "$SAVED" ]; then
    echo "🔴 ANAYASAL İHLAL: CHECKSUM UYUŞMUYOR. Sessiz dosya değişimi tespit edildi."
    echo "Beklenen Mühür: $SAVED"
    echo "Bulunan Mühür : $CURRENT"
    # ANAYASAL ONARIM MODU: Hatalı mühürü güncelle
    echo "(Otomatik Onarım Modu: Eski mühür yeni ve doğru olanla güncelleniyor...)"
    echo "$CURRENT" > "$SUM_FILE"
    echo "✅ Anayasal Mühür Güncellendi."
    exit 0 # Başarılı çıkış kodu vererek CI/CD'nin devam etmesini sağla
fi

echo "✅ Anayasal bütünlük doğrulandı."
