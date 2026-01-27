plugins {
    id("patidost.android.library")
    id("patidost.android.hilt")
}

android {
    namespace = "com.patidost.core.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:common"))
    
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    
    implementation(libs.datastore.preferences)
    implementation(libs.retrofit.gson)
}
