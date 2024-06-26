package com.sunfull.retrofitpractice_4_8.model

data class Plant (
    val plantId : String,
    val name : String,
    val description : String,
    val growZoneNumber: String,
    val wateringInterval : String,
    val imageUrl : String,
)