package com.example.catnews

data class NewsModel(
    var type: String,
    var title: String? = null,
    var subTitle: String? = null,
    var webLink: String? = null
)