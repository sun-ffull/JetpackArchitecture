package com.sunfull.retrofitpractice_4_8.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunfull.retrofitpractice_4_8.api.MyApi
import com.sunfull.retrofitpractice_4_8.api.RetrofitInstance
import com.sunfull.retrofitpractice_4_8.model.Plant
import com.sunfull.retrofitpractice_4_8.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //val retrofit : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val repository = Repository()

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {
        _result.value = repository.getAllData()
    }

}