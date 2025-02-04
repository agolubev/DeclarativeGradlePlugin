## PLUGIN

This is a settings plugin to include or exclude modules from a Gradle build.
Such inclusion will help user to focus only on modules that are under
changes. Studio Focus plugin will use it for development and demo purposes.

Plugin itself is a simplified version of past Gradle declarative 
experiment https://github.com/jdochez/gradle-declarative/tree/main/settings-api
Current version has module dependency resolution. It
parses modules `build.gradle.dcl` files to find dependent modules it needs to include.

## Steps to try

To try plugin and include it into declarative project you need to:
1. Build plugin to local maven repository

```
./gradlew publishToMavenLocal

```
2. Include it into declarative build. Add declaration to `settings.gradle.dcl` file

```
plugins {
    id("com.android.experiments.declarative.settings").version("0.1")
}
```

3. Add local repository declaration to setting file 
```
pluginManagement {
    repositories {
        maven {
            url = uri("file:/Users/<username>/.m2/repository")
        }
    }
}

``` 
4. Add modules list you want to include in `lazyIncludes` block into settings
```
lazyIncludes {
    focusedModules = ":app,:app2"
}
```

## Test Application
`testApplication` folder has application you may want to try.
You need to adjust multiple repository declarations in `settings.gradle.dcl` file 
for your local environment. 

Test application includes `app` and `app2` modules in Gradle build by default.
Also, `app` has dependency to `mylibrary2` module so plugin includes it into build as well.


