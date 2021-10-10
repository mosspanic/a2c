package com.on.a2c

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.on.a2c.ApiHelper
import com.on.a2c.RetrofitBuilder
import com.on.a2c.MainRepository
import com.on.a2c.Resource

class MainViewModel : ViewModel() {

    private val apiHelper = ApiHelper(RetrofitBuilder.apiService)
    private val mainRepository: MainRepository = MainRepository(apiHelper)

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
            val uz=mainRepository.getUsers().size;  println("######### Resource.success getUsers().size $uz");

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            println("#########Resource.Exception");
        }
    }
}