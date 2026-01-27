# SİSTEM RESTORASYON ŞARTNAMESİ (SYSTEM RESTORATION CHARTER)

**Durum:** ONAY BEKLİYOR
**Faz:** KRİZ-DENETİM (CRISIS-AUDIT)

*Bu belge FAZ: KRİZ-DENETİM kapsamında üretilmiştir. Onay almadan icra doğurmaz.*

---

## 1. Kriz Tanımı ve Kapsamı

*   **Kriz:** "Hayalet Dosya" vakası. Kök nedenin, `:app` modülünün `buildSrc` içindeki `patidost.android.application` convention plugin'i tarafından bir Kotlin projesi olarak yapılandırılmaması olduğu tespit edilmiştir.
*   **Etkilenen Alanlar:** `:app` modülünün derleme kimliği, `app/src/main/kotlin` kaynak setinin tanınmaması, proje genelinde derleme bütünlüğünün kaybolması.
*   **Geri Dönüşsüz Kayıplar:** Tespit edilmedi. Sorun yapılandırma kaynaklıdır ve onarılabilir.

## 2. Restorasyon Planı (Kriz Komut Seti ile)

*   **1. ADIM: DONDURMA**
    *   **Açıklama:** Tüm üretim faaliyetleri durdurulur.
    *   **Durum:** TAMAMLANDI (`PHASE_CRISIS_AUDIT.md` ilanı ile).

*   **2. ADIM: HARİTALAMA & RAPORLAMA**
    *   **Açıklama:** Krizin kök nedeni ve sistem bütünlüğü raporlanmıştır.
    *   **Durum:** TAMAMLANDI (`SİSTEM_BÜTÜNLÜK_RAPORU.md` ve `POST-MORTEM_HAYALET_DOSYA_VAKASI.md` ile).

*   **3. ADIM: AYIRMA (İzolasyon)**
    *   **Açıklama:** Hatalı yapılandırmanın kaynağı olan `buildSrc` ve `app/build.gradle.kts` dosyaları, onarım için birincil hedefler olarak izole edilir. Diğer modüllerde bir değişiklik yapılmayacaktır.
    *   **Eylem:** Bu adım, bir sonraki onarım adımının kapsamını belirler.

*   **4. ADIM: ONARIM**
    *   **Eylem 4.1 (En Öncelikli):** `buildSrc` içinde yer alan `patidost.android.application.gradle.kts` (veya benzeri) convention plugin dosyası incelenerek, `kotlin-android` eklentisinin `:app` modülüne uygulandığından emin olunacak.
    *   **Eylem 4.2:** Gerekli düzeltme yapıldıktan sonra, `:app:clean` ve `:app:assembleDebug` görevleri çalıştırılarak `:app` modülünün tek başına derlenebilirliği test edilecek.
    *   **Eylem 4.3:** `:app` modülü başarılı olursa, projenin tamamı için `Gradle Sync` işlemi gerçekleştirilecek.

*   **5. ADIM: DOĞRULAMA**
    *   **Eylem 5.1:** Tam bir `./gradlew clean assembleDebug` komutu çalıştırılarak tüm projenin hatasız derlendiği kanıtlanacak.
    *   **Eylem 5.2:** Android Studio'da `app/src/main/kotlin` klasörünün artık doğru şekilde bir kaynak klasörü (mavi renkli) olarak tanındığı görsel olarak doğrulanacak.

## 3. Krizden Çıkış Kriterleri ("Stabil" Tanımı)

*   Proje, herhangi bir hata veya uyarı olmadan `./gradlew clean assembleDebug` komutunu başarıyla tamamlamalıdır.
*   `POST-MORTEM_HAYALET_DOSYA_VAKASI.md`'de belirtilen kök nedenin (hatalı `buildSrc` yapılandırması) giderildiği kanıtlanmalıdır.
*   IDE, tüm modüllerin kaynak setlerini (hem `java` hem `kotlin`) doğru şekilde tanımalıdır.

## 4. GATE-KRİZ (Bu Fazın Kapısı)

Bu faz, yalnızca denetim ve raporlama üretir. Yukarıdaki **ONARIM** ve **DOĞRULAMA** adımlarının uygulanabilmesi için, bu şartnamenin Denetçi-1, Denetçi-2 ve İnsan Operatör tarafından onaylanması ve yeni bir **"FAZ: KRİZ-RESTORASYON"** fazının resmi olarak açılması gerekir.

## 5. Geri Alma Planı (Rollback)

*   **Senaryo:** Onarım adımları (özellikle `buildSrc` değişikliği) sistemi daha kötü bir duruma getirirse.
*   **Eylem:** Proje, bu restorasyon planının uygulanmaya başlandığı `git commit` haline `git reset --hard` komutu ile geri döndürülür. Tüm oluşturulan raporlar korunur ve post-mortem analizi tekrarlanır.
