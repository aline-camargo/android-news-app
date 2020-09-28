package com.example.newsapp.articledetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.data.Article

class ArticleDetailsViewModelFactory (
    private val article: Article
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java)) {
            return ArticleDetailsViewModel(article) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}