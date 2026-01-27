plugins {
    id("patidost.android.library")
    id("patidost.android.compose")
    id("patidost.android.hilt")
}

android {
    namespace = "com.patidost.feature.pet_detail"
}

dependencies {
    api(project(":core:domain"))
    implementation(project(":core:ui"))
    implementation(project(":core:common"))
}
