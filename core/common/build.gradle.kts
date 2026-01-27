plugins {
    id("patidost.android.library")
    id("patidost.android.hilt")
}

android {
    namespace = "com.patidost.core.common"
}

dependencies {
    // Ortak kullanılan kütüphaneler buraya eklenebilir
    implementation(libs.coroutines.android)
}
