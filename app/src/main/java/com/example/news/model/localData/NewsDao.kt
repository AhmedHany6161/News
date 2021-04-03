package com.example.news.model.localData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.news.model.entitys.News
import com.example.news.model.entitys.User
import kotlinx.coroutines.flow.Flow
@Dao
interface NewsDao {
    @Insert
    suspend fun register(user: User)
    @Insert
    suspend fun addNews(news: News)
    @Query("select * from user where email==:sEmail And password=:sPassword ")
    suspend fun login(sEmail:String , sPassword:String): User?
//    @Query("select * from user ")
//     fun getUsers(sEmail:String , sPassword:String): Flow<List<User?>?>?
}