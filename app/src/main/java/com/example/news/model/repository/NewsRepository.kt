package com.example.news.model.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.news.model.entitys.News
import com.example.news.model.localData.LocalDatabase
import com.example.news.model.localData.NewsDao
import com.example.news.model.onlineData.ApiRequest
import com.example.news.model.onlineData.OnlineDataSource
import com.google.gson.JsonArray
import com.google.gson.JsonObject


class NewsRepository private constructor(application: Application){
    private val request: ApiRequest = OnlineDataSource.getServices()
    private val newsDAO: NewsDao = LocalDatabase.getDatabase(application).getNewsDao()

    companion object {
        private var loginRepository: NewsRepository? = null
        fun getInstance(application: Application): NewsRepository {
            return loginRepository ?: NewsRepository(application)

        }

    }
    suspend fun loadData(){
        val data=request.updateCurrentData()
        var jsonObject :  JsonObject
        val jsonArray=data.getAsJsonArray("articles")
        val count =data.get("totalResults").asInt
        var index=0
        Log.e("ssssss",jsonArray.toString())
        while ( index<jsonArray.size()) {
            jsonObject = jsonArray.get(index).asJsonObject
            var author=jsonObject.get("author").toString()
            if(author=="null"){
                author="unknown"
            }
           newsDAO.addNews( News(
               author = author,
                title = jsonObject.get("title").asString,
                description = jsonObject.get("description").asString,
                url =  jsonObject.get("description").asString,
                urlToImage = jsonObject.get("urlToImage").asString,
                publishedAt = jsonObject.get("publishedAt").asString
            ))
            index++;
        }

    }
     fun getNews():LiveData<List<News>>{
        return newsDAO.getNews()
    }
}