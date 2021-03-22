package ru.sscalliance.ui.sport.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import ru.sscalliance.R
import ru.sscalliance.databinding.ItemSectionBinding
import ru.sscalliance.domain.sport.model.SectionBusinessModel
import ru.sscalliance.ui.base.adapter.BaseAdapter
import ru.sscalliance.ui.base.adapter.BaseViewHolder

class SectionAdapter(private val onItemClicked: (SectionBusinessModel) -> Unit) :
    BaseAdapter<SectionBusinessModel>() {

    var onItemClick: (SectionBusinessModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSectionBinding.inflate(layoutInflater, parent, false)
        return SectionViewHolder(binding)
    }

    inner class SectionViewHolder(private val itemBinding: ItemSectionBinding) :
        BaseViewHolder(itemBinding.root) {

        override fun bind(position: Int) {
            val sectionItem = data[position]
            itemBinding.itemSectionTitle.text = sectionItem.title
            Glide.with(itemBinding.root)
                .load(sectionItem.logo)
                .transform(
                    MultiTransformation(
                        CenterCrop()
                    )
                )
                .error(
                    Glide
                        .with(itemBinding.root)
                        .load(R.drawable.photo_tect_1)
                        .apply(RequestOptions().centerCrop())
                )
                .into(itemBinding.itemSectionLogo)

            itemBinding.root.setOnClickListener {
                onItemClicked.invoke(sectionItem)
            }
        }

    }

}