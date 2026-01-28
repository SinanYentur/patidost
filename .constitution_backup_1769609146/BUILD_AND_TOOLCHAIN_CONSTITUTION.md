# ANAYASA: FAZ-1 (BUILD & TOOLCHAIN MUTLAK STABİLİTE SÖZLEŞMESİ)

**ANAYASAL KİMLİK BLOĞU**
---
- **ÜST DAYANAK:** CORE_CONSTITUTION.md
- **NORM TÜRÜ:** Uygulama Anayasası
- **ANAYASAL KAYIT ID:** FAZ1-001

---

## BÖLÜM 1: GRADLE VE TOOLCHAIN BÜTÜNLÜĞÜ

*   **Madde 1.1 (Tekillik):** Projede, `gradle/wrapper/gradle-wrapper.properties` ve kök `build.gradle.kts` içindeki `java.toolchain` ile tanımlanan tek bir Gradle ve JDK versiyonu kullanılır.
*   **Madde 1.2 (Bütünlük Kilidi):** Bu dosyaların bütünlüğü, `verify_constitution_checksum.sh` tarafından takip edilir.

## BÖLÜM 2: BAĞIMLILIK VE BUILD GÜVENİLİRLİĞİ

*   **Madde 2.1 (Dependency Snapshot):** Her `release` sonrası, `./gradlew :app:dependencies` çıktısı `.dna/evidence/dependency_snapshots/` altına kaydedilir.
*   **Madde 2.2 (Reproducible Build):** Aynı `commit` hash'i, farklı ortamlarda bit-düzeyinde aynı APK/AAB dosyasını üretmelidir. Kanıtı `.build-proof/hashes.log` dosyasıdır.
