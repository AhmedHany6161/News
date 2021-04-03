package com.example.news.UI.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.news.model.entitys.User
import com.example.news.model.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel ( application: Application) : AndroidViewModel(application){
    val  loginRepository: LoginRepository = LoginRepository(application)
    var valid: MutableLiveData<User> =MutableLiveData<User>()

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(passwordValue :String,email: String): User? {
        CoroutineScope(Dispatchers.IO).launch{
            valid.postValue(loginRepository.login(email,passwordValue))
        }
        return valid.value
    }
}