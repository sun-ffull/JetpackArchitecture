package com.sunfull.coroutineandviewmodelscope_4_5

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondViewModel :ViewModel() {

    fun a(){
        CoroutineScope(Dispatchers.IO).launch {
            for ( i in 0..10){
                delay(1000)
                Log.d("secondViewModel", i.toString())
            }
        }
    }

    fun B(){
        viewModelScope.launch {
            for ( i in 0..10){
                delay(1000)
                Log.d("secondViewModel", i.toString())
            }
        }
    }
}