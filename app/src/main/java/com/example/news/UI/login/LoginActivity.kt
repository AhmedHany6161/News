package com.example.news.UI.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.news.R
import com.example.news.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val actionBar = supportActionBar
        actionBar?.hide()
        binding  = DataBindingUtil.setContentView( this,R.layout.activity_login)
        loginViewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[LoginViewModel::class.java]
       binding.loginBtn.setOnClickListener {

           val userEmail =binding.email.text.toString()
           val password =binding.password.text.toString()
           if(loginViewModel.isEmailValid(userEmail)){
             loginViewModel.login(userEmail,password)
           }else{
               Toast.makeText(this,"invalid email",Toast.LENGTH_LONG).show()
           }

       }
        binding.signUp.setOnClickListener {
           // val intent = Intent(this, ::class.java)
           // startActivity(intent)
        }

        loginViewModel.isValid().observe(this,{
            if(it==null){
                Toast.makeText(this,"incorrect email or password",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "Hello $it",Toast.LENGTH_LONG).show()
            }
        })
    }
}