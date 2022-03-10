package ru.sscalliance.ui.news.main.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import ru.sscalliance.R
import ru.sscalliance.databinding.ItemNewsBinding
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.ui.base.adapter.BaseAdapter
import ru.sscalliance.ui.base.adapter.BaseViewHolder

class NewsAdapter(private val onItemClicked: (NewsBusinessModel) -> Unit) :
    BaseAdapter<NewsBusinessModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(binding)
    }

    inner class NewsViewHolder(private val itemBinding: ItemNewsBinding) :
        BaseViewHolder(itemBinding.root) {

        override fun bind(position: Int) {
            val newsItem = data[position]
            itemBinding.itemNewsTitle.text = newsItem.title
            itemBinding.itemNewsPublicationDate.text = newsItem.publicationDate
            itemBinding.itemNewsTag.text = newsItem.tag

            Glide.with(itemBinding.root)
                .load(newsItem.image)
                .apply(RequestOptions().centerCrop())
                /*.transform(
                    MultiTransformation(
                        CenterCrop(), RoundedCornersTransformation(40, 0)
                    )
                )*/
                .error(
                    Glide
                        .with(itemBinding.root)
                        .load(R.drawable.photo_test_1)
                        .apply(RequestOptions().centerCrop())
                )
                .into(itemBinding.itemNewsImage)

            itemBinding.root.setOnClickListener {
                onItemClicked.invoke(newsItem)
            }
        }
    }

}
