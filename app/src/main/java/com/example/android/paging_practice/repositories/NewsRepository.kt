package com.example.android.paging_practice.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android.paging_practice.api.ArticlesItem
import com.example.android.paging_practice.api.NewsApiService
import kotlinx.coroutines.flow.Flow

class NewsRepository(private val service: NewsApiService) {
    fun getSearchResultStream(query: String): Flow<PagingData<ArticlesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            )
        ) {
            NewsPagingSource(service, query)
        }.flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }
}