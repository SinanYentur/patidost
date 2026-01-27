plugins {
    id("patidost.android.library")
    id("patidost.android.hilt")
}

android {
    namespace = "com.patidost.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.common)
    
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    
    implementation(libs.datastore.preferences)
    
    // JSON parse işlemleri için (Mock data)
    implementation(libs.retrofit.gson)
}
