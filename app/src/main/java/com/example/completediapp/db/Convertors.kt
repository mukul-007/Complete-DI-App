package com.example.completediapp.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Convertors {

    @TypeConverter
    fun fromListToString(value: List<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromStringToList(value: String): List<String> {
        if (value == "[]") {
            return listOf()
        }
        if (value.split(",").size == 1) {
            return listOf(value)
        }

        return Gson().fromJson(value, object : TypeToken<List<String>>() {}.type)
    }
}