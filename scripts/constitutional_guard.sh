#!/bin/bash

echo "=== 🏛️ CONSTITUTIONAL GUARD ACTIVE ==="

VIOLATION=0

# --- ZORUNLU DOSYALAR ---
REQUIRED_FILES=(
  "ANAYASA_ANDROID_STUDIO_DENETCI_EKLER.md"
  "AI_ZERO_TOLERANCE_POLICY.md"
  "1-KİŞİSEL YÜKSEK GÜVENİLİRLİKLİ YAZIL.md"
)

for file in "${REQUIRED_FILES[@]}"; do
  if [ ! -f "$file" ]; then
    echo "❌ ANAYASAL İHLAL: Eksik dosya -> $file"
    VIOLATION=1
  fi
done

# --- YASAKLI DESENLER (örnek güvenlik + mimari) ---
FORBIDDEN_PATTERNS=(
  "TODO"
  "FIXME"
  "println("
  "System.out.print"
  "Any\\b"
)

echo "🔍 Kaynak taraması..."

FILES=$(git diff --cached --name-only | grep -E "\.kt$|\.java$")

for f in $FILES; do
  for pattern in "${FORBIDDEN_PATTERNS[@]}"; do
    if grep -R "$pattern" "$f" >/dev/null 2>&1; then
      echo "❌ ANAYASAL İHLAL: $f içinde yasaklı desen -> $pattern"
      VIOLATION=1
    fi
  done
done

# --- TEST VAR MI KONTROLÜ ---
if ! git diff --cached --name-only | grep -E "Test.kt$" >/dev/null; then
  echo "⚠️ UYARI: Bu commit içinde test dosyası yok."
fi

# --- SON KARAR ---
if [ "$VIOLATION" -eq 1 ]; then
  echo "⛔ COMMIT ENGELLENDİ — ANAYASAL KORUMA DEVREDE"
  exit 1
else
  echo "✅ ANAYASAL UYUM GEÇTİ"
fi

exit 0
