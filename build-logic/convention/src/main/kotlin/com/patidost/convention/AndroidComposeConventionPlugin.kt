package com.patidost.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType(CommonExtension::class.java)
            extension.apply {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.8"
                }

                dependencies {
                    val bom = libs.findLibrary("androidx-compose-bom").get()
                    "implementation"(platform(bom))
                    "androidTestImplementation"(platform(bom))
                    "implementation"(libs.findLibrary("androidx.ui").get())
                    "implementation"(libs.findLibrary("androidx.ui.graphics").get())
                    "implementation"(libs.findLibrary("androidx.ui.tooling.preview").get())
                    "implementation"(libs.findLibrary("androidx.material3").get())
                    "debugImplementation"(libs.findLibrary("androidx.ui.tooling").get())
                    "debugImplementation"(libs.findLibrary("androidx.ui.test.manifest").get())
                }
            }
        }
    }
}
