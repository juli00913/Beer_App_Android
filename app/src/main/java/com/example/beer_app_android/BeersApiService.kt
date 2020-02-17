package com.example.beer_app_android

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BeersApiService {

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val apiClient = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(apiClient)
        .baseUrl(" http://34.245.99.203:8080/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val beersApi = retrofit().create(BeersApiInterface::class.java)
}