package com.rutkevich.sample.nullsafenetwork

import com.google.gson.JsonParseException

data class ReflectionReadyUser(
        val id: String,
        val name: String?,
        val surname: String?,
        val age: Int?
) {
    @Suppress("SENSELESS_COMPARISON")
    fun validate() {
        if (id == null) throw JsonParseException("'id' is null!")
    }
}
