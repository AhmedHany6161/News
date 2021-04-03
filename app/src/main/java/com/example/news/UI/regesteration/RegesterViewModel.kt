package com.example.news.UI.regesteration

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.news.model.entitys.User
import com.example.news.model.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegesterViewModel(application: Application) : AndroidViewModel(application) {
    val checkData : MutableLiveData<String> = MutableLiveData<String>()
    val dataSourse : LoginRepository= LoginRepository.getInstance(application)
    fun register(user: User) {
        if (isEmailValid(user.email) && isPasswordValid(user.password)){
            CoroutineScope(Dispatchers.IO).launch {
                dataSourse.register(user)
            }
        }

    }
    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun isPasswordValid(password: String): Boolean {
        return password.length >= 6
    }

}