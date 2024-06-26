package com.sunfull.change_4_2retrofit_4_6.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunfull.change_4_2retrofit_4_6.api.MyApi
import com.sunfull.change_4_2retrofit_4_6.api.RetrofitInstance
import com.sunfull.change_4_2retrofit_4_6.model.Post
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val retrofit = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val _mutableWord1 = MutableLiveData<String>()
    val liveWord1 : LiveData<String>
        get() = _mutableWord1

    private val _mutableWord2 = MutableLiveData<String>()
    val liveWord2 : LiveData<String>
        get() = _mutableWord2

    private var _mutableWordList = MutableLiveData<List<Post>>()
    val liveWordList : LiveData<List<Post>>
        get() = _mutableWordList

    fun getPost1() = viewModelScope.launch {

        val post = retrofit.getPost1()
        Log.d("MainViewModel", post.toString())
        _mutableWord1.value = post.title
    }

    fun getPostNumber(number: Int) = viewModelScope.launch {
        val post = retrofit.getPostNumber(number)
        Log.d("MainViewModel", post.toString())
        _mutableWord2.value = post.title
    }

    fun getPostAll() = viewModelScope.launch {
        val postAll = retrofit.getPostAll()
        _mutableWordList.value = postAll
    }

}