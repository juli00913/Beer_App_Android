package com.example.beer_app_android

import com.google.gson.JsonObject

class BeerRepository(private val apiInterface: BeersApiInterface) : BaseRepository() {
    suspend fun getBeer() : Beer? {
        return safeApiCall(
            //await the result of deferred type
            call = {apiInterface.getBeerAsync(1).await()},
            error = "Error fetching a beer"
        )
    }

    suspend fun postBeer(beer : JsonObject) {
        safeApiCall(
            call = {apiInterface.postBeerAsync(beer).await()},
            error = "Error posting a beer"
        )
    }
}