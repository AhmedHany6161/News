package com.example.news.UI.favourite

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.model.entitys.News

class FavpuriteAdaper(var favouriteViewModel: FavouriteViewModel) : RecyclerView.Adapter<FavpuriteAdaper.MyViewHolder>() {
    lateinit var models: List<News>

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title = itemView.findViewById<TextView>(R.id.title)
        private var outhor = itemView.findViewById<TextView>(R.id.auther)
        private var date = itemView.findViewById<TextView>(R.id.date)
        private var image = itemView.findViewById<ImageView>(R.id.imageView)

        @RequiresApi(Build.VERSION_CODES.O)
        fun binding(news: News) {
            title.text = news.title
            outhor.text=news.author
            date.text=news.publishedAt
            Glide.with(itemView)  //2
                .load(news.urlToImage) //3
                .centerCrop() //4
                .placeholder(R.drawable.ic_picture)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = inflater.inflate(R.layout.item_favourite, parent, false)
        return MyViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }
}