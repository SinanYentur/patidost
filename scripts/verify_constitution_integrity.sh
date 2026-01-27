#!/usr/bin/env bash
set -e

cd "$(git rev-parse --show-toplevel)"

if ! sha256sum -c .constitution/checksums/CONSTITUTION.sha256; then
  echo "🔴 ANAYASAL İHLAL: Dosya bütünlüğü bozulmuş."
  exit 1
else
  echo "🟢 Anayasal bütünlük doğrulandı."
fi
