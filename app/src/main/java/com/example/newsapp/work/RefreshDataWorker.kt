package com.example.newsapp.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import retrofit2.HttpException

class RefreshDataWorker(
    appContext: Context,
    params: WorkerParameters
) :
    CoroutineWorker(appContext, params) {
//    TODO: Implement Worker
//    @Inject
//    lateinit var useCases: CluesUseCases

    override suspend fun doWork(): Result {
//        Timber.d(">>>>Injetado:$useCases")
        return try {
//            useCases.refreshArticles(162)
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }
}
