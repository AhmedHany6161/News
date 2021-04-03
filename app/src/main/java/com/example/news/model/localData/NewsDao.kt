package com.example.news.model.localData

import androidx.room.Insert
import androidx.room.Query
import com.example.news.model.entitys.User
import kotlinx.coroutines.flow.Flow

interface NewsDao {
    @Insert
    suspend fun register(user: User)
    @Query("select * from User where email==:sEmail And password=:sPassword ")
    suspend fun login(sEmail:String , sPassword:String): User?
    @Query("select * from User ")
     fun getUsers(sEmail:String , sPassword:String): Flow<List<User>>
}