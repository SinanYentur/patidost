plugins {
    `java-library`
    `kotlin`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(libs.coroutines.android)
    implementation("javax.inject:javax.inject:1") // Hilt/Dagger için
}
