package com.sunfull.viewmodellivedatalifecycleowner_3_8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

class MainViewModel : ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
        get() = _mutableWord

    private var _randomMutableWord = MutableLiveData("")
    val randomLiveWord : LiveData<String>
        get() = _randomMutableWord

    val newData = liveWord.switchMap {
        getRandomWordShuffled(it)
    }

    fun getNextData(){
        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)
    }

    fun getRandomWordShuffled(word: String):MutableLiveData<String>{
        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)
        return liveData
    }

}