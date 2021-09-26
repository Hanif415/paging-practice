package com.example.android.paging_practice.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.android.paging_practice.api.ArticlesItem
import com.example.android.paging_practice.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow


class SearchNewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private fun searchNews(query: String): Flow<PagingData<ArticlesItem>> =
        repository.getSearchResultStream(query)
            .cachedIn(viewModelScope)
}