package com.sunfull.shareviewmodel_activity_fragment_2_4

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var count = 0

    fun plus(){
        count++
    }

    fun minus(){
        count--
    }

    fun getCount(): Int{
        return count
    }
}