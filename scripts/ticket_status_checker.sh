#!/usr/bin/env bash
# ML-003: Bilet Durum Doğrulama Motoru v2.0 (SAĞLAMLAŞTIRILMIŞ)

set -euo pipefail

REPO_ROOT=$(git rev-parse --show-toplevel)
ACTIVE_TICKETS_FILE="$REPO_ROOT/docs/ACTIVE_TICKETS.md"
TICKET_ID=$1

# Adım 1: Bilet ID'sini içeren satırı bul.
# `-m 1` ilk eşleşmeyi bulduktan sonra durur, performansı artırır.
LINE=$(grep -m 1 "$TICKET_ID" "$ACTIVE_TICKETS_FILE" || true)

# Eğer satır boşsa, bilet hiç bulunamamıştır.
if [ -z "$LINE" ]; then
    exit 1
fi

# Adım 2: Sadece bulunan satırın içinde geçerli statüleri ara.
if echo "$LINE" | grep -q "\[OPEN\]" || echo "$LINE" | grep -q "\[IN-PROGRESS\]"; then
    exit 0 # Başarılı: Bilet bulundu ve statüsü uygun.
else
    exit 1 # Başarısız: Bilet bulundu ancak statüsü [OPEN] veya [IN-PROGRESS] değil.
fi
