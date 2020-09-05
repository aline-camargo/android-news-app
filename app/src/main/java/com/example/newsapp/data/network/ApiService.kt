package com.example.newsapp.data.network

import com.example.newsapp.BuildConfig
import retrofit2.http.GET

private const val apiKey = BuildConfig.API_KEY

interface ApiService {
    @GET("top-headlines?apiKey=$apiKey&country=br")
    suspend fun getArticles(): NewsResponse
}
