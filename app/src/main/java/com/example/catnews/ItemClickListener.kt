package com.example.catnews

import com.example.catnews.model_data.news_home.News

interface ItemClickListener {
    fun onItemClick(item: News)
}