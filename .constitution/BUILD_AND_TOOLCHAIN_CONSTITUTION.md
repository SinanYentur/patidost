# ANAYASA: FAZ-1 (BUILD & TOOLCHAIN MUTLAK STABİLİTE SÖZLEŞMESİ)

**ANAYASAL KİMLİK BLOĞU**
---
- **MERKEZ ANAYASA:** OMEGA_CODEX_V1.md
- **ÜST DAYANAK:** COMPANY_CONSTITUTION.md, ANAYASAL_EK_PROTOKOL.md
- **NORM TÜRÜ:** Uygulama Anayasası (Lex Operativa)
- **BAĞLI OLDUĞU MADDELER:** OMEGA_CODEX §7, COMPANY_CONSTITUTION §11
- **GEÇERLİ FAZLAR:** Tüm Fazlar (Özellikle FAZ-1 ve KRİZ-RESTORASYON)
- **BAĞLADIĞI ROLLER:** DevOps/SRE Governor, Android Studio AI, Denetçiler
- **DEĞİŞTİRİLEBİLİRLİK STATÜSÜ:** Protokolle Değişir

---

## BÖLÜM 1: GRADLE WRAPPER SABİTLEME HUKUKU

*   **Madde 1.1 (Tekillik):** Projede, `gradle/wrapper/gradle-wrapper.properties` dosyasında tanımlanan tek bir Gradle versiyonu kullanılır. Her geliştirici ve CI ortamı bu versiyonu kullanmak zorundadır.
*   **Madde 1.2 (Bütünlük Kilidi):** `gradle-wrapper.properties` ve `gradlew` script'lerinin `checksum`'ı, `.constitution/.checksum` dosyası içinde takip edilir. Bu dosyalarda yapılacak her değişiklik, anayasal bir olaydır ve `CHANGE_IMPACT.md` belgesi gerektirir.
*   **Kriz Senaryosu:** Dış dünyadan gelen veya manuel olarak yapılan bir Gradle sürüm değişikliği, `verify_constitution_checksum.sh` tarafından tespit edilir ve build'i anayasal olarak bloke eder.

## BÖLÜM 2: JDK & TOOLCHAIN KİLİDİ

*   **Madde 2.1 (Tanım):** Projenin derlenmesi için kullanılacak JDK versiyonu, projenin kök `build.gradle.kts` dosyasında `java.toolchain` bloğu içinde merkezi olarak tanımlanır ve kilitlenir.
*   **Madde 2.2 (Kanıt):** Her CI derlemesinin başında, kullanılan `java -version` çıktısı loglanır ve anayasal toolchain tanımıyla eşleştiği doğrulanır. Uyumsuzluk, build'i durdurur.

## BÖLÜM 3: DEPENDENCY SNAPSHOT ARŞİVİ

*   **Madde 3.1 (Zorunlu Kayıt):** Her başarılı `release` derlemesinden sonra, `./gradlew :app:dependencies` komutunun çıktısı, versiyon numarası ile etiketlenerek `.dna/evidence/dependency_snapshots/` klasörü altına kaydedilir.
*   **Madde 3.2 (Anayasal Kanıt):** Bu anlık görüntü, bir "transitive dependency zehirlenmesi" veya beklenmedik bir kütüphane güncellemesi durumunda, sistemin o anki "sağlıklı" bağımlılık ağacının ne olduğunu gösteren hukuki kanıt olarak kullanılır.

## BÖLÜM 4: TEKRAR ÜRETİLEBİLİR BUILD (REPRODUCIBLE BUILD) KANITI

*   **Madde 4.1 (Hedef):** Aynı `git commit` hash'ine sahip kod, farklı ortamlarda (lokal, CI) derlendiğinde, bit-düzeyinde aynı APK/AAB dosyasını üretmelidir.
*   **Madde 4.2 (Kanıt Zinciri):** Her `release` AAB dosyasının `SHA256` hash'i, `.build-proof/hashes.log` dosyasına, commit hash'i ile birlikte kaydedilir.
*   **Madde 4.3 (Denetim):** Periyodik olarak çalıştırılan bir CI görevi, aynı commit'i farklı bir `runner` üzerinde tekrar derleyerek, üretilen hash'in kayıtlı hash ile eşleştiğini doğrular. Uyumsuzluk, "ANAYASAL GÜVEN KRİZİ" olarak raporlanır.

---

**YÜRÜRLÜK:** Bu belgenin onaylanması, FAZ-1'in eksik anayasal kilitlerinin tamamlanması için ilk adımdır. Bu kuralları uygulayacak teknik mekanizmaların (script'ler, Gradle görevleri) oluşturulması, bir sonraki icra adımı olacaktır.
