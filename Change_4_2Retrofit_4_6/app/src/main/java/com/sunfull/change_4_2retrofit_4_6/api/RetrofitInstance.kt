package com.sunfull.change_4_2retrofit_4_6.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//싱글톤으로 생성함.
object RetrofitInstance {

    val BASE_URL= "https://jsonplaceholder.typicode.com/"

    val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance():Retrofit{
        return client
    }
}