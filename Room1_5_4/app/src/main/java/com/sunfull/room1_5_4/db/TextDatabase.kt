package com.sunfull.room1_5_4.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sunfull.room1_5_4.dao.TextDao
import com.sunfull.room1_5_4.dao.WordDao
import com.sunfull.room1_5_4.entity.TextEntity
import com.sunfull.room1_5_4.entity.WordEntity

/*entities : TextEntitiy 즉, 테이블을 의미함. 테이블 클래스가 많으면 대괄호에 ,를 이용해서 클래스를 넣어주는 듯 하다.*/
@Database(entities = [TextEntity::class, WordEntity::class], version = 2)
abstract class TextDatabase : RoomDatabase() {

    abstract fun textDao() : TextDao
    abstract fun wordDao() : WordDao

    companion object{
        @Volatile
        private var INSTANCE : TextDatabase? = null

        fun getDatabase(
            context: Context
        ) : TextDatabase {
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}