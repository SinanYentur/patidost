
#!/bin/bash
# === BAŞ MİMAR: ANAYASAL SIFIRLAMA BETİĞİ v2.0 (STERILE BUILD) ===

# --- Konfigürasyon ---
REQUIRED_GRADLE_VERSION="8.6"
GRADLE_ZIP_URL="https://services.gradle.org/distributions/gradle-${REQUIRED_GRADLE_VERSION}-bin.zip"
GRADLE_ZIP_FILE="gradle-${REQUIRED_GRADLE_VERSION}-bin.zip"
TEMP_DIR="tmp_gradle_dist"

# --- Eylem Planı ---
echo "INFO: Anayasal Sıfırlama protokolü (v2.0) başlatıldı."
echo "INFO: Gerekli Gradle Versiyonu: ${REQUIRED_GRADLE_VERSION}"

# 1. Önceki artıkları temizle
rm -f gradle-*-bin.zip
rm -rf "${TEMP_DIR}"

# 2. Gerekli Gradle dağıtımını indir
echo "INFO: Adım 1/5 - Harici ve temiz Gradle ${REQUIRED_GRADLE_VERSION} indiriliyor..."
curl -L -o "${GRADLE_ZIP_FILE}" "${GRADLE_ZIP_URL}"
if [ $? -ne 0 ]; then echo "HATA: İndirme başarısız."; exit 1; fi
echo "SUCCESS: Temiz Gradle dağıtımı indirildi."

# 3. İndirilen dağıtımı aç
echo "INFO: Adım 2/5 - Dağıtım geçici klasöre açılıyor..."
mkdir "${TEMP_DIR}"
unzip -q "${GRADLE_ZIP_FILE}" -d "${TEMP_DIR}"
if [ $? -ne 0 ]; then echo "HATA: Arşiv açılamadı."; exit 1; fi
echo "SUCCESS: Dağıtım açıldı."

# 4. Projenin mevcut wrapper'ını SIFIRLA ve YENİDEN İNŞA ET
echo "INFO: Adım 3/5 - Projenin kendi wrapper'ı, harici ve doğru Gradle ile yeniden inşa ediliyor..."
rm -rf gradle/wrapper
mkdir -p gradle/wrapper
# KRİTİK EYLEM: Harici, temiz Gradle'ı kullanarak projenin wrapper'ını oluştur.
"${TEMP_DIR}/gradle-${REQUIRED_GRADLE_VERSION}/bin/gradle" wrapper
if [ $? -ne 0 ]; then echo "HATA: Wrapper yeniden inşa edilemedi."; exit 1; fi
echo "SUCCESS: Projenin kendi Gradle Wrapper'ı başarıyla yeniden inşa edildi."

# 5. Temizlik ve Nihai Kanıt
echo "INFO: Adım 4/5 - Geçici dosyalar temizleniyor..."
rm -f "${GRADLE_ZIP_FILE}"
rm -rf "${TEMP_DIR}"
echo "SUCCESS: Temizlik tamamlandı."

echo "INFO: Adım 5/5 - NİHAİ ALTYAPI TESTİ..."
echo "------------------------------------------------------------"
./gradlew --version
GRADLEW_EXIT_CODE=$?
echo "------------------------------------------------------------"

if [ $GRADLEW_EXIT_CODE -ne 0 ]; then
    echo "❌ BAŞARISIZ: Altyapı kurtarıldı ancak test sırasında hata verdi. FAZ-(-1) devam ediyor."
    exit 1
else
    echo "✅✅✅ BAŞARI: ALTYAPI TAMAMEN STABİL. FAZ-(-1) KAPATILDI. ✅✅✅"
fi

# === OPERASYON SONU ===
