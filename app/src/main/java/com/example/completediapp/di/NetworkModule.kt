package com.example.completediapp.di

import com.example.completediapp.retrofit.QuotesAPI
import com.example.completediapp.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getQuotesAPI(retrofit: Retrofit): QuotesAPI{
        return retrofit.create(QuotesAPI::class.java)
    }
}