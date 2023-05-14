package com.example.catnews.network.api

import com.example.catnews.model_data.news_home.NewsHomeResponse
import com.example.catnews.model_data.story.StoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {
    //this is the endpoint for sample_list.json
    @GET("/uYxJeh")
    suspend fun getNews(): Response<NewsHomeResponse>


    //url should be "/story/{id} when backend will be ready"
   /* @GET("/1KnIr8")
    suspend fun getStoryById(@Path("id") id:Int) : Response<StoryResponse>*/

    @GET("/1KnIr8")
    suspend fun getStoryById() : Response<StoryResponse>
}

