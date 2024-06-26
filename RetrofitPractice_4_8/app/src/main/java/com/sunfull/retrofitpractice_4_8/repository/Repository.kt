package com.sunfull.retrofitpractice_4_8.repository

import com.sunfull.retrofitpractice_4_8.api.MyApi
import com.sunfull.retrofitpractice_4_8.api.RetrofitInstance

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}