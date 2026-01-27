plugins {
    id("patidost.android.application")
    id("patidost.android.compose")
    id("patidost.android.hilt")
}

android {
    namespace = "com.patidost.app"
    
    defaultConfig {
        applicationId = "com.patidost.app"
        versionCode = 1
        versionName = "1.0.0"
    }
}

dependencies {
    // Feature Modülleri
    implementation(project(":feature:auth"))
    implementation(project(":feature:discovery"))
    implementation(project(":feature:pet_detail"))
    implementation(project(":feature:profile"))
    
    // Core Modülleri
    implementation(project(":core:ui"))
    implementation(project(":core:data"))
    implementation(project(":core:common"))
    
    // Navigasyon
    implementation(libs.navigation.compose)
    
    // XML Temaları için Material Design (Denetçi Talebi)
    implementation(libs.material)
}
