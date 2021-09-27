package com.example.android.paging_practice.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.paging_practice.repositories.NewsRepository

class ViewModelFactory(
    private var repository: NewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchNewsViewModel::class.java)) {
            @Suppress("UNCHECKED CAST")
            return SearchNewsViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}