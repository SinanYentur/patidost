import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.withPlugin("com.android.library") {
                val extension = extensions.getByName("android") as CommonExtension<*, *, *, *, *, *>
                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

                extension.apply {
                    buildFeatures {
                        compose = true
                    }
                    composeOptions {
                        kotlinCompilerExtensionVersion = "1.5.11"
                    }
                }

                dependencies {
                    val bom = libs.findLibrary("androidx.compose.bom").get()
                    add("implementation", platform(bom))
                    add("androidTestImplementation", platform(bom))

                    add("implementation", libs.findLibrary("androidx-ui").get())
                    add("implementation", libs.findLibrary("androidx-ui-graphics").get())
                    add("implementation", libs.findLibrary("androidx-ui-tooling-preview").get())
                    add("implementation", libs.findLibrary("androidx-material3").get())
                    add("debugImplementation", libs.findLibrary("androidx-ui-tooling").get())
                    
                    // ANAYASAL EKLEME: İkonlar için.
                    add("implementation", libs.findLibrary("androidx.material.icons.extended").get())
                }
            }
        }
    }
}
