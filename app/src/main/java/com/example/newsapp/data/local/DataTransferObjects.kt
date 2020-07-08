package com.example.newsapp.data.local

import com.example.newsapp.data.Article

data class NetworkArticleContainer(val articles: List<Article>)

fun NetworkArticleContainer.asDatabaseModel(): Array<DatabaseArticle> {
    return articles.map {
        DatabaseArticle(
            sourceId = it.source?.id,
            sourceName = it.source?.name,
            title = it.title,
            description = it.description,
            url = it.url,
            urlToImage = it.urlToImage,
            publishedAt = it.publishedAt,
            content = it.content
        )
    }.toTypedArray()
}
