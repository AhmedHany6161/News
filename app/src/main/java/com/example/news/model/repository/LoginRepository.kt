package com.example.news.model.repository

import android.app.Application
import com.example.news.model.entitys.User
import com.example.news.model.localData.LocalDatabase
import com.example.news.model.localData.NewsDao

class LoginRepository private constructor(application: Application) {
    private val weatherDAO: NewsDao = LocalDatabase.getDatabase(application).getNewsDao()

    companion object {
        private var loginRepository: LoginRepository? = null
        fun getInstance(application: Application): LoginRepository {
            return loginRepository ?: synchronized(this) {
                loginRepository = LoginRepository(application)
                loginRepository!!
            }
        }

    }

    suspend fun login(email:String ,password:String):User?{
       return weatherDAO.login(email,password)
    }
    suspend fun register(user: User){
        weatherDAO.register(user)
    }

}
