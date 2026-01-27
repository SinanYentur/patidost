# POST-MORTEM: "HAYALET DOSYA" VAKASI

**Durum:** Üretim Aşamasında
**Faz:** KRİZ-DENETİM (CRISIS-AUDIT)

*Bu belge FAZ: KRİZ-DENETİM kapsamında üretilmiştir. Onay almadan icra doğurmaz.*

---

## 1. Olay Zaman Çizelgesi (Timeline)

*   **[Tarih/Saat Bilinmiyor]:** Projenin `buildSrc` içindeki `patidost.android.application` convention plugin'inde, `kotlin-android` eklentisini uygulama görevi ya hatalı yapılandırıldı ya da silindi.
*   **[Tarih/Saat Bilinmiyor]:** Bu yapılandırma hatası sonrası yapılan ilk derleme denemelerinde, `:app` modülü artık bir Kotlin projesi olarak tanınmadı.
*   **2026-01-26:** `OPERATIONAL_TASK_LOG.md`'ye "Hayalet Dosya" enfeksiyonu kaydı girildi ve kriz resmiyet kazandı. Bu, semptomun (dosyaların boşaltılması) kaydedilmesiydi, kök nedenin değil.
*   **2024-07-29:** Kök neden analizi sırasında, `:app` modülünün `build.gradle.kts` dosyasında `kotlin-android` eklentisinin eksik olduğu kesin olarak tespit edildi.

## 2. Teknik Kök Neden Analizi

*   **Bulgu 1:** `:app` modülü, bir Kotlin modülü olmasını sağlayan `kotlin-android` Gradle eklentisinden yoksundur.
*   **Kanıt:** `app/build.gradle.kts` dosyasının `plugins` bloğunda `id("kotlin-android")` veya `id("org.jetbrains.kotlin.android")` tanımı bulunmamaktadır.
*   **Sonuç:** Bu eksiklik, Gradle'ın `app/src/main/kotlin` dizinini bir kaynak klasörü olarak tanımamasına, dolayısıyla derleme sürecine dahil etmemesine neden olmaktadır. "Hayalet Dosya" olarak adlandırılan durum, aslında derleme sisteminin bu klasörü tamamen görmezden gelmesidir.

*   **Bulgu 2:** Proje, yapılandırmayı merkezileştirmek için `buildSrc` içinde tanımlı `convention plugin`'ler kullanmaktadır.
*   **Kanıt:** `app/build.gradle.kts` dosyasında `id("patidost.android.application")` gibi özel plugin'lerin kullanılması.
*   **Sonuç:** Kök nedenin, doğrudan `app/build.gradle.kts` dosyasından ziyade, bu merkezi `patidost.android.application` plugin'inin içindeki bir hatadan kaynaklandığı yüksek bir olasılıktır.

## 3. Etkilenen Katmanlar

*   **Build Sistemi:** En temel katmanda bozulma mevcut. Sistemin en önemli modülü olan `:app`'in kimliği (Kotlin projesi olduğu) kaybolmuştur.
*   **Dosya Sistemi:** Fiziksel olarak var olan `kotlin` klasörleri, build sistemi tarafından tanınmadığı için "hayalet" durumuna düşmüştür.
*   **IDE Entegrasyonu:** Android Studio, Gradle'dan aldığı hatalı yapılandırma nedeniyle `kotlin` klasörünü doğru şekilde işaretleyememekte ve proje ağacında göstermemektedir.

## 4. Önlenebilirlik Analizi

*   **Hangi Anayasal Kural Eksikti?:** `OMEGA_CODEX`'te belirtilen "Kriz Modu" protokolleri ve Denetçi-2'nin işaret ettiği `Madde 57.1 (Kriz Dönüşüm Zinciri)`nin tam olarak uygulanmaması. Semptom (boşaltılmış dosyalar) kaydedilmiş ancak kök neden (build yapılandırma hatası) analizi yapılmamıştır.
*   **Hangi Denetim Atlandı?:** Her modülün temel kimliğini (Java/Kotlin, App/Library) doğrulayan bir "Modül Doğum Sertifikası" denetiminin eksikliği. `patidost.android.application` gibi bir convention plugin değiştirildiğinde, bunun etkilediği tüm modülleri yeniden doğrulayan bir CI adımı (regresyon denetimi) atlanmıştır.

## 5. Tekrarını Önleme İlkeleri (Önerilen Yeni Kurallar)

*   **Kural 1 (Anayasal):** Her `convention plugin` değişikliği, bu plugin'i kullanan tüm modüller için zorunlu bir "Temel Bütünlük Testi" (derlenebilirlik, kaynak seti doğruluğu, temel eklenti varlığı) tetiklemelidir.
*   **Kural 2 (Prosedürel):** `SYSTEM_RESTORATION_CHARTER.md` planı, `buildSrc` ve convention plugin'lerin denetimini ve onarımını ilk ve en öncelikli adım olarak tanımlamalıdır.
