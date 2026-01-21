# KANIT RAPORU: KAPSAMLI MÜHENDİSLİK DOKTRİNLERİ

**PROTOKOL ID:** ANAYASA-PROTOKOL: ÖZ-DENETİM-VE-YIKIM
**KANIT ID:** E-EVOLUTION-005
**TARİH:** 2026-05-24T16:00:00Z

## 1. Gerekçe: Nihai Kapsam

`E-EVOLUTION-004` kanıtının, üst düzey felsefeleri tanıttığı ancak bunları oluşturan alt disiplinleri, rakip metodolojileri ve operasyonel çerçeveleri tam olarak kapsamadığı tespit edilmiştir. Bu doktrin, sistemin (AI Asistan) bilgi temelini, endüstrinin tüm katmanlarını içerecek şekilde genişletir ve önceki tüm mühendislik kanıtlarını geçersiz kılar.

## 2. Sentezlenen Mühendislik Doktrinleri

#### **Kısım A: Proje Yönetim ve Süreç Metodolojileri**

*   **1. Agile (Çevik) Ailesi:**
    *   **Scrum:** Projeyi "Sprint" adı verilen kısa, zaman kutulu (time-boxed) döngülere böler. `Product Backlog`, `Sprint Backlog`, `Daily Stand-up`, `Sprint Review`, `Retrospective` gibi ritüelleri vardır. Roller nettir: `Product Owner`, `Scrum Master`, `Development Team`.
    *   **Kanban:** İşi görsel bir tahta (`Kanban Board`) üzerinde "Yapılacak", "Yapılıyor", "Tamamlandı" gibi adımlarla akıtır. Temel metrik, "Work in Progress" (WIP) limitidir. Amacı, iş akışını optimize etmek ve darboğazları tespit etmektir. Ritüel zorunluluğu yoktur.
    *   **Extreme Programming (XP):** Kod kalitesini ve geliştirici refahını en üst düzeye çıkarmayı hedefleyen Çevik bir pratiktir. `Pair Programming`, `Test-Driven Development (TDD)`, `Continuous Integration (CI)`, `Simple Design` ve sık sık küçük sürümler (small releases) yapma gibi pratikleri içerir.

*   **2. Geleneksel Metodoloji:**
    *   **Waterfall (Şelale):** Her aşamanın (Gereksinim, Tasarım, Geliştirme, Test, Dağıtım) bir öncekinin tamamen bitmesini beklediği, doğrusal ve sıralı bir modeldir. Değişime kapalıdır, ancak gereksinimlerin baştan çok net olduğu projelerde öngörülebilirlik sağlar.

#### **Kısım B: Mimari ve Tasarım Paradigmları**

*   **1. Makro Mimariler (Sistem Düzeyi):**
    *   **Monolithic (Tek Parça):** Tüm uygulama işlevselliğinin tek bir dağıtılabilir birim içinde yer aldığı mimari. Başlangıçta geliştirmesi basittir ancak büyüdükçe karmaşıklaşır ve ölçeklenmesi zordur.
    *   **Microservices (Mikroservisler):** Uygulamayı, her biri kendi iş alanından sorumlu, bağımsız olarak dağıtılabilen küçük servislere bölen mimari. Teknolojik çeşitliliğe, esnekliğe ve bağımsız ölçeklendirmeye olanak tanır. İletişim, ağ üzerinden (genellikle HTTP/gRPC) yapılır.
    *   **Service-Oriented Architecture (SOA - Servis Odaklı Mimari):** Mikroservislerin öncülüdür. Servisleri yeniden kullanılabilir iş fonksiyonları olarak görür ve genellikle bir `Enterprise Service Bus (ESB)` üzerinden iletişim kurmalarını sağlar. Mikroservislere göre daha gevşek bağlı (loosely coupled) ama daha az bağımsızdır (less autonomous).
    *   **Serverless (Sunucusuz):** Geliştiricinin sunucu yönetimiyle hiç ilgilenmediği, altyapının bulut sağlayıcı tarafından yönetildiği bir model. Kod, olaylarla tetiklenen fonksiyonlar (`Function-as-a-Service - FaaS`) olarak çalışır. Kullandıkça öde modeliyle maliyet optimizasyonu sağlar.

