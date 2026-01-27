import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // Hem uygulama hem de kütüphane plugin'leri için çalışacak şekilde genişletildi
            pluginManager.withPlugin("com.android.application") {
                configureCompose(extensions.getByName("android") as CommonExtension<*, *, *, *, *, *>)
            }
            pluginManager.withPlugin("com.android.library") {
                configureCompose(extensions.getByName("android") as CommonExtension<*, *, *, *, *, *>)
            }
        }
    }

    private fun Project.configureCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        commonExtension.apply {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
            }
        }

        dependencies {
            val bom = libs.findLibrary("androidx.compose.bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))

            add("implementation", libs.findLibrary("androidx.ui").get())
            add("implementation", libs.findLibrary("androidx.ui.graphics").get())
            add("implementation", libs.findLibrary("androidx.ui.tooling.preview").get())
            add("implementation", libs.findLibrary("androidx.material3").get()) // Material 2
            add("implementation", libs.findLibrary("androidx.material3").get()) // Material 3
            add("implementation", libs.findLibrary("androidx.material.icons.extended").get())
            add("debugImplementation", libs.findLibrary("androidx.ui.tooling").get())
        }
    }
}
