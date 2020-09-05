package com.example.newsapp.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.usecases.ArticlesUseCases
import com.example.newsapp.utils.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainNewsViewModel @Inject constructor(
    private val articlesUseCases: ArticlesUseCases
) : BaseViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val articles = articlesUseCases.articlesLocal
    private val _clickedFab = MutableLiveData<Boolean>()
    val clickedFab: LiveData<Boolean> = _clickedFab

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun loadArticles() {
        viewModelScope.launch {
            articlesUseCases.refreshArticles(162)
        }
    }

    fun onFabClicked() {
        _clickedFab.value = true
    }

    init {
        loadArticles()
    }
}
