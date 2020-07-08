package com.example.newsapp.data.usecases

interface IArticlesUseCases {
    suspend fun refreshArticles(id: Int)
}
