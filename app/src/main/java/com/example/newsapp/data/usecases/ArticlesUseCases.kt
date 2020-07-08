package com.example.newsapp.data.usecases

import com.example.newsapp.data.repository.ArticlesRepository
import javax.inject.Inject

class ArticlesUseCases @Inject constructor(private val articlesRepository: ArticlesRepository) :
    IArticlesUseCases {
    override suspend fun refreshArticles(id: Int) {
        articlesRepository.refreshArticles(id)
    }

    val articlesLocal = articlesRepository.articles
}
