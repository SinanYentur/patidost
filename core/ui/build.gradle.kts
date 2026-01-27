plugins {
    id("patidost.android.library")
    id("patidost.android.compose")
}

android {
    namespace = "com.patidost.core.ui"
}

dependencies {
    implementation(project(":core:common"))
    implementation(libs.androidx.core.ktx) // WindowCompat için
}
