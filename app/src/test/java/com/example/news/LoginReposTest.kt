package com.example.news

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.news.model.entitys.User
import com.example.news.model.localData.LocalDatabase
import com.example.news.model.localData.NewsDao
import com.example.news.model.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException
import java.util.concurrent.TimeoutException
@RunWith(JUnit4::class)
class LoginReposTest {
    class SimpleEntityReadWriteTest {
     private  lateinit var loginRepository: LoginRepository
        @Before
        fun createDb() {
            val context = ApplicationProvider.getApplicationContext<Application>()
            loginRepository= LoginRepository.getInstance(context);
       }



        @Test
        @Throws(Exception::class)
        fun writeUserAndReadInList() {
            CoroutineScope(Dispatchers.IO).launch {
                val user: User = User(name = "ahmed",email = "email1",password = "password")
                loginRepository.register(user)

                if(loginRepository.login("ahmed","password")==null){
                    assert(true){"login faild"}
                }

            }
        }
    }
}