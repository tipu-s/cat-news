package com.example.catnews.model_data.story


import com.google.gson.annotations.SerializedName

data class StoryResponse(
    @SerializedName("contents")
    var contents: List<Content?>?,
    @SerializedName("creationDate")
    var creationDate: String?,
    @SerializedName("headline")
    var headline: String?,
    @SerializedName("heroImage")
    var heroImage: HeroImage?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("modifiedDate")
    var modifiedDate: String?
)