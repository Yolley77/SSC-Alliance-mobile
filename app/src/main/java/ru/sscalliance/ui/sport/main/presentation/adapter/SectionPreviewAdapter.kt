package ru.sscalliance.ui.sport.main.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sscalliance.databinding.ItemSectionBinding
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.domain.sport.model.SectionPreviewBusinessModel
import ru.sscalliance.ui.base.adapter.BaseAdapter
import ru.sscalliance.ui.base.adapter.BaseViewHolder
import ru.sscalliance.utils.SectionUtils

class SectionPreviewAdapter(
    private val onItemClicked: (SectionType) -> Unit,
    private val context: Context?
) :
    BaseAdapter<SectionPreviewBusinessModel>() {

    var onItemClick: (SectionPreviewBusinessModel) -> Unit = {}

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
            itemBinding.itemSectionLogo.background =
                SectionUtils.getSectionLogoByType(sectionItem.type, context)

            itemBinding.root.setOnClickListener {
                onItemClicked.invoke(sectionItem.type)
            }
        }

    }

}