package ru.sscalliance.ui.sport.presentation.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import ru.sscalliance.R
import ru.sscalliance.databinding.ItemSectionBinding
import ru.sscalliance.domain.sport.model.SectionBusinessModel

class SectionDelegateAdapter(action: (SectionBusinessModel) -> Unit) :
    ViewBindingDelegateAdapter<SectionBusinessModel, ItemSectionBinding>(ItemSectionBinding::inflate) {

    override fun ItemSectionBinding.onBind(item: SectionBusinessModel) {
        itemSectionTitle.text = item.title
        root.setOnClickListener {

        }
        Glide.with(root)
            .load(item.logo)
            .transform(
                MultiTransformation(
                    CenterCrop()
                )
            )
            .error(
                Glide
                    .with(root)
                    .load(R.drawable.photo_tect_1)
                    .apply(RequestOptions().centerCrop())
            )
            .into(itemSectionLogo)
    }

    override fun isForViewType(item: Any): Boolean = item is SectionBusinessModel

    override fun SectionBusinessModel.getItemId(): Any = title
}