package com.example.newsapp.data.repository

interface IArticlesRepository {
    suspend fun refreshArticles(id: Int)
}
