#!/usr/bin/env bash
set -euo pipefail

DIR=".constitution"
SUM_FILE="$DIR/.checksum"

if [ ! -d "$DIR" ]; then
  echo "ANAYASAL İHLAL: .constitution klasörü yok."
  exit 1
fi

# Dosya içeriklerinin hash'ini al, sırala ve tekrar hash'le (Merkle Tree benzeri)
# Bu yöntem, dosya isimleri değişmese bile içerik değişimini yakalar.
CURRENT=$(find "$DIR" -type f ! -name ".checksum" -print0 | sort -z | xargs -0 sha256sum | sha256sum | awk '{print $1}')

if [ ! -f "$SUM_FILE" ]; then
  echo "$CURRENT" > "$SUM_FILE"
  echo "ℹ İlk anayasal checksum oluşturuldu."
  exit 0
fi

SAVED=$(cat "$SUM_FILE")

if [ "$CURRENT" != "$SAVED" ]; then
    echo "ANAYASAL İHLAL: CHECKSUM UYUŞMUYOR. Sessiz dosya değişimi tespit edildi."
    echo "Beklenen: $SAVED"
    echo "Bulunan:  $CURRENT"
    exit 1
fi

echo "✔ Anayasal bütünlük doğrulandı."
