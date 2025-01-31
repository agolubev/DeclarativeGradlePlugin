package com.android.declarative.settings.internal

import java.io.File

class DclFileParser {
    public fun parseModuleDependencies(file: File): List<String> {
        val result = mutableListOf<String>()
        val content = file.inputStream().readBytes().toString(Charsets.UTF_8)
        val dependencyRegexp = "project[\\w]*\\([\\w]*\"([a-zA-Z0-9:_-]+)\"[\\w]*\\)".toRegex()
        for(match in dependencyRegexp.findAll(content)) {
           match.groups[1]?.value?.let{
                result.add(it.removePrefix(":"))
            }
        }
        return result
    }

}