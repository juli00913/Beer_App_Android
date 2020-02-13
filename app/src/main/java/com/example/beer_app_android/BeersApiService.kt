package com.example.beer_app_android

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object BeersApiService {

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val apiClient = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(apiClient)
        .baseUrl(" http://34.245.99.203L8080/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val beersApi = retrofit().create(BeersApiInterface::class.java)
}