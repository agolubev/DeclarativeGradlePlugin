
androidApp {
    compileOptions {
    }
     //sourceCompatibility = VERSION_15

    buildTypes {
        buildType("type1") {
        }
    }
    namespace = "org.gradle.experimental.android.app"
    buildTypes {
    }

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {

        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "MY_FIELD", """ "myValue" """)
        buildConfigField("String", "MY_FIELD", "\"myValue\"")
        buildConfigField("Integer", "MY_FIELD", "0")
    }

    buildTypes {

      buildType("dsfsdf"){ isMinifyEnabled = true }
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }

    dependenciesDcl {
        implementation(project(":mylibrary2"))

        implementation("org.apache.commons:commons-lang3:3.12.0")
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
        implementation("com.google.guava:guava:33.1.0-jre")

        testImplementation("junit:junit:4.13.1")

        androidTestImplementation("androidx.test:runner:1.4.0-alpha06")
        androidTestImplementation("androidx.test:rules:1.4.0-alpha06")
        androidTestImplementation("androidx.test.ext:junit:1.1.2")
        androidTestImplementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
    }
}


