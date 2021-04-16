package ru.sscalliance.ui.sport.main.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import ru.sscalliance.R
import ru.sscalliance.databinding.ItemEventBinding
import ru.sscalliance.domain.sport.main.model.EventBusinessModel
import ru.sscalliance.ui.base.adapter.BaseAdapter
import ru.sscalliance.ui.base.adapter.BaseViewHolder

class EventAdapter(private val onItemClicked: (EventBusinessModel) -> Unit) :
    BaseAdapter<EventBusinessModel>() {

    var onItemClick: (EventBusinessModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(layoutInflater, parent, false)
        return EventViewHolder(binding)
    }

    inner class EventViewHolder(private val itemBinding: ItemEventBinding) :
        BaseViewHolder(itemBinding.root) {

        override fun bind(position: Int) {
            val eventItem = data[position]
            itemBinding.itemEventTitle.text = eventItem.title
            itemBinding.itemEventPublicationDate.text = eventItem.publicationDate

            Glide.with(itemBinding.root)
                .load(eventItem.image)
                .transform(
                    MultiTransformation(
                        CenterCrop(), RoundedCornersTransformation(40, 0)
                    )
                )
                .error(
                    Glide
                        .with(itemBinding.root)
                        .load(R.drawable.photo_tect_1)
                        .apply(RequestOptions().centerCrop())
                )
                .into(itemBinding.itemEventImage)

            itemBinding.root.setOnClickListener {
                onItemClicked.invoke(eventItem)
            }
        }

    }

}