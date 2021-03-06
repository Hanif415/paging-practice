package com.example.android.paging_practice.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.android.paging_practice.R
import com.example.android.paging_practice.api.ArticlesItem

/**
 * Paging data adapter, is used the same as recycler view adapter
 */
class GithubAdapter(differCallback: DiffUtil.ItemCallback<ArticlesItem>) :
    PagingDataAdapter<ArticlesItem, GithubViewHolder>(differCallback) {
    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        return GithubViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_view_item, parent, false)
        )
    }
}

object NewsComparator : DiffUtil.ItemCallback<ArticlesItem>() {
    override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
        return oldItem == oldItem
    }
}