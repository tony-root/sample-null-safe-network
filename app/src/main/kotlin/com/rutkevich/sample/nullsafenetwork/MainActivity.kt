package com.rutkevich.sample.nullsafenetwork

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.google.gson.Gson
import java.io.IOException

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar) as Toolbar)

        parseNaiveUser()
        naiveUserFailsWithInvalidJson()
        reflectionReadyUserFailsAtParseTime()
        parseOptionalPrimitiveUser()
    }

    fun parseNaiveUser() {
        val response =
                """{
                  "id": "some.email@example.com",
                  "name": "John",
                  "surname" : "Smith",
                  "age": 42
                }
                """
        val user: NaiveUser = Gson().fromJson(response, NaiveUser::class.java)
        Log.d("TAG", "User: $user")

        val idLength: Int = user.id.length()
        val nameLength : Int? = user.name?.length()
    }

    fun naiveUserFailsWithInvalidJson() {
        val invalid =
                """{
                  "name": "John"
                }
                """

        val user: NaiveUser = Gson().fromJson(invalid, NaiveUser::class.java)
        val idLength = user.id.length() // will throw NPE
    }

    fun reflectionReadyUserFailsAtParseTime() {
        val invalid =
                """{
                  "name": "John"
                }
                """

        // We should integrate validation into deserialization process
        try {
            val user: ReflectionReadyUser = Gson().fromJson(invalid, ReflectionReadyUser::class.java)
            user.validate()
        } catch (e: IOException) {

        }
    }

    private fun parseOptionalPrimitiveUser() {
        val response =
                """{
                  "id": "some.email@example.com",
                  "name": "John",
                  "surname" : "Smith",
                  "age": 42
                }
                """

        try {
            val user: OptionalPrimitiveUser = Gson().fromJson(response, OptionalPrimitiveUser::class.java)
            user.validate()
            val isUserAdult: Boolean = user.age > 18
        } catch (e: IOException) {

        }
    }

}
