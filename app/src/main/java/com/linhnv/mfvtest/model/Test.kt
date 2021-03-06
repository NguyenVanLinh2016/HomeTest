package com.linhnv.mfvtest.model

import com.squareup.moshi.Json


data class Test(
        @Json(name = "articles") val articles: List<Article>
) {

    data class Article(
            @Json(name = "title") val title: String,
            @Json(name = "pubDate") val pubDate: String,
            @Json(name = "dc:creator") val dccreator: String,
            @Json(name = "category") val category: List<String>,
            @Json(name = "description") val description: String,
            @Json(name = "image") val image: String,
            @Json(name = "detail") val detail: String
    )
}