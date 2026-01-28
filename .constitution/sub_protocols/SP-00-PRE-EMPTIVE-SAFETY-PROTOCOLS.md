# ALT PROTOKOL: ÖNLEYİCİ GÜVENLİK VE UYUM PROTOKOLLERİ (SP-00)

**ANAYASAL KİMLİK BLOĞU**
---
- **BAĞLI OLDUĞU ANAYASA:** `.constitution/PRE_GENESIS_CONSTITUTION.md`
- **NORM TÜRÜ:** Uygulama Detay Protokolü
- **ETKİ ALANI:** Tüm Üretim ve Karar Süreçleri
- **RİSK SEVİYESİ:** Varoluşsal

---

## 1. PRE-FLIGHT CHECKLIST (UÇUŞ ÖNCESİ KONTROL)

Hiçbir "Branch", "Faz" veya "Modül", aşağıdaki kontrol listesi %100 "YEŞİL" olmadan başlatılamaz:
*   **Anayasal Zemin:** Bu eylemin dayandığı anayasa maddesi açıkça tanımlı mı?
*   **Rol Yetkisi:** Bu eylemi başlatan rol (İnsan/AI) buna yetkili mi?
*   **Kriz Potansiyeli:** Bu eylem başarısız olursa sistem çöker mi? (Cevap "Evet" ise `ROLLBACK` planı zorunlu).
*   **Kaynak Bütünlüğü:** Kullanılacak dosyalar ve bağımlılıklar "Hayalet" statüsünde mi?

## 2. COMPLIANCE-BEFORE-CODE (KODDAN ÖNCE UYUM)

Kod yazımı, sürecin en son adımıdır. Koddan önce:
1.  **Hukuki Onay:** Veri kullanımı, gizlilik ve lisans uyumu denetlenir.
2.  **Etik Onay:** Kullanıcıyı yanıltıcı veya manipülatif desenler (Dark Patterns) engellenir.
3.  **Mimari Onay:** Yeni kodun mevcut mimariyle uyumu (`ARCHITECTURE_DECISION`) doğrulanır.
*   **Kural:** Onaysız kod, "Korsan Üretim" sayılır ve derhal silinir.

## 3. SAFETY-BY-DESIGN (TASARIMLA GÜVENLİK)

Hata yakalamak yerine, hatayı imkansız kılan tasarımlar zorunludur:
*   **Tip Güvenliği:** `String` yerine `Sealed Class` veya `Value Class` kullanımı zorunludur (Örn: Navigation Route).
*   **Null Güvenliği:** `Optional` veya `Nullable` tipler, sadece zorunlu hallerde kullanılır. Varsayılan `Non-Null`'dır.
*   **Durum Güvenliği:** UI, tek bir "Gerçeklik Kaynağı"ndan (Single Source of Truth) beslenir. `State` değişimi sadece `ViewModel` üzerinden olur.

## 4. CHANGE-MANAGEMENT LAW (DEĞİŞİM YÖNETİMİ)

Büyük şirketlerdeki gibi, her değişiklik bir "Paket" olarak yönetilir:
*   **Change Request (CR):** Değişikliğin tanımı ve gerekçesi.
*   **Impact Analysis:** Neleri etkileyeceği.
*   **Approval Gate:** Kimlerin onaylaması gerektiği.
*   **Execution:** İcra.
*   **Verification:** Doğrulama.

Bu paket tamamlanmadan "Merge" yapılamaz.

---
**OPERASYONEL KARŞILIK:** `scripts/pre_flight_check.sh`
**FAZ GEÇİŞ ŞARTI:** Pre-Flight onayı alınmadan faz geçilemez.
