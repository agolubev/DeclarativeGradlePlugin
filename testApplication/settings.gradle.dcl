pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("file:/Users/alexgolubev/src/studio-main/prebuilts/tools/common/m2/repository/")
        }
        maven {
            url = uri("file:/Users/alexgolubev/.m2/repository")
        }
        maven {
            url = uri("file:/Users/alexgolubev/src/studio-main/out/repo/")
        }
    }
}
plugins {
    id("com.android.ecosystem").version("8.10.0-dev")
    id("com.android.experiments.declarative.settings").version("0.1")
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("file:/Users/alexgolubev/src/studio-main/prebuilts/tools/common/m2/repository/")
        }
        maven {
            url = uri("file:/Users/alexgolubev/src/studio-main/out/repo/")
        }
    }
}

defaults {
    androidApp {
        compileSdk = 34

    }

    androidLibrary {
        compileSdk = 34
    }
}

rootProject.name = "My Application"
lazyIncludes {
    focusedModules = ":app,:app2"
}
