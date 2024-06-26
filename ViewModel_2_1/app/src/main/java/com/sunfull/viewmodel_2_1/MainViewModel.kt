package com.sunfull.viewmodel_2_1

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var count = 0

    fun plus(){
        count++
    }

    fun minus(){
        count--
    }

    fun getcount(): Int{
        return count
    }
}