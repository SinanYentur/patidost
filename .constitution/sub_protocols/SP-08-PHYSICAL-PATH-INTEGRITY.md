# ALT PROTOKOL: FİZİKSEL YOL BÜTÜNLÜĞÜ (SP-08)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/BUILD_AND_TOOLCHAIN_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Prosedürü
- **ETKİ ALANI:** Dosya Sistemi, AI İcra Ajanı
- **RİSK SEVİYESİ:** Kritik (Altyapı)

---

## 1. PRE-FLIGHT CHECK: YAZMA ÖNCESİ KONTROL

`write_file` veya benzeri bir dosya yazma işlemi başlatılmadan önce, AI ajanları aşağıdaki kontrolü yapmakla yükümlüdür:

1.  **Yol Ayrıştırma:** Hedef dosya yolunu (`absolutePath`) bileşenlerine ayır (Kök dizin, ara klasörler, dosya adı).
2.  **Kök Doğrulama:** Ayrıştırılan kök dizinin, projenin gerçek kök dizini (`C:/Users/Kratos35/AndroidStudioProjects/patidostapp`) ile %100 eşleştiğini doğrula.
3.  **Uyumsuzluk Durumu:** Eşleşme yoksa, işlemi **BAŞLATMADAN İPTAL ET** ve "Fiziksel Yol Uyumsuzluğu" krizi raporla.

## 2. YAPTIRIM

Bu kontrolü yapmadan hatalı bir yazma girişiminde bulunan bir AI ajanı, "Altyapı Bütünlüğü İhlali" suçu işlemiş sayılır ve yetkileri derhal **gözlemci moduna** düşürülür.
