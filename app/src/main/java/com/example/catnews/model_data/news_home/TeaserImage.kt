package com.example.catnews.model_data.news_home


import com.google.gson.annotations.SerializedName

data class TeaserImage(
    @SerializedName("accessibilityText")
    var accessibilityText: String?,
    @SerializedName("_links")
    var links: Links?
)