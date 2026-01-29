plugins {
    `kotlin-dsl`
}

group = "com.patidost.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "patidost.android.application"
            implementationClass = "com.patidost.convention.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "patidost.android.library"
            implementationClass = "com.patidost.convention.AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "patidost.android.hilt"
            implementationClass = "com.patidost.convention.AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "patidost.android.room"
            implementationClass = "com.patidost.convention.AndroidRoomConventionPlugin"
        }
        register("androidCompose") {
            id = "patidost.android.compose"
            implementationClass = "com.patidost.convention.AndroidComposeConventionPlugin"
        }
    }
}
