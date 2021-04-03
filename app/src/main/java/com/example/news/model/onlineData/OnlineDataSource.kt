package com.example.news.model.onlineData

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OnlineDataSource private constructor() {
    companion object {
        @Volatile
        private var apiRequest: ApiRequest? = null
        fun getServices(): ApiRequest {
            return apiRequest ?: synchronized(this) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service: ApiRequest = retrofit.create(ApiRequest::class.java)
                apiRequest = service
                service
            }
        }
    }
}