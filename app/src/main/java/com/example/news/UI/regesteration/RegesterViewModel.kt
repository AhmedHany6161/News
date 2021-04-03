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
    val checkPassword : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val done : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val dataNotEpety : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private val dataSourse : LoginRepository= LoginRepository.getInstance(application)
    fun register(user: User) {
        if (user.password==""){
            dataNotEpety.value=false
        }
        if (isEmailValid(user.email)){
            if (isPasswordValid(user.password))
            CoroutineScope(Dispatchers.IO).launch {
                dataSourse.register(user)
                done.postValue(true)
            }else{
                checkData.value="Password is week try another format"
            }
        }else{
            checkData.value="Email is not correct"
        }

    }
    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun isPasswordValid(password: String): Boolean {
        return password.length >= 6
    }
    fun confirmPassword(password: String,conPassword: String) {
        checkPassword.value = password == conPassword
    }

    fun checkUserName(toString: String) : Boolean {
        return toString != ""
    }
}