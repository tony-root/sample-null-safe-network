package com.rutkevich.sample.nullsafenetwork

data class NaiveUser(
        val id: String,
        val name: String?,
        val surname: String?,
        private val _age: Int?
)
