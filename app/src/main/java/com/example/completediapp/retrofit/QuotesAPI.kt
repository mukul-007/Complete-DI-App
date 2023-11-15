package com.example.completediapp.retrofit

import com.example.completediapp.models.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {

    @GET("random?")
    suspend fun getRandomQuotes(@Query("limit") limit : Int) : Response<List<Quote>>
}