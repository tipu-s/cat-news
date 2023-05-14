package com.example.catnews

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catnews.model_data.news_home.News
import com.example.catnews.model_data.news_home.NewsHomeResponse
import com.example.catnews.model_data.story.StoryResponse
import com.example.catnews.repo.NewsRepo
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repo: NewsRepo) : ViewModel() {

    var newsHomeResponse = MutableLiveData<List<News?>>()
    var firstItemResponse = MutableLiveData<News?>()
    var newsStoryResponse = MutableLiveData<StoryResponse>()
    var errorMessage = MutableLiveData<String>()

    suspend fun getNewsResponse() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                var allNews = emptyList<News?>()
                allNews = repo.getNewsHomeResponse().data!!
                val firstItem = allNews.firstOrNull()
                val otherItems =
                    if (allNews.size > 1) allNews.subList(1, allNews.size) else emptyList()
                firstItemResponse.postValue(firstItem)
                newsHomeResponse.postValue(otherItems)
            }
        } catch (e: Exception) {
            errorMessage.value = e.message
        }
    }

    suspend fun getStoryById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                newsStoryResponse.postValue(repo.getStoryResponse(id))
            }
        } catch (e: Exception) {
            errorMessage.value = e.message
        }
    }


}