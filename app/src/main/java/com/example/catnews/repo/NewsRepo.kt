package com.example.catnews.repo

import com.example.catnews.model_data.news_home.NewsHomeResponse
import com.example.catnews.model_data.story.StoryResponse
import com.example.catnews.network.SafeApiRequest
import com.example.catnews.network.api.NewsApi
import javax.inject.Inject

class NewsRepo @Inject constructor(private val api: NewsApi) : SafeApiRequest(){
    suspend fun getNewsHomeResponse(): NewsHomeResponse {
        return apiRequestObject { api.getNews() }
    }

    suspend fun getStoryResponse(id: Int): StoryResponse {
        return apiRequestObject { api.getStoryById() }
    }
}
