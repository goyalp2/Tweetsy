package com.pranav.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pranav.tweetsy.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repo:Repository) : ViewModel() {

    val category: StateFlow<List<String>>
        get() = repo.category

    init {
        viewModelScope.launch {
            repo.getCategory()
        }
    }
}