package com.example.newsapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val source: Source?,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
) : Parcelable

@Parcelize
data class Source(
    val id: String?,
    val name: String?
) : Parcelable

@Parcelize
class Articles : ArrayList<Article>(), Parcelable
