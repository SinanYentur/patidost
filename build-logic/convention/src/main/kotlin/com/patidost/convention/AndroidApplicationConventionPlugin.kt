package com.patidost.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.gradle.testing.jacoco.tasks.JacocoCoverageVerification
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("io.gitlab.arturbosch.detekt")
                apply("jacoco")
            }

            extensions.configure<ApplicationExtension> {
                compileSdk = 34

                defaultConfig {
                    minSdk = 26
                    targetSdk = 34
                    versionCode = 1
                    versionName = "1.0.0"
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables.useSupportLibrary = true
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                
                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
                
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        isShrinkResources = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }
            
            extensions.configure<DetektExtension> {
                config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
                buildUponDefaultConfig = true
            }

            extensions.configure<JacocoPluginExtension> {
                toolVersion = "0.8.11"
            }
            
            tasks.register("jacocoTestReport", JacocoReport::class.java) {
                dependsOn("testDebugUnitTest")
                reports {
                    xml.required.set(true)
                    html.required.set(true)
                }
                val debugTree = fileTree("$buildDir/tmp/kotlin-classes/debug") {
                    exclude(
                        "**/R.class", "**/R\$*.class", "**/BuildConfig.*", "**/Manifest*.*",
                        "**/*Test*.*", "android/**/*.*", "**/data/models/*",
                        "**/*Application.*", "**/*Activity.*"
                    )
                }
                val mainSrc = "$projectDir/src/main/java"
                sourceDirectories.setFrom(files(mainSrc))
                classDirectories.setFrom(files(debugTree))
                executionData.setFrom(fileTree(project.buildDir) {
                    include("jacoco/testDebugUnitTest.exec")
                })
            }

            tasks.register("jacocoTestCoverageVerification", JacocoCoverageVerification::class.java) {
                dependsOn("jacocoTestReport")
                val debugTree = fileTree("$buildDir/tmp/kotlin-classes/debug") {
                    exclude(
                        "**/R.class", "**/R\$*.class", "**/BuildConfig.*", "**/Manifest*.*",
                        "**/*Test*.*", "android/**/*.*", "**/*Application.*", "**/*Activity.*"
                    )
                }
                val mainSrc = "$projectDir/src/main/java"
                sourceDirectories.setFrom(files(mainSrc))
                classDirectories.setFrom(files(debugTree))
                executionData.setFrom(fileTree(project.buildDir) {
                    include("jacoco/testDebugUnitTest.exec")
                })
                violationRules {
                    rule {
                        limit {
                            counter = "LINE"
                            value = "COVEREDRATIO"
                            minimum = "0.80".toBigDecimal()
                        }
                    }
                }
            }

            tasks.named("check") {
                dependsOn("jacocoTestCoverageVerification")
            }
            
            dependencies {
                "testImplementation"(libs.findLibrary("junit").get())
                "testImplementation"(libs.findLibrary("mockk").get())
                "testImplementation"(libs.findLibrary("kotlinx.coroutines.test").get())
                "androidTestImplementation"(libs.findLibrary("androidx.junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx.espresso.core").get())
            }
        }
    }
}
