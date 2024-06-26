package com.sunfull.room1_5_4.repository

import android.content.Context
import com.sunfull.room1_5_4.db.TextDatabase
import com.sunfull.room1_5_4.entity.TextEntity
import com.sunfull.room1_5_4.entity.WordEntity
import org.w3c.dom.Text

class Repository(context : Context) {
    val db = TextDatabase.getDatabase(context)

    fun getTextList() = db.textDao().getAllData()

    fun getWordList() = db.wordDao().getAllData()

    fun insertTextData(text : String) = db.textDao().insert(TextEntity(0, text))

    fun insertWordData(text : String) = db.wordDao().insert(WordEntity(0, text))

    fun deleteTextData() = db.textDao().deleteAllData()

    fun deleteWordData() = db.wordDao().deleteAllData()
}