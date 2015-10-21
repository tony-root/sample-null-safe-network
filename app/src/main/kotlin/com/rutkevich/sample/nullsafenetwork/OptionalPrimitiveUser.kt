package com.rutkevich.sample.nullsafenetwork

import com.google.gson.JsonParseException

data class OptionalPrimitiveUser(
        val id: String,
        val name: String?,
        val surname: String?,
        private val _age: Int?
) {

    val age: Int
        get() = _age!!

    @Suppress("SENSELESS_COMPARISON")
    fun validate() {
        if (id == null) throw JsonParseException("'id' is null!")
        if (_age == null) throw JsonParseException("'age' is null!")
    }
}
