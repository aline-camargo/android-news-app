package com.example.newsapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.data.Article
import com.example.newsapp.data.Source

@Entity
data class DatabaseArticle constructor(
    @PrimaryKey
    val title: String,
//    @TypeConverters(ObjectConverter::class)
    @ColumnInfo(name = "source_id")
    val sourceId: String?,
    @ColumnInfo(name = "source_name")
    val sourceName: String?,
    val description: String?,
    val url: String?,
    @ColumnInfo(name = "url_to_image")
    val urlToImage: String?,
    @ColumnInfo(name = "published_at")
    val publishedAt: String?,
    val content: String?
)

fun List<DatabaseArticle>.asDomainModel(): List<Article> {
    return map {
        val source = Source(
            id = it.sourceId,
            name = it.sourceName
        )

        Article(
            source = source,
            title = it.title,
            description = it.description,
            url = it.url,
            urlToImage = it.urlToImage,
            publishedAt = it.publishedAt,
            content = it.content
        )
    }
}

//data class DatabaseSource constructor(
//    val id: String,
//    val name: String
//)

// TODO: See how to implement custom class TypeConverter
// class ObjectConverter {
//
//    private val moshi: Moshi = Moshi.Builder().build()
//    private val jsonAdapter: JsonAdapter<DatabaseSource> = moshi.adapter(DatabaseSource::class.java)
//
//    @TypeConverter
//    fun objectToString(someObjects: DatabaseSource?): String? {
//        return jsonAdapter.toJson(someObjects)
//    }
// }
