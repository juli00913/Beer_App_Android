package com.example.beer_app_android

import android.util.Log
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call : suspend() -> Response<T>, error: String) : T? {
        val result = safeApiResult(call, error)
        var data : T? = null

        when(result) {
            is Result.Success ->
                data = result.data
            is Result.Error ->
                Log.d("1.DataRepository", "$error & Exception - ${result.exception}")
        }
        return data
    }

    private suspend fun <T: Any> safeApiResult(call: suspend() -> Response<T>, error: String) : Result<T> {
        val response = call.invoke()
        return if(response.isSuccessful)
            Result.Success(response.body()!!)

        else
            Result.Error(IOException("OOps .. Something went wrong due to  $error"))
    }

}