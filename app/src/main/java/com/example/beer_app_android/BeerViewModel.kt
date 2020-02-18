package com.example.beer_app_android

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class BeerViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val beerRepository : BeerRepository = BeerRepository(BeersApiService.beersApi)

    val beerLiveData = MutableLiveData<Beer>()

    private lateinit var jsonObject: JsonObject

    fun getBeer() {

        scope.launch {
            val beer = beerRepository.getBeer()
            beerLiveData.postValue(beer)
        }
    }

    fun postBeer(beer: Beer) {

        jsonObject = JsonObject()
        jsonObject.addProperty("name", beer.name)
        jsonObject.addProperty("beer_type", beer.beer_type)
        jsonObject.addProperty("description", beer.description)
        scope.launch {
            beerRepository.postBeer(jsonObject)
        }
    }
    fun cancelRequest() = coroutineContext.cancel()
}