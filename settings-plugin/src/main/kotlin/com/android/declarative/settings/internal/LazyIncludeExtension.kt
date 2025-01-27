package com.android.declarative.settings.internal

import org.gradle.api.initialization.Settings
import org.gradle.declarative.dsl.model.annotations.Restricted
import javax.inject.Inject


abstract class LazyIncludeExtension @Inject constructor(
    private val settings: Settings
) {

    inner class MyList<String> : ArrayList<String>() {
        override fun add(element: String): Boolean {
            settings.include(element.toString())
            settings.include()
            return super.add(element)
        }
    }

    val myBool: Boolean = true
    private val _focusedModules: MutableList<String> = MyList()

    @get:Restricted
    val focusedModules:MutableList<String> = MyList()
}