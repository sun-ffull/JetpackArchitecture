package com.sunfull.change_4_2retrofit_4_6.api

import com.sunfull.change_4_2retrofit_4_6.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("posts/1")
    suspend fun getPost1() : Post

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number : Int
    ) : Post

    @GET("posts")
    suspend fun getPostAll() : List<Post>
}