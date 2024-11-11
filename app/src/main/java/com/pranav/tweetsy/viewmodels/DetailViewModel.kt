package com.pranav.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pranav.tweetsy.models.TweetListItem
import com.pranav.tweetsy.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val repo: Repository):ViewModel() {

    val tweets: StateFlow<List<TweetListItem>>
        get() = repo.tweets

    init {
        viewModelScope.launch {
            repo.getTweets("Android")
        }
    }
}