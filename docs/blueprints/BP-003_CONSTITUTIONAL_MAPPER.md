# MEKANİK KİLİT TASARIM BELGESİ: BP-003 (MAP-001: Anayasal İzlenebilirlik Motoru) v2.0

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** CORE_CONSTITUTION.md Madde 1.2
- **WEB DAYANAĞI:** Requirements Traceability Matrix (RTM), Requirement-as-Code (RaC)
- **AMAÇ:** Anayasanın kod tabanındaki kapsama alanını ölçmek ve "anayasal kör noktaları" tespit etmek.

---

## 1. MİMARİ FELSEFE VE GEREKÇE

Bu motor, modern yazılım yönetişimindeki "Traceability Matrix" pratiğini anayasal düzleme taşır. Amacı, her anayasal gereksinimin (PIN/ID) kodun hangi parçasında yaşadığını kanıtlamak ve "başıboş" veya "gerekçesiz" kodun varlığını imkansız kılmaktır.

## 2. MOTOR MİMARİSİ (scripts/constitutional_mapper.sh)

1.  **İndeksleme:** Önce `generate_constitutional_index.sh` çalıştırılarak geçerli tüm anayasal ID'lerin bir listesi (`.constitution/.index`) oluşturulur.
2.  **Tarama:** Script, `.kt`, `.java`, `.xml`, `.sh`, `.gradle`, `.md` gibi tüm ilgili dosyalardaki `[ID-XXX]` formatındaki referansları ve bulundukları dosya yollarını yakalar.
3.  **Çapraz Doğrulama (Cross-Validation):**
    *   **Zombi Referans Tespiti:** Kodda bulunan her referansın, `.index` dosyasında bir karşılığı olup olmadığını kontrol eder. Karşılığı yoksa, "Zombi Referans" olarak işaretler.
    *   **Yetim Dosya Tespiti:** Hiçbir anayasal referans içermeyen dosyaları "Yetim Dosya" olarak işaretler.

## 3. RAPOR STANDARDI (reports/CONSTITUTIONAL_COVERAGE.md)

Motorun üreteceği rapor, aşağıdaki bölümleri içermek zorundadır:

*   **📊 Anayasal Kapsama Oranı (%):** Kapsanan anayasal madde sayısının toplam madde sayısına oranı.
*   **🚫 Yetim Dosyalar Listesi:** Anayasal koruması olmayan, en yüksek riskli dosyaların listesi.
*   **☣️ Zombi Referanslar Listesi:** Kod tabanında temizlenmesi gereken geçersiz veya eski referansların listesi.
*   **🗺️ PIN → Dosya Eşleşme Matrisi:** Hangi anayasa maddesinin hangi dosyaları koruduğunu gösteren detaylı izlenebilirlik matrisi.

## 4. ANAYASAL İHLAL SINIFLARI

Bu motor, aşağıdaki yeni anayasal ihlal sınıflarını resmen tanımlar:

*   **Yetim Dosya (Orphaned File):** Anayasal olarak sahipsiz, amacı ve gerekçesi belirsiz kod. En tehlikeli borç sınıfıdır.
*   **Zombi Referans (Zombie Reference):** Artık var olmayan bir anayasa maddesine yapılan atıf. Kodun güncelliğini yitirdiğini gösterir.

---
**ONAY:** Bu blueprint onaylandığında, `scripts/constitutional_mapper.sh` script'i bu plana göre inşa edilecektir.
