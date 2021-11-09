package com.vaishnav.pratilipiproject.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vaishnav.pratilipiproject.data.model.Content

@Database(entities = [ Content::class ], version = 1, exportSchema = false)
abstract class ContentDatabase : RoomDatabase() {

    abstract fun contentDao() : ContentDao

    companion object{
        @Volatile
        private var INSTANCE: ContentDatabase? = null

        fun getDatabase(context: Context): ContentDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContentDatabase::class.java,
                    "content_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}