pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PatiDost"
include(":app")
include(":core:ui")
include(":core:data")
include(":core:domain")
include(":core:common")
include(":feature:auth")
include(":feature:discovery")
include(":feature:pet_detail")
include(":feature:profile")
