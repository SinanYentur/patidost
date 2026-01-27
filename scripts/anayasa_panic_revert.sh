#!/bin/bash
# ANAYASAL SCRIPT: anayasa_panic_revert.sh
# Görevi: Kritik bir hata durumunda projeyi bilinen son kararlı commit'e geri döndürür.

# Son stabil commit hash'ini al (örneğin, son başarılı CI build'ından)
LAST_STABLE_COMMIT=$(git rev-parse HEAD~1) # Basit bir örnek, gerçek senaryoda CI'dan alınmalı

echo "[ANAYASA] 🚨 PANİK GERİ ALMA PROTOKOLÜ BAŞLATILDI! 🚨"
echo "[ANAYASA] Mevcut durum, bilinen son kararlı duruma geri döndürülecek: $LAST_STABLE_COMMIT"

# Değişiklikleri yedekle (stash)
echo "[ANAYASA] Mevcut commit edilmemiş değişiklikler yedekleniyor..."
git stash

# Geri dön
echo "[ANAYASA] Geri dönülüyor..."
git reset --hard $LAST_STABLE_COMMIT

if [ $? -eq 0 ]; then
    echo "[ANAYASA] Başarıyla geri dönüldü."
    # Proje loguna kaydet
    echo -e "\n### KRİTİK GERİ DÖNÜŞ: $(date) ###\nSebep: İnsan operatör tarafından tetiklendi.\nEski Durum: HEAD\nYeni Durum: $LAST_STABLE_COMMIT" >> docs/PROJECT_LOG.md
else
    echo "[HATA] Geri dönüş başarısız. Manuel müdahale gerekli." >&2
    exit 1
fi

exit 0
