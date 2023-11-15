package com.example.completediapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.completediapp.db.QuoteDao
import com.example.completediapp.db.QuotesDB
import com.example.completediapp.models.Quote
import com.example.completediapp.retrofit.QuotesAPI
import retrofit2.Retrofit
import retrofit2.http.Query
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quotesAPI: QuotesAPI, private val quotesDB: QuotesDB) {

    private val mutableQuotes = MutableLiveData<List<Quote>>()
    val quotes : LiveData<List<Quote>>
        get() = mutableQuotes

    suspend fun getRandomQuotes(limit : Int){
        val result = quotesAPI.getRandomQuotes(limit)
        if(result.isSuccessful && result.body() != null) {
            quotesDB.quotesDao().insertQuote(result.body()!!)
            mutableQuotes.postValue(result.body())
        }
    }

    suspend fun insertQuotes(quotes : List<Quote>){

    }
}