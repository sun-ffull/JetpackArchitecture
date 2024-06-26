package com.sunfull.viewmodel_in_fragment_2_3

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var count = 0

    fun plus(){
        count++

        Log.d("test", count.toString())
    }
    fun minus(){
        count--
    }

    fun getcount() : Int{
        return count
    }
}