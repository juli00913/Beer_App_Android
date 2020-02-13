package com.example.beer_app_android

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BeersApiInterface {

    @GET("beer/{id}")
    fun getBeerById(@Path("id") id:Int): Deferred<Response<Beer>>

}
