package com.example.catnews.model_data.story


import com.google.gson.annotations.SerializedName

data class HeroImage(
    @SerializedName("accessibilityText")
    var accessibilityText: String?,
    @SerializedName("imageUrl")
    var imageUrl: String?
)