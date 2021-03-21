package ru.sscalliance.ui.sport.presentation.adapter


import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.sscalliance.databinding.ItemSectionBinding
import ru.sscalliance.domain.sport.model.SectionBusinessModel

/*internal class SectionItemDelegate {

    fun sectionAdapterDelegate(itemClickedListener : (SectionBusinessModel) -> Unit)
    = adapterDelegateViewBinding<SectionBusinessModel, DisplayableItem, ItemSectionBinding>(
        { layoutInflater, root -> ItemSectionBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.root.setOnClickListener {
            itemClickedListener(item)
        }
        bind {
            binding.itemSectionTitle.text = item.title
        }
    }

}*/
