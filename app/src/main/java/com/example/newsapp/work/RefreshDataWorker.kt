package com.example.newsapp.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import retrofit2.HttpException

class RefreshDataWorker constructor(
//    private val useCases: ArticlesUseCases,
    appContext: Context,
    params: WorkerParameters
) :
    CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
//        Timber.d(">>>>Injetado:$useCases")
        return try {
//            useCases.refreshArticles(162)
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

//    class Factory @Inject constructor(
//        private val useCases: ArticlesUseCases
//    ): ChildWorkerFactory {
//
//        override fun create(appContext: Context, params: WorkerParameters): RefreshDataWorker {
//            return RefreshDataWorker(useCases, appContext, params)
//        }
//    }

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }
}
