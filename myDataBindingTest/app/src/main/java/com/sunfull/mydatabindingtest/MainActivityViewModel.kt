package com.sunfull.mydatabindingtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private var count = MutableLiveData<Int>()

    val countData : LiveData<Int>
        get() = count

    val inputText = MutableLiveData<String>()

    fun getUpdatedCount(){
        val plusCount: Int = inputText.value!!.toInt()
        count.value = (count.value)?.plus(plusCount)
    }
}