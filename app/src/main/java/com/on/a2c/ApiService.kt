package com.on.a2c

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import com.on.a2c.User

interface ApiService {

    @GET("character")
    suspend fun getUsers(): List<User>

    @GET("character/{userId}")
    suspend fun getUser(@Path("userId") userId: String): User

}