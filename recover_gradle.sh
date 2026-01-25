
#!/bin/bash
# === BAŞ MİMAR: ALTYAPI KURTARMA BETİĞİ v1.6 (ULTIMATE) ===

# --- Konfigürasyon ---
GRADLE_VERSION="8.5"
GRADLE_ZIP_URL="https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
GRADLE_ZIP_FILE="gradle-${GRADLE_VERSION}-bin.zip"
TARGET_DIR="gradle/wrapper"
TARGET_JAR_NAME="gradle-wrapper.jar"
# KESİN YOL: Artık desen değil, tam yol aranacak.
WRAPPER_JAR_SUBPATH="lib/plugins/gradle-wrapper-${GRADLE_VERSION}.jar"
TEMP_UNZIP_DIR="tmp_gradle_extraction"
MINIMUM_JAR_SIZE=40000 # Beklenen minimum dosya boyutu (byte)

# --- Eylem Planı ---
echo "INFO: Baş Mimar nihai kurtarma protokolü v1.6 (ULTIMATE) başlatıldı."

# 1. Temizlik
rm -rf "${TEMP_UNZIP_DIR}"
mkdir -p "${TARGET_DIR}"
mkdir -p "${TEMP_UNZIP_DIR}"

# 2. İndirme
echo "INFO: Adım 1/5 - Gradle ZIP dosyası hazırlanıyor..."
if [ ! -f "${GRADLE_ZIP_FILE}" ]; then
    curl -L -o "${GRADLE_ZIP_FILE}" "${GRADLE_ZIP_URL}"
fi

# 3. Arşivi Çıkar
echo "INFO: Adım 2/5 - Arşiv geçici dizine çıkartılıyor..."
unzip -q "${GRADLE_ZIP_FILE}" -d "${TEMP_UNZIP_DIR}"

# 4. KESİN YOL ile dosyayı bul ve kopyala
echo "INFO: Adım 3/5 - Çekirdek dosya tam yoldan kopyalanıyor..."
UNZIPPED_BASE_DIR="${TEMP_UNZIP_DIR}/gradle-${GRADLE_VERSION}"
WRAPPER_JAR_SOURCE_PATH="${UNZIPPED_BASE_DIR}/${WRAPPER_JAR_SUBPATH}"

if [ ! -f "${WRAPPER_JAR_SOURCE_PATH}" ]; then
    echo "HATA: Kaynak dosya beklenen yolda bulunamadı: ${WRAPPER_JAR_SOURCE_PATH}"
    exit 1
fi

cp "${WRAPPER_JAR_SOURCE_PATH}" "${TARGET_DIR}/${TARGET_JAR_NAME}"
echo "SUCCESS: Dosya hedef konuma kopyalandı."

# 5. DOĞRULAMA: Dosya boyutunu kontrol et
echo "INFO: Adım 4/5 - Kopyalanan dosyanın bütünlüğü doğrulanıyor..."
COPIED_FILE_SIZE=$(stat -c%s "${TARGET_DIR}/${TARGET_JAR_NAME}")

if [ "${COPIED_FILE_SIZE}" -lt "${MINIMUM_JAR_SIZE}" ]; then
    echo "HATA: Kopyalanan dosya boyutu (${COPIED_FILE_SIZE} bayt) beklenenden çok küçük. Operasyon BAŞARISIZ."
    exit 1
fi
echo "SUCCESS: Dosya boyutu (${COPIED_FILE_SIZE} bayt) geçerli."

# 6. Temizlik ve Nihai Kanıt
echo "INFO: Adım 5/5 - Temizlik ve nihai kanıt sunumu..."
rm -f "${GRADLE_ZIP_FILE}"
rm -rf "${TEMP_UNZIP_DIR}"
echo "-------------------------------------------"
echo "KANIT: '${TARGET_DIR}' dizininin son durumu:"
ls -la "${TARGET_DIR}"
echo "-------------------------------------------"
echo "✅✅✅ BAŞARI: ALTYAPI BAŞARIYLA KURTARILDI. ✅✅✅"

# === OPERASYON SONU ===
