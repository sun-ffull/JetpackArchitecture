package com.sunfull.livedata2_3_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData : LiveData<Int>            //밖에선 wrapping된 것을 쓴다고 볼 수 있겠다.
        get() = _testMutableLiveData

    fun plusLiveDataValue(){
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }

    //var testMutableLiveData = MutableLiveData(0)

    //fun plusLiveDataValue(){
    //    testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
    //}
}