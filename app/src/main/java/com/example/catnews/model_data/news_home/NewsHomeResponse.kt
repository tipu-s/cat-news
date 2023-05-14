package com.example.catnews.model_data.news_home


import com.google.gson.annotations.SerializedName

data class NewsHomeResponse(
    @SerializedName("data")
    var `data`: List<News?>?,
    @SerializedName("title")
    var title: String?
)