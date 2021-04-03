package com.example.news.model.localData

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.news.model.entitys.User

@Database(entities = [User::class], version = 1 , exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null
        fun getDatabase(application: Application): LocalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    LocalDatabase::class.java,
                    "news_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}