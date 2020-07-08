package com.example.newsapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.newsapp.data.Articles
import com.example.newsapp.data.local.ArticlesDatabase
import com.example.newsapp.data.local.NetworkArticleContainer
import com.example.newsapp.data.local.asDatabaseModel
import com.example.newsapp.data.local.asDomainModel
import com.example.newsapp.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val apiService: ApiService,
    private val database: ArticlesDatabase
) :
    IArticlesRepository {
    val articles: LiveData<Articles> =
        Transformations.map(database.articleDao.getArticles()) { dbArticle ->
            val articles = dbArticle.asDomainModel()
            val test = Articles()
            articles.forEach { test.add(it) }
            return@map test
        }

    override suspend fun refreshArticles(id: Int) {
        withContext(Dispatchers.IO) {
            val articles = apiService.getArticles()
            if (articles.articles !== null) {
                val networkClue = NetworkArticleContainer(articles.articles)
                database.articleDao.insertAll(*networkClue.asDatabaseModel())
            }
        }
    }
}
