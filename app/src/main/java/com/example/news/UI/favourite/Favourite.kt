package com.example.news.UI.favourite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.news.R
import com.example.news.databinding.ActivityFavouriteBinding


class Favourite : AppCompatActivity() {
    lateinit var binding :ActivityFavouriteBinding
    lateinit var recyclerView: RecyclerView
    lateinit var favpuriteAdaper: FavpuriteAdaper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favpuriteAdaper
        binding = DataBindingUtil.setContentView(this, R.layout.activity_favourite)
        recyclerView=binding.recyclerviewFav
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = gridLayoutManager
        //recyclerView.adapter = adapter

    }
}