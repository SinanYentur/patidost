#!/usr/bin/env bash
set -euo pipefail
[ -f ".constitution/PIN_TABLE.md" ] || { echo "ANAYASAL İHLAL: PIN_TABLE yok"; exit 1; }
echo "✔ PIN_TABLE doğrulandı."
