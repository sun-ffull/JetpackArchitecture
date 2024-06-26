package com.sunfull.mapandswitchmap1_3_6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MainViewModel: ViewModel() {

    //Transformations -> map/switchmap
    //변경됨. 기존에 생성한 LiveData를 이용하여 map/switchmap을 만들어야함.

    //map -> 값을 return

    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    val mapLiveData = liveCount.map {       //map : 원본 livedata가 변할때마다 그에 맞추어 livedata 반환
        it+it                                      // == 원본 livedata가 변할때마다 해당 코드 실행
    }

    val switchMapLiveData = liveCount.switchMap {   //switchMap : 원본 livedata가 변할때마다 그에 맞추어 livedata 반환
        changeValue(it)                             // == 원본 livedata가 변할때마다 해당 코드 실행
    }

    fun setLiveDataValue(count: Int){
        _mutableCount.value = count
    }

    fun changeValue(count: Int): LiveData<Int>{
        val testLiveData = MutableLiveData(count*count)
        return testLiveData
    }
}