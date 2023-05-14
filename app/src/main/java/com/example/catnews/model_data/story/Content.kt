package com.example.catnews.model_data.story


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("accessibilityText")
    var accessibilityText: String?,
    @SerializedName("text")
    var text: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)