*   **2. Mezo Mimariler (Uygulama İçi Katmanlaşma):**
    *   **Clean Architecture (Temiz Mimari):** Bu projenin temel aldığı mimari. Bağımlılıkların merkezdeki iş kurallarına (Entities, Use Cases) doğru tek yönlü akmasını sağlar. UI, veritabanı gibi dış detayların kolayca değiştirilebilmesini hedefler.
    *   **Layered Architecture (n-Tier):** Klasik `Presentation` (UI), `Business Logic` (İş Mantığı) ve `Data Access` (Veri Erişimi) katmanlarından oluşan mimari. Temiz Mimari'den farkı, bağımlılık kurallarının daha az katı olmasıdır.

*   **3. Mikro Mimariler (Kod Düzeyi İlkeler):**
    *   **SOLID:**
        *   **S**ingle Responsibility Principle: Her sınıf/modülün sadece bir sorumluluğu olmalı.
        *   **O**pen/Closed Principle: Kod, genişletmeye açık ama değiştirmeye kapalı olmalı.
        *   **L**iskov Substitution Principle: Alt sınıflar, üst sınıfların yerine geçebilmeli.
        *   **I**nterface Segregation Principle: Kapsamlı tek bir arayüz yerine, amaca özel birden çok küçük arayüz kullanılmalı.
        *   **D**ependency Inversion Principle: Üst seviye modüller, alt seviye modüllere değil; her ikisi de soyutlamalara (arayüzlere) bağlı olmalı.
    *   **Composition over Inheritance (Kalıtım Yerine Kompozisyon):** Davranışları yeniden kullanmak için sınıfları kalıtım yoluyla genişletmek yerine, bağımsız davranışları bir araya getirerek (kompozisyon) daha esnek yapılar kurma ilkesi.

#### **Kısım C: Operasyonel ve Kalite Doktrinleri**

*   **1. Sürüm ve İş Akışı Yönetimi:**
    *   **GitFlow:** `master` ve `develop` olmak üzere iki ana dala sahip, yeni özellikler için `feature/*`, sürümler için `release/*` ve acil düzeltmeler için `hotfix/*` dallarını kullanan karmaşık ama düzenli bir iş akışı modelidir.
    *   **Trunk-Based Development:** Tüm geliştiricilerin `trunk` (ana dal) adı verilen tek bir dal üzerinde çalıştığı model. Değişiklikler küçük parçalar halinde ve sık sık ana dala entegre edilir. CI/CD ve `Feature Flags` (özellik bayrakları) ile birlikte kullanılır.

*   **2. Kalite Güvencesi:**
    *   **Test-Driven Development (TDD):** "Red-Green-Refactor" döngüsü. Önce başarısız olan bir test yaz, sonra testi geçecek en basit kodu yaz, sonra kodu iyileştir.
    *   **Behavior-Driven Development (BDD):** TDD'nin bir uzantısıdır. Testleri, "Given-When-Then" formatında, teknik olmayan paydaşların da anlayabileceği doğal bir dilde yazar. Uygulamanın "davranışını" tanımlamaya odaklanır.

*   **3. Operasyonel Mükemmellik:**
    *   **DevOps:** Geliştirme (Dev) ve Operasyon (Ops) ekiplerinin, otomasyon ve işbirliği kültürüyle birleşerek yazılımı daha hızlı ve güvenilir bir şekilde teslim etmesini sağlayan bir felsefedir. CI/CD bu kültürün temel pratiğidir.
    *   **Site Reliability Engineering (SRE):** Google tarafından geliştirilen, operasyonel görevleri yazılım mühendisliği prensipleriyle ele alan bir disiplindir. `Service Level Objectives (SLO)`, `Error Budgets` gibi metriklerle sistemin güvenilirliğini yönetir. Amacı, DevOps felsefesini somut pratiklerle uygulamaktır.

## 3. Nihai Hüküm

Bu doktrin, sistemin (AI Asistan) bilgi temelinin mevcut en kapsamlı halidir. Davranış modeli, artık sadece neyin yapılacağını değil, aynı zamanda görevin niteliğine göre **hangi metodolojinin (örn: Scrum vs. Kanban), hangi mimarinin (örn: Monolith vs. Microservice) ve hangi operasyonel modelin (örn: GitFlow vs. Trunk-Based) daha uygun olacağını analiz edip önermeyi** de içerir. Bu, "mantıklı mühendis" tanımının en üst seviyesidir.
