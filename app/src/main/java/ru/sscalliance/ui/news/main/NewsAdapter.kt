package ru.sscalliance.ui.news.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import ru.sscalliance.R
import ru.sscalliance.databinding.ItemNewsBinding
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.ui.base.adapter.BaseAdapter
import ru.sscalliance.ui.base.adapter.BaseViewHolder

class NewsAdapter(private val onItemClicked: (NewsBusinessModel) -> Unit) :
    BaseAdapter<NewsBusinessModel>() {

    private var mediacontroller: MediaController? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)

        mediacontroller =
            MediaController(parent.context).apply { this.setAnchorView(binding.vvNews) }
        binding.vvNews.setMediaController(null)

        return NewsViewHolder(binding)
    }

    inner class NewsViewHolder(private val itemBinding: ItemNewsBinding) :
        BaseViewHolder(itemBinding.root) {

        override fun bind(position: Int) {
            val newsItem = data[position]
            itemBinding.itemNewsTitle.text = newsItem.title
            itemBinding.itemNewsPublicationDate.text = newsItem.publicationDate
            itemBinding.itemNewsTag.text = newsItem.tag

            itemBinding.itemNewsImage.isVisible = true
            itemBinding.vvNews.isVisible = false

            Glide.with(itemBinding.root)
                .load(newsItem.image)
                .apply(RequestOptions().centerCrop())
                .transform(
                    MultiTransformation(
                        CenterCrop(), RoundedCornersTransformation(40, 0)
                    )
                )
                .error(
                    Glide
                        .with(itemBinding.root)
                        .load(R.drawable.photo_test_1)
                        .apply(RequestOptions().centerCrop())
                        .transform(
                            MultiTransformation(
                                CenterCrop(), RoundedCornersTransformation(40, 0)
                            )
                        )
                )
                .into(itemBinding.itemNewsImage)

            if (newsItem.videoUrl.isNotBlank()) {
                itemBinding.vvNews.setVideoPath(newsItem.videoUrl)

                itemBinding.itemNewsImage.setOnTouchListener { view, _ ->
                    itemBinding.vvNews.isVisible = true
                    itemBinding.itemNewsImage.isVisible = false
                    itemBinding.vvNews.start()
                    true
                }
                itemBinding.vvNews.setOnCompletionListener {
                    itemBinding.vvNews.isVisible = false
                    itemBinding.itemNewsImage.isVisible = true
                }
            }

            itemBinding.root.setOnClickListener {
                itemBinding.vvNews.isVisible = false
                itemBinding.itemNewsImage.isVisible = true
                onItemClicked.invoke(newsItem)
            }
        }
    }

}
