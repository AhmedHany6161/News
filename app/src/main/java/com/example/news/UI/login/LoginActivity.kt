package com.example.news.UI.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding = ActivityLoginBinding.inflate(layoutInflater)
        loginViewModel= ViewModelProvider(this).get(LoginViewModel::class.java)
        var userEmail =binding.email.text
        var password =binding.password.text

        loginViewModel.isPasswordValid(userEmail.toString(),password.toString())

    }
}