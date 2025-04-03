## PLUGIN

This is a settings plugin to include or exclude modules from a Gradle build.
Such inclusion will help user to focus only on modules that are under
changes. Studio Focus plugin will use it for development and demo purposes.

Plugin itself is a simplified version of past Gradle declarative 
experiment https://github.com/jdochez/gradle-declarative/tree/main/settings-api
Current version has module dependency resolution. It
parses `focus.properties` to find out all and focused modules modules

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

5. Add modules list and focused in `focus.properties`. For example:

```
allModules=app,app2,mylibrary2
focus=app,app2,mylibrary2
```

5. To see that focused modules are included in Gradle build type in command line

```
./gradlew -q projects
```

## Test Application
`testApplication` folder has application you may want to try.

## Studio Experience
You can also open `testApplicaiton` in nightly build and see Focus Studio
plugin. You need set `gradle.declarative.focus.feature` registry property to true



