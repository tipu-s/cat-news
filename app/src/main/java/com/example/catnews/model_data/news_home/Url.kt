package com.example.catnews.model_data.news_home


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("href")
    var href: String?,
    @SerializedName("templated")
    var templated: Boolean?,
    @SerializedName("type")
    var type: String?
)