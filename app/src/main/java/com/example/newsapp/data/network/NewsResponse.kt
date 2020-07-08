package com.example.newsapp.data.network

import com.example.newsapp.data.Article
import com.squareup.moshi.Json

data class NewsResponse(
    @field:Json(name = "articles") val articles: List<Article>? = null
)
