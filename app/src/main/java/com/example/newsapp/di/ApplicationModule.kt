package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.data.local.ArticlesDatabase
import com.example.newsapp.data.local.getDatabase
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repository.ArticlesRepository
import com.example.newsapp.data.repository.IArticlesRepository
import com.example.newsapp.data.usecases.ArticlesUseCases
import com.example.newsapp.data.usecases.IArticlesUseCases
// import com.example.newsapp.work.ChildWorkerFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @JvmStatic
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java
    )

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): ArticlesDatabase {
        return getDatabase(context)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofitInterface(): Retrofit {
        val httpClient = OkHttpClient.Builder().build()
        val endpoint = "https://newsapi.org/v2/"
        val builder = Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(httpClient)

        return builder.build()
    }

//    @JvmStatic
//    @Singleton
//    @Provides
//    fun provideChildWorkerFactory(childWorkerFactory: ChildWorkerFactory?): ChildWorkerFactory? {
//        return childWorkerFactory
//    }
}

@Module
abstract class ApplicationModuleBinds {
    @Singleton
    @Binds
    abstract fun bindCluesUseCases(repo: ArticlesUseCases): IArticlesUseCases

    @Singleton
    @Binds
    abstract fun bindCluesRepository(repo: ArticlesRepository): IArticlesRepository
}
