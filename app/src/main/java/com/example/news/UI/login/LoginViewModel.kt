package com.example.news.UI.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.news.model.entitys.User
import com.example.news.model.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel ( application: Application) : AndroidViewModel(application){
    private val  loginRepository: LoginRepository = LoginRepository.getInstance(application)
    private var valid: MutableLiveData<String?> =MutableLiveData<String?>()

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun login(passwordValue :String,email: String){
        CoroutineScope(Dispatchers.IO).launch{
            val  user=loginRepository.login(email,passwordValue)
            if(user!=null){
               valid.postValue(user.name)
            }else{
                valid.postValue(null)
            }
        }
    }
    fun isValid():LiveData<String?>{
        return valid;
    }
}