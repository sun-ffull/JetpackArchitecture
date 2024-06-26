package com.sunfull.room1_5_4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sunfull.room1_5_4.entity.TextEntity
import com.sunfull.room1_5_4.entity.WordEntity
import com.sunfull.room1_5_4.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application : Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext

    val repository = Repository(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val testList : LiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : LiveData<List<WordEntity>>
        get() = _wordList

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        //메인스레드에서 동작하는 setValue()를 백그라운드 스레드에서 실행할 수 없음.
        //따라서 기존의 방식인 .value = .. 대신에 postValue(..)를 사용해야함.
        //_textList.postValue(db.textDao().getAllData())
        //_wordList.postValue(db.wordDao().getAllData())
        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())
    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO) {
        //db.textDao().insert(TextEntity(0, text))
        //db.wordDao().insert(WordEntity(0, text))
        repository.insertTextData(text)
        repository.insertWordData(text)
    }

    fun deleteData() = viewModelScope.launch(Dispatchers.IO){
        //db.textDao().deleteAllData()
        //db.wordDao().deleteAllData()
        repository.deleteTextData()
        repository.deleteWordData()
    }
}