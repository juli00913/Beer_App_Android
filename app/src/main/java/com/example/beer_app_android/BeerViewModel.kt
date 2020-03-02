package com.example.beer_app_android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class BeerViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val beerRepository: BeerRepository = BeerRepository(BeersApiService.beersApi)

    val beerLiveData = MutableLiveData<Beer>()

    val beers = MutableLiveData<List<Beer>>()

    private lateinit var jsonObject: JsonObject

    fun getBeer() {

        scope.launch {
            val beer = beerRepository.getBeer()
            beerLiveData.postValue(beer)
        }
    }

    fun postBeer(beer: Beer) {

        scope.launch {
            beerRepository.postBeer(beer)
        }
    }

    fun getListOfBeers() {
        scope.launch {
            val fetchedBeers = beerRepository.getListOfBeers()
            beers.postValue(fetchedBeers)
        }
    }

    override fun onCleared() {
        super.onCleared()
        if(!parentJob.isCancelled) parentJob.cancel()
    }
}