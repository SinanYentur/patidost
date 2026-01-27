plugins {
    id("patidost.android.library")
    id("patidost.android.hilt")
}

android {
    namespace = "com.patidost.app.feature.economy"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core:ui"))
    implementation(project(":domain"))

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.hilt.navigation.compose)
}
