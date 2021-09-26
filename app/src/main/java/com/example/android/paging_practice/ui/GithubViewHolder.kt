package com.example.android.paging_practice.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.paging_practice.R
import com.example.android.paging_practice.api.ArticlesItem

class GithubViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.news_title)
    private val description: TextView = view.findViewById(R.id.news_description)
    private val image: ImageView = view.findViewById(R.id.image_news)

    fun bind(news: ArticlesItem?) {
        if (news == null) {
            val resources = itemView.resources
            name.text = resources.getString(R.string.loading)
            description.text = resources.getString(R.string.loading)
            image.setImageResource(R.drawable.ic_broken_image)
        } else {
            name.text = news.title.toString()
            description.text = news.description.toString()
            image.load(news.urlToImage)
        }
    }
}
