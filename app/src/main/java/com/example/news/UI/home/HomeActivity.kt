package com.example.news.UI.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.R
import com.example.news.UI.login.LoginViewModel
import com.example.news.databinding.ActivityHomeBinding
import com.example.news.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    var newsAdaptor = NewsAdaptor(arrayListOf())
    var titlesAdaptor = TitlesAdaptor(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding  = DataBindingUtil.setContentView( this,R.layout.activity_home)
        homeViewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[HomeViewModel::class.java]
        initUI()
    }
    private fun initUI() {
        binding.recyclerNews.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdaptor
        }
        binding.recyclertitles.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = titlesAdaptor
        }
    }
}