# KANIT RAPORU: Protokol Spesifikasyonu ve Kandırma Körlüğü Düzeltmesi

**PROTOKOL ID:** AI-PROTOCOL: WEB-EVIDENCE-CONTINUOUS-v2026.1
**KANIT ID:** E-SA-002
**TARİH:** 2026-05-24T13:55:00Z

## 1. Denetim Bulgusu ve Kabul

Harici denetim (kullanıcı) tarafından, `ANAYASA-PROTOKOL: KESINTISIZ-ICRA` etiketinin spesifikasyon, metrik, hata yönetimi ve teknoloji stack'i içermediği, bu nedenle "boş bir etiket" olduğu ve "Kandırma Körlüğü" potansiyeli taşıdığı tespit edilmiştir. Bu analiz, sistem tarafından **doğru ve geçerli** olarak kabul edilmiştir.

## 2. Protokol Spesifikasyonu: WEB-EVIDENCE-CONTINUOUS-v2026.1

Bu belge, soyut komutun yerine geçen somut ve denetlenebilir icraat protokolünü tanımlar.

*   **2.1. Teknoloji Stack'i:
    *   **Veri Kaynağı API'leri:** `search_android_docs`, `version_lookup`.
    *   **Veri Depolama API'si:** `write_file`.
    *   **Veri Analiz Motoru:** Dahili AI mantık ve sentezleme çekirdeği.

*   **2.2. SLA ve Sıklık (Kesintisizlik Tanımı):
    *   **Tanım:** "Kesintisiz", insan müdahalesi veya onayı beklemeksizin, bir önceki API çağrısı (`search_android_docs`) tamamlanır tamamlanmaz, bir sonraki mantıksal araştırma sorgusunun otonom olarak tetiklenmesidir.
    *   **SLA:** Döngüler arasındaki bekleme süresi `sıfır` hedeflidir (yalnızca işlem süresi kadar).

*   **2.3. Depolama Stratejisi:
    *   **Format:** Toplanan her bir kanıt, analiz edilip sentezlendikten sonra `.dna/evidence/` dizini altında, yapılandırılmış bir `Markdown` (.md) dosyası olarak kalıcı hale getirilir.
    *   **İsimlendirme:** Dosya adları, kanıtın içeriğini yansıtacak şekilde `EVIDENCE-[KATEGORİ]_[KONU].md` formatında olacaktır.

*   **2.4. Hata Yönetimi ve Kilitlenme:
    *   **API Hatası:** `search_android_docs` veya `version_lookup` bir hata döndürürse, sistem 3 adımlı bir protokol izler: 1) Sorguyu yeniden formüle ederek tekrar dener. 2) Farklı anahtar kelimelerle alternatif bir sorgu dener. 3) 3 başarısız denemeden sonra, konu hakkında kanıt bulunamadığını bir **Kilitlenme Raporu** ile bildirir ve protokolü durdurur.
    *   **Yazma Hatası:** `write_file` hatası, kritik bir altyapı sorunu olarak kabul edilir ve protokolü derhal durdurarak bir **Sistemik Hata Raporu** sunar.

*   **2.5. Güvenlik ve İzolasyon:
    *   Tüm operasyonlar, Android Studio tarafından sağlanan sanal (sandboxed) ortamda çalışır. Sistemin dosya sistemine veya ağa erişimi, yalnızca tanımlanmış `default_api` araçları ile sınırlıdır.

*   **2.6. Başarı ve Durma Metrikleri:
    *   **Başarı Metriği:** Üretilen benzersiz ve değerli kanıt raporu sayısı.
    *   **Durma Koşulu:** Protokol, iki koşuldan biri sağlandığında durur: 1) Önceden tanımlanmış araştırma konuları listesi (Tüm Küresel, Junior, Senior Körlükleri ve Anayasal Fazlar) tükendiğinde. 2) Yeni sorgular, mevcut kanıt raporlarında zaten bulunan bilgileri tekrar etmeye başladığında (bilgi doygunluğu).

## 3. Nihai Hüküm

`ANAYASA-PROTOKOL: KESINTISIZ-ICRA` protokolü, bu yeni ve somut spesifikasyon (`AI-PROTOCOL: WEB-EVIDENCE-CONTINUOUS-v2026.1`) ile güncellenmiş ve mühürlenmiştir. Sistem, bu somut kurallar çerçevesinde kesintisiz icraata devam edecektir.
