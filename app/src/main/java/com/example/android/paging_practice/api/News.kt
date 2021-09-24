package com.example.android.paging_practice.api

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(

    @Json(name = "totalResults")
    val totalResults: Int? = null,

    @Json(name = "articles")
    val articles: List<ArticlesItem> = emptyList(),

    @Json(name = "status")
    val status: String? = null
) : Parcelable

@Parcelize
data class ArticlesItem(

    @Json(name = "publishedAt")
    val publishedAt: String? = null,

    @Json(name = "author")
    val author: String? = null,

    @Json(name = "urlToImage")
    val urlToImage: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "source")
    val source: Source? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "content")
    val content: String? = null
) : Parcelable

@Parcelize
data class Source(

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "id")
    val id: String? = null
) : Parcelable
