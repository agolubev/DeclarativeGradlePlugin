plugins {
     id("declarative-plugin-module-conventions")
    `maven-publish`
    `java-gradle-plugin`
    kotlin("jvm") version "2.0.0"
}


gradlePlugin {
    plugins {
        create("comAndroidDeclarativeSettings") {
            id = "com.android.internal.settings-declarative"
            version = "0.1"
            implementationClass = "com.android.declarative.settings.internal.SettingsDeclarativePlugin"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}