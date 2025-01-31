package com.android.declarative.settings.internal

import org.gradle.api.initialization.Settings
import org.gradle.declarative.dsl.model.annotations.Restricted
import java.io.File
import javax.inject.Inject

@Restricted
abstract class LazyIncludeExtension @Inject constructor(
    private val settings: Settings
) {

    inner class MyList<String> : ArrayList<String>() {
        override fun add(element: String): Boolean {
            addToSettings(element.toString())
            return super.add(element)
        }
    }

    val myBool: Boolean = true
    private val _focusedModules: MutableList<String> = MyList()

    @get:Restricted
    var focusedModules: String = ""
        set(value) {
            value.split(",").forEach {
                addToSettings(it)
            }
        }

    private fun addToSettings(moduleName: String) {
        val pureName = moduleName.removePrefix(":")
        val dependentModules = DclFileParser().parseModuleDependencies(
            File(pureName.replace(":", File.separator) + File.separator + "build.gradle.dcl")
        )
        dependentModules.forEach { settings.include(it) }
        settings.include(pureName)
    }
}