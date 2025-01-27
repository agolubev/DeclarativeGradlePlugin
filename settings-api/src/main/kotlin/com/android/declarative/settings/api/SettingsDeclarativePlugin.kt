package com.android.declarative.settings.api

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class SettingsDeclarativePlugin: Plugin<Settings> {
    override fun apply(settings: Settings) {
        settings.apply(mapOf("plugin" to "com.android.internal.settings-declarative"))
    }
}