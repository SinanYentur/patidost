plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // Fault-Tolerant: Direct dependencies to avoid circular logic
    implementation("com.android.tools.build:gradle:8.5.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.9.23-1.0.20")
    implementation("androidx.room:room-gradle-plugin:2.6.1")
}

// gradlePlugin bloğu kaldırıldı çünkü resources/META-INF altında manuel dosyalar var.
