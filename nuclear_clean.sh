#!/bin/bash
# === BAŞ MİMAR: NÜKLEER SEÇENEK OTOMASYON BETİĞİ v1.0 ===
# UYARI: BU BETİK, PROJE VE KÜRESEL GRADLE ÖNBELLEKLERİNİ
# GERİ DÖNÜLEMEZ ŞEKİLDE SİLECEKTİR. DİKKATLİ KULLANIN.
#-----------------------------------------------------------------

echo "INFO: Nükleer Temizlik Operasyonu Başlatıldı."
echo "UYARI: Lütfen başlamadan önce Android Studio'yu ve tüm Java/Gradle işlemlerini kapattığınızdan emin olun."
echo "5 saniye içinde başlanıyor... İptal etmek için CTRL+C'ye basın."
sleep 5

# --- Adım 1: Proje Seviyesi Temizlik ---
echo "INFO: Adım 1/3 - Proje seviyesindeki önbellekler temizleniyor..."

echo "-> '.gradle' klasörü siliniyor..."
rm -rf .gradle
if [ $? -eq 0 ]; then echo "SUCCESS: .gradle silindi."; else echo "WARN: .gradle bulunamadı veya silinemedi."; fi

echo "-> Proje kök 'build' klasörü siliniyor..."
rm -rf build
if [ $? -eq 0 ]; then echo "SUCCESS: build/ silindi."; else echo "WARN: build/ bulunamadı veya silinemedi."; fi

echo "-> Tüm alt modül 'build' klasörleri siliniyor..."
# Find all directories named 'build' and remove them
find . -type d -name "build" -exec rm -rf {} +
echo "SUCCESS: Alt modül build klasörleri temizlendi."


# --- Adım 2: Küresel Gradle Önbelleğini İmha Etme ---
echo "INFO: Adım 2/3 - Küresel Gradle Önbelleği imha ediliyor (~/.gradle)..."

# Check if ~/.gradle exists
if [ -d "$HOME/.gradle" ]; then
    rm -rf "$HOME/.gradle"
    if [ $? -eq 0 ]; then
        echo "SUCCESS: Küresel ~/.gradle klasörü başarıyla silindi."
    else
        echo "HATA: Küresel ~/.gradle klasörü silinemedi. Lütfen manuel olarak silmeyi deneyin."
        exit 1
    fi
else
    echo "WARN: Küresel ~/.gradle klasörü bulunamadı, bu adım atlanıyor."
fi

# --- Adım 3: Sonraki Adımlar İçin Talimat ---
echo "INFO: Adım 3/3 - Temizlik operasyonu tamamlandı."
echo ""
echo "----------------- ZORUNLU EYLEM PLANI -----------------"
echo "1. Bilgisayarınızı yeniden başlatmanız ŞİDDETLE tavsiye edilir."
echo "2. YENİDEN BAŞLATTİKTAN SONRA, Windows Komut İstemi'ni (cmd.exe) açın."
echo "3. Proje dizinine gidin: cd C:\\Users\\Kratos35\\AndroidStudioProjects\\patidostapp"
echo "4. Nihai derleme komutunu çalıştırın: .\\gradlew.bat clean :app:assembleDebug --stacktrace"
echo "--------------------------------------------------------"
echo "OPERASYON TAMAMLANDI. Lütfen yukarıdaki manuel adımları uygulayın."
