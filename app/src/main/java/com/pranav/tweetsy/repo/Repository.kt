package com.pranav.tweetsy.repo

import com.pranav.tweetsy.api.ApiService
import com.pranav.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets

    val _categories = MutableStateFlow<List<String>>(emptyList())
    val category: StateFlow<List<String>>
        get() = _categories

    suspend fun getCategory(){
        val response = apiService.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String){
        val response = apiService.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}