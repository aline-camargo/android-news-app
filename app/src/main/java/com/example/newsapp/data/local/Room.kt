package com.example.newsapp.data.local

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Dao
interface ArticleDao {
    @Query("select * from databasearticle")
    fun getArticles(): LiveData<List<DatabaseArticle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg articles: DatabaseArticle)
}

@Database(entities = [DatabaseArticle::class], version = 3, exportSchema = false)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract val articleDao: ArticleDao
}

private lateinit var INSTANCE: ArticlesDatabase

fun getDatabase(context: Context): ArticlesDatabase {
    synchronized(ArticlesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                ArticlesDatabase::class.java,
                "articles"
            ).fallbackToDestructiveMigration().build()
        }
    }
    return INSTANCE
}
