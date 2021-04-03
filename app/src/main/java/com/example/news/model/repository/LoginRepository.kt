package com.example.news.model.repository

import android.app.Application
import com.example.news.model.entitys.User
import com.example.news.model.localData.LocalDatabase
import com.example.news.model.localData.NewsDao
import com.example.news.model.onlineData.ApiRequest
import com.example.news.model.onlineData.OnlineDataSource

class LoginRepository private constructor(application: Application) {
    private val newsDAO: NewsDao = LocalDatabase.getDatabase(application).getNewsDao()
    companion object {
        private var loginRepository: LoginRepository? = null
        fun getInstance(application: Application): LoginRepository {
            return loginRepository ?: LoginRepository(application)
        }

    }

    suspend fun login(email:String ,password:String):User?{
       return newsDAO.login(email,password)
    }
    suspend fun register(user: User){
        newsDAO.register(user)
    }



}
