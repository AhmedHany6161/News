package com.example.news.model.onlineData

import com.example.news.model.entitys.News
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("top-headlines?q=everything&apiKey=37218e7eeca54dab9198d7f81f887362")
    suspend fun updateCurrentData(): JsonObject
}