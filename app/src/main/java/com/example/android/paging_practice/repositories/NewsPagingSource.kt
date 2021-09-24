package com.example.android.paging_practice.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android.paging_practice.api.ArticlesItem
import com.example.android.paging_practice.api.NewsApiService
import retrofit2.HttpException
import java.io.IOException

private const val GITHUB_STARTING_PAGE_INDEX = 1

class NewsPagingSource(private val service: NewsApiService, private val query: String) :
    PagingSource<Int, ArticlesItem>() {

    override fun getRefreshKey(state: PagingState<Int, ArticlesItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticlesItem> {

        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX

        return try {
            val response = service.getNews(query)
            val articles = response.articles
            val nextKey = if (articles.isEmpty()) {
                null
            } else {
                position + (params.loadSize / GITHUB_STARTING_PAGE_INDEX)
            }

            LoadResult.Page(
                data = articles,
                prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else -1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}