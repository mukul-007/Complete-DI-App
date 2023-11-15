package com.example.completediapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.completediapp.models.Quote
@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quotes: List<Quote>)
    @Query("Select * from Quotes")
    suspend fun getQuotes() : List<Quote>
}