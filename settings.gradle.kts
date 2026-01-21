
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
include(":core")
include(":domain")
include(":data")

// Feature Modules
include(":feature:auth")
include(":feature:feed")
include(":feature:profile")
include(":feature:pet_detail")
include(":feature:discovery")
include(":feature:economy")
include(":feature:liked_pets") // ADDED
