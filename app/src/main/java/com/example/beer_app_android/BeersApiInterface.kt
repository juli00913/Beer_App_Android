package com.example.beer_app_android

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BeersApiInterface {

    @GET("beer/{id}")
    fun getBeerAsync(@Path("id") id:Int): Deferred<Response<Beer>>

    @POST("beer/")
    fun postBeerAsync(@Body beer: Beer): Deferred<Response<Beer>>

    @GET("list/beer/")
    fun getListAsync(): Deferred<Response<List<Beer>>>
}
