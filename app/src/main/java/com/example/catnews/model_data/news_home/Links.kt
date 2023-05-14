package com.example.catnews.model_data.news_home


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("url")
    var url: Url?
)