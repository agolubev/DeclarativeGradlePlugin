plugins {
    id("declarative-plugin-module-conventions")
    kotlin("jvm") version "2.0.0"
}

gradlePlugin {
    plugins {
        create("comAndroidDeclarativeSettings") {
            id = "com.android.experiments.declarative.settings"
            version = 0.1
            implementationClass = "com.android.declarative.settings.api.SettingsDeclarativePlugin"
        }
    }
}

dependencies {
    implementation(project(":settings-plugin"))
}
repositories {
    mavenCentral()
    google()
}