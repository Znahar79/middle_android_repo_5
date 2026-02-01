import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.7.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
}

gradlePlugin {
    plugins {
        register("core") {
            id = libs.plugins.myproject.android.core.get().pluginId
            implementationClass = "CoreConventionPlugin"
        }
    }
}