package com.sunfull.mydatabindingtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    private var _myLiveData = MutableLiveData(1)
    val myLiveData : LiveData<Int>
        get() = _myLiveData
}