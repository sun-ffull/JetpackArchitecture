package com.sunfull.retrofitpractice_4_8.api

import com.sunfull.retrofitpractice_4_8.model.Plant
import retrofit2.http.GET

interface MyApi {

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>
}