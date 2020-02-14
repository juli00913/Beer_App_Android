package com.example.beer_app_android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class BeerViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val beerRepository : BeerRepository = BeerRepository(BeersApiService.beersApi)

    val beerLiveData = MutableLiveData<Beer>()

    fun getBeer() {

        scope.launch {
            val beer = beerRepository.getBeer()
            beerLiveData.postValue(beer)
        }
    }
    fun cancelRequest() = coroutineContext.cancel()
}