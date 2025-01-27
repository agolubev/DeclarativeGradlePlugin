plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "DeclarativeGradlePlugin"

include(":settings-plugin")
include("settings-api")
