package ru.sscalliance.ui.section.main.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.ui.section.certain.presentation.view.SectionFragment

class SectionPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = SectionType.values().size

    override fun createFragment(position: Int): Fragment {
        return SectionFragment(SectionType.values()[position])
    }

}