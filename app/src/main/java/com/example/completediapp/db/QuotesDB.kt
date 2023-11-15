package com.example.completediapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.completediapp.models.Quote

@Database(entities = [Quote::class], version = 1)
@TypeConverters(value = [Convertors::class])
abstract class QuotesDB : RoomDatabase(){
    abstract fun quotesDao() : QuoteDao
}