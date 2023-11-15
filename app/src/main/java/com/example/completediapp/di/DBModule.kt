package com.example.completediapp.di

import android.content.Context
import androidx.room.Room
import com.example.completediapp.db.QuotesDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {
    @Singleton
    @Provides
    fun getQuotesDB(context: Context): QuotesDB {
        return Room.databaseBuilder(context, QuotesDB::class.java, "quotesDB").build()
    }
}