package com.android.declarative.settings.internal

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.api.internal.plugins.software.SoftwareType
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject
import java.util.Properties
import java.io.FileInputStream
import java.io.File

class SettingsDeclarativePlugin @Inject constructor(
    val objects: ObjectFactory
): Plugin<Settings> {

    var settings:Settings? = null

    override fun apply(settings: Settings) {
        println(">>>>>>> SettingsDeclarativePlugin new version")
        this.settings = settings
        //val lazyIncludes = settings.extensions.create("lazyIncludes", LazyIncludeExtension::class.java, settings)

        val properties = Properties()
        FileInputStream(File("focus.properties")).use { input ->
            properties.load(input)
        }
        val modules = properties.get("focus").toString().split(",")
        modules.forEach { settings.include(
            if(it.startsWith(":")) it else ":$it"
        ) }
        //settings.include(":app2")

    }

    /*
     @SoftwareType(name = "lazyIncludes", modelPublicType = LazyIncludeExtension::class)
    fun getLazyIncludes(action: Action<LazyIncludeExtension>): LazyIncludeExtension =
        settings!!.extensions.create("lazyIncludes", LazyIncludeExtension::class.java, settings)

     */
}

