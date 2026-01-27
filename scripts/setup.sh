#!/bin/bash
# ANKARA-OS v8.0 INITIAL SETUP

echo "⚙️  ANKARA-OS v8.0 Sistem Kurulumu Başlatılıyor..."

# 1. Klasör Kontrolleri
mkdir -p .githooks
mkdir -p scripts/auditor
mkdir -p contracts/AUDIT_REPORTS

# 2. Git Hook Kurulumu
echo "🔧 Git Hook'ları yükleniyor..."
cp .githooks/pre-commit .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
echo "✅ Pre-commit hook aktif."

# 3. İzinler
chmod +x scripts/*.sh 2>/dev/null

echo "✅ Kurulum tamamlandı. Sistem Operasyona Hazır."
