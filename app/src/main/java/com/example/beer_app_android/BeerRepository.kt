package com.example.beer_app_android

class BeerRepository(private val apiInterface: BeersApiInterface) : BaseRepository() {
    suspend fun getBeer() : Beer? {
        return safeApiCall(
            //await the result of deferred type
            call = {apiInterface.getBeerAsync(1).await()},
            error = "Error fetching beer"
        )
    }
}