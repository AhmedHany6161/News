package com.example.news.model.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String,
    val publishedAt:String
)
