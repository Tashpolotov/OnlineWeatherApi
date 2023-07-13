package com.example.data.repository

import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    @SerializedName("articles")
    val newsArticleResponse: List<NewsArticleResponse>
        )

data class NewsArticleResponse (

    val author : String,
    val title: String,
    val description: String

        )

