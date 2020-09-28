package com.example.newsapp.articledetails

import com.example.newsapp.data.Article
import com.example.newsapp.utils.BaseViewModel
import timber.log.Timber

class ArticleDetailsViewModel(article: Article) : BaseViewModel() {

    init {
        Timber.d(">>>>>>>>>>>>>>>>>>>>>>${article.title}")
    }

}
