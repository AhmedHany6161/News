package com.example.news.UI.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.model.entitys.News
import com.example.news.model.entitys.User

class TitlesAdaptor(var titles: ArrayList<News>) :
    RecyclerView.Adapter<TitlesAdaptor.HourlyViewHolder>() {
    fun updateHours(title: List<News>) {
        titles.clear()
        titles.addAll(title)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = HourlyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_searsh, parent, false)
    )

    override fun getItemCount() = titles.size
    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        holder.bind(titles[position])
    }

    class HourlyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title_news)

        fun bind(new: News) {
            title.text=new.title

        }

    }
}