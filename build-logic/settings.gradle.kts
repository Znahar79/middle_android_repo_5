dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            val rootDir = gradle.settings.rootDir.parentFile
            val catalogFile = File(rootDir, "gradle/libs.versions.toml")

            if (catalogFile.exists()) {
                println("Catalog file found: ${catalogFile.absolutePath}")
                from(files(catalogFile))
            }
        }
    }
}

rootProject.name = "build-logic"
include(":convention")