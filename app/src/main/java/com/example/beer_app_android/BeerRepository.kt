package com.example.beer_app_android

class BeerRepository(private val apiInterface: BeersApiInterface) : BaseRepository() {
    suspend fun getBeer() : Beer? {
        return safeApiCall(
            //await the result of deferred type
            call = {apiInterface.getBeerAsync(1).await()},
            error = "Error fetching a beer"
        )
    }

    suspend fun postBeer(beer : Beer) {
        safeApiCall(
            call = {apiInterface.postBeerAsync(beer).await()},
            error = "Error posting a beer"
        )
    }

    suspend fun getListOfBeers() : List<Beer>? {
        return safeApiCall(
            call = {apiInterface.getListAsync().await()},
            error = "Error fetching a list of beers"
        )
    }
}