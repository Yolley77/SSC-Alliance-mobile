package ru.sscalliance.ui.news.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.sscalliance.R
import ru.sscalliance.databinding.ItemNewsBinding
import ru.sscalliance.ui.base.adapter.BaseAdapter
import ru.sscalliance.ui.base.adapter.BaseViewHolder

class NewsAdapter<NewsBusinessModel>
    : BaseAdapter<ru.sscalliance.domain.news.model.NewsBusinessModel>() {

    private lateinit var binding: ItemNewsBinding

    var onItemClick: (NewsBusinessModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return super.onCreateViewHolder(parent, viewType)
    }

    override fun getItemResId(viewType: Int): Int = R.layout.item_news

    override fun getViewHolder(view: View, viewType: Int): BaseViewHolder = NewsViewHolder(view)

    inner class NewsViewHolder(itemView: View) : BaseViewHolder(itemView) {

        override fun bind(position: Int) {
            val newsItem = data[position]
            binding.itemNewsTitle.text = newsItem.title
            binding.itemNewsPublicationDate.text = newsItem.publicationDate
            binding.itemNewsTag.text = newsItem.tag
        }

    }

}
