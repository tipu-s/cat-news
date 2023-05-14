package com.example.catnews.model_data.news_home


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("creationDate")
    var creationDate: String?,
    @SerializedName("headline")
    var headline: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("modifiedDate")
    var modifiedDate: String?,
    @SerializedName("teaserImage")
    var teaserImage: TeaserImage?,
    @SerializedName("teaserText")
    var teaserText: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("weblinkUrl")
    var weblinkUrl: String?
)