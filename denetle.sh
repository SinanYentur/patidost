#!/bin/bash

# Renkler
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${YELLOW}Anayasal Denetim Başlatılıyor...${NC}"

# 1. Gradle Wrapper'ı Yürütülebilir Hale Getir (İlk çalıştırma için)
if [ ! -x "gradlew" ]; then
  echo "Gradle Wrapper yürütme izni veriliyor..."
  chmod +x gradlew
fi

# 2. TEMİZLİK (Önceki denetimlerden kalan artıkları siler)
echo -e "\n${YELLOW}Adım 1/4: Önceki build artıkları temizleniyor...${NC}"
./gradlew clean || { echo -e "${RED}TEMİZLİK BAŞARISIZ! Denetim durduruldu.${NC}"; exit 1; }
echo -e "${GREEN}Temizlik başarılı.${NC}"

# 3. STİL DENETİMİ (Spotless - Google Stil Polisi)
# Sadece kontrol eder, düzeltme yapmaz. İhlal varsa hata verir.
echo -e "\n${YELLOW}Adım 2/4: Kod stili anayasaya uygunluğu kontrol ediliyor (Spotless)...${NC}"
./gradlew spotlessCheck || { echo -e "${RED}STİL İHLALİ TESPİT EDİLDİ! Kod, Google Stil Rehberi'ne uymuyor. Denetim başarısız.${NC}"; exit 1; }
echo -e "${GREEN}Stil denetimi başarılı. Tüm kodlar anayasaya uygun.${NC}"

# 4. STATİK ANALİZ (Detekt - Derin Kod Müfettişi)
# Potansiyel hataları, kod kokularını ve karmaşıklığı denetler.
echo -e "\n${YELLOW}Adım 3/4: Potansiyel körlükler ve kod kokuları taranıyor (Detekt)...${NC}"
./gradlew detekt || { echo -e "${RED}STATİK ANALİZ HATASI! Kodda potansiyel körlükler veya kritik hatalar bulundu. Denetim başarısız.${NC}"; exit 1; }
echo -e "${GREEN}Statik analiz başarılı. Potansiyel körlük bulunamadı.${NC}"

# 5. DERLEME VE BİRİM TESTLERİ (Nihai Kanıt)
# Projenin tüm modüllerini derler ve tüm unit testleri çalıştırır.
# Bu, mimari katmanların doğru bağlandığını ve temel mantığın çalıştığını kanıtlar.
echo -e "\n${YELLOW}Adım 4/4: Proje derleniyor ve birim testleri çalıştırılıyor...${NC}"
./gradlew build || { echo -e "${RED}BUILD VEYA TEST HATASI! Proje derlenemiyor veya birim testleri başarısız. Anayasal ihlal mevcut.${NC}"; exit 1; }
echo -e "${GREEN}Derleme ve birim testleri başarılı.${NC}"

echo -e "\n${GREEN}=====================================${NC}"
echo -e "${GREEN}  ANAYASAL DENETİM BAŞARIYLA TAMAMLANDI.  ${NC}"
echo -e "${GREEN}  Proje, tüm temel kanunlara uymaktadır.  ${NC}"
echo -e "${GREEN}=====================================${NC}"
