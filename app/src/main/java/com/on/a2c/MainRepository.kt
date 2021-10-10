package com.on.a2c

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.on.a2c.ApiHelper
import com.on.a2c.User

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun getUser(id: String): User? = withContext(Dispatchers.IO) { apiHelper?.getUser(id) }
}