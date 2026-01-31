class CoreConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")
            pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

            extensions.configure<LibraryExtension> {
                compileSdk = 35
                defaultConfig {
                    minSdk = 24
                    targetSdk = 35
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
                buildFeatures {
                    compose = true
                }
            }
            extensions.configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    jvmTarget = JvmTarget.JVM_11
                }
            }

            dependencies {
                add("implementation", platform(library("androidx.compose.bom")))
                add("implementation", library("androidx.material3"))

                add("implementation", project(":core:analytics"))
            }
        }
    }
}

fun Project.library(alias: String) =
    extensions.getByType(VersionCatalogsExtension::class.java).named("libs").findLibrary(alias)
        .get()