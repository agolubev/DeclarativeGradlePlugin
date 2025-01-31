package com.example.myapplication

import com.google.common.collect.ImmutableSet
import org.apache.commons.lang3.StringUtils.capitalize

class DebugExample {

    fun getPeople(): ImmutableSet<String> {
        return ImmutableSet.of(
            capitalize("adam johnson"),
            capitalize("bob smith"),
            capitalize("carl jones")
        )
    }
}
