import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.api.JavaVersion

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                compileSdk = 34
                
                defaultConfig {
                    minSdk = 26
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
                
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                
                tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = "17"
                    }
                }

                buildFeatures {
                    compose = true
                }
                
                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
                }

                dependencies {
                    val bom = libs.findLibrary("androidx.compose.bom").get()
                    add("implementation", platform(bom))
                    add("androidTestImplementation", platform(bom))

                    // ANAYASAL ONARIM: implementation -> api
                    // Bu, modülün arayüzünün (Composable ekranlar) dışarıya görünür olmasını sağlar.
                    add("api", libs.findLibrary("androidx.ui").get())
                    add("api", libs.findLibrary("androidx.ui.graphics").get())
                    add("api", libs.findLibrary("androidx.ui.tooling.preview").get())
                    add("api", libs.findLibrary("androidx.material3").get())
                    add("api", libs.findLibrary("androidx.material.icons.extended").get())
                    add("debugImplementation", libs.findLibrary("androidx.ui.tooling").get())
                }
            }
        }
    }
}
