package com.example.newsapp.main

import com.example.newsapp.data.usecases.ArticlesUseCases
import com.example.newsapp.utils.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainNewsViewModel @Inject constructor(
    private val cluesUseCases: ArticlesUseCases
) : BaseViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val articles = cluesUseCases.articlesLocal

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun loadArticles() {
        viewModelScope.launch {
//            onStartGame.value = true
            cluesUseCases.refreshArticles(162)
        }
    }

    init {
        loadArticles()
    }
}
