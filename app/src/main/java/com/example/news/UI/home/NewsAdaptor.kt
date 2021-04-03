package com.example.news.UI.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.model.entitys.News
import com.example.news.model.entitys.User
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class NewsAdaptor(var news: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdaptor.NewsViewHolder>() {
    fun updateHours(newNew: List<News>) {
        news.clear()
        news.addAll(newNew)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = NewsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
    )

    override fun getItemCount() = news.size
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }

    class NewsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title)
        private val date = view.findViewById<TextView>(R.id.date)
        private val auther = view.findViewById<TextView>(R.id.auther)
        private val image = view.findViewById<ImageView>(R.id.imageNews)


        fun bind(new: News) {
            title.text=new.title
            date.text=new.publishedAt
            auther.text=new.author


        }

    }
}