# SİSTEM RESTORASYON ŞARTNAMESİ (SYSTEM RESTORATION CHARTER)

**Durum:** Üretim Aşamasında
**Faz:** KRİZ-DENETİM (CRISIS-AUDIT)

*Bu belge FAZ: KRİZ-DENETİM kapsamında üretilmiştir. Onay almadan icra doğurmaz.*

---

## 1. Kriz Tanımı ve Kapsamı

*   **Kriz:** "Hayalet Dosya" vakası ve buna bağlı sistem bütünlüğü ihlali.
*   **Etkilenen Alanlar:**
*   **Geri Dönüşsüz Kayıplar (varsa):**

## 2. Restorasyon Planı (Kriz Komut Seti ile)

*   **1. ADIM: DONDURMA**
    *   **Açıklama:** Tüm üretim faaliyetleri durdurulur.
    *   **Durum:** TAMAMLANDI (`PHASE_CRISIS_AUDIT.md` ilanı ile).

*   **2. ADIM: HARİTALAMA**
    *   **Açıklama:** Krizin etkilediği tüm dosyalar, modüller ve yapılandırmalar listelenir.
    *   **Referans:** `SİSTEM_BÜTÜNLÜK_RAPORU.md`, `POST-MORTEM_HAYALET_DOSYA_VAKASI.md`

*   **3. ADIM: AYIRMA**
    *   **Açıklama:** Bozuk veya şüpheli yapılandırmalar izole edilir.
    *   **Eylem:**

*   **4. ADIM: ONARIM**
    *   **Açıklama:** Onaylı plana göre Gradle Sync çalıştırılır, eksik klasörler anayasaya uygun oluşturulur.
    *   **Eylem:**

*   **5. ADIM: DOĞRULAMA**
    *   **Açıklama:** Sistemin "STABİL" tanımına ulaşıp ulaşmadığı test edilir.
    *   **Eylem:**

## 3. Krizden Çıkış Kriterleri ("Stabil" Tanımı)

*   Proje, herhangi bir hata veya uyarı olmadan başarıyla derlenmelidir (`clean build`).
*   Tüm anayasal dosyalar (`ANAYASAL_PIN_TABLE.md` listesindekiler) yerinde ve bütünlüğü doğrulanmış olmalıdır.
*   `SİSTEM_BÜTÜNLÜK_RAPORU.md`'de belirtilen tüm kritik ve yüksek riskli maddeler çözülmüş olmalıdır.

## 4. GATE-KRİZ (Bu Fazın Kapısı)

Bu faz, yalnızca denetim ve raporlama üretir. Yukarıdaki onarım adımlarının uygulanabilmesi için bu şartnamenin Denetçi-1, Denetçi-2 ve İnsan Operatör tarafından onaylanması ve yeni bir "FAZ: RESTORASYON" fazının açılması gerekir.

## 5. Geri Alma Planı (Rollback)

*   **Senaryo:** Onarım adımları sistemi daha kötü bir duruma getirirse.
*   **Eylem:** Proje, bu faza başlanmadan önceki `git commit` haline geri döndürülür. Tüm oluşturulan raporlar `archive/` dizinine taşınır.
