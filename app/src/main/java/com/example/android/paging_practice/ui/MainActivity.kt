package com.example.android.paging_practice.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.android.paging_practice.R
import com.example.android.paging_practice.api.NewsApiService
import com.example.android.paging_practice.repositories.NewsRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<SearchNewsViewModel> {
        ViewModelFactory(
            NewsRepository(
                NewsApiService.create()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adapter instance
        val pagingAdapter = GithubAdapter(NewsComparator)

        // recycler view instance
        val recyclerView = findViewById<RecyclerView>(R.id.list)

        // add the adapter
        recyclerView.adapter = pagingAdapter

        // launch get the data with coroutines
        lifecycleScope.launch {
            viewModel.searchNews("Android").collectLatest { news ->
                pagingAdapter.submitData(news)
            }
        }
    }
}