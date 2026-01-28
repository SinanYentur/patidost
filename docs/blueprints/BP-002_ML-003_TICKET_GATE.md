# MEKANİK KİLİT TASARIM BELGESİ: BP-002 (ML-003: TICKET-DRIVEN CODE)

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** CORE_CONSTITUTION.md Madde 1.3 (Atomik Yaratılış)
- **KAPATILAN BOŞLUK:** ME-003 (Ticket Zorunluluğu)
- **AMAÇ:** "Ticket doğmaz → İş başlamaz" ilkesini mekanik olarak zorlamak.

---

## 1. TEHDİT MODELİ VE GEREKÇE

- **Tehdit:** Geliştiricilerin, bir iş takip sisteminde (Jira, GitHub Issues) tanımlanmamış, plansız veya "gölge" işler yaparak kod tabanına entegre etmesi.
- **Sonuç:** Proje yönetiminin şeffaflığını yitirmesi, kodun gerekçelendirilememesi ve "kurumsal hafıza" kaybı.
- **Çözüm:** Her `commit`, geçerli ve aktif bir bilete bağlanmak zorundadır.

## 2. MEKANİK MİMARİ VE İŞLEYİŞ

ML-003, mevcut `pre-commit-gatekeeper.sh` script'ine (yeni adıyla `commit-msg` hook) ek bir doğrulama adımı olarak entegre edilecektir.

**İşlem Akışı:**
1.  `commit-msg` hook tetiklenir.
2.  **ML-001 Kontrolü:** Mesajda `[ID-NO]` formatında bir referans var mı?
3.  **ML-002 Kontrolü:** Referans anayasal indekste var mı?
4.  **ML-003 Kontrolü (YENİ):**
    a. Commit mesajında `[PATI-XXX]` formatında bir bilet ID'si aranır.
    b. Bulunamazsa, `commit` **REDDEDİLİR**.
    c. (v2.0 Gelecek Planı): Bulunan bilet ID'si, `JIRA_API_TOKEN` ortam değişkeni kullanılarak Jira/GitHub API'sine sorgu atılır.
    d. (v2.0 Gelecek Planı): Biletin durumu "In Progress" veya "To Do" değilse, `commit` **REDDEDİLİR**.

## 3. BAĞLANTI PROTOKOLÜ (ML-001/002 ile İLİŞKİSİ)

ML-003, ML-001 ve ML-002'den **sonra** çalışır. Bir `commit`, hem anayasal bir gerekçeye (`[CORE-001]`) hem de operasyonel bir göreve (`[PATI-123]`) dayanmak zorundadır.

**Örnek Geçerli Commit Mesajı:**
`feat: [CORE-001] [PATI-123] Yeni anayasal bağ kilidi mekanizması eklendi`

## 4. FAIL-CASE SENARYOLARI (HATA DURUMLARI)

- **Bilet Numarası Yoksa:** ML-003, "ANAYASAL İHLAL (ML-003): Commit bir bilet numarası ([PATI-XXX]) içermelidir!" hatasıyla işlemi durdurur.
- **API Erişimi Yoksa (v2.0):** API anahtarı tanımsızsa veya network hatası olursa, kilit varsayılan olarak "güvenli" modda kalır ve `commit`'i **REDDEDER**.

---
**ONAY:** Bu blueprint onaylandığında, `scripts/commit-msg` dosyası bu yeni mantığı içerecek şekilde güncellenecektir.
