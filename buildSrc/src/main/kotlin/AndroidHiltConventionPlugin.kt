import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.dagger.hilt.android")
            // KSP ile Hilt kullanmak için 'kapt' yerine 'com.google.devtools.ksp' ekleyin
            pluginManager.apply("org.jetbrains.kotlin.kapt")
        }
    }
}
