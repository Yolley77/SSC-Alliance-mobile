package ru.sscalliance.ui.section.main.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.sscalliance.ui.section.section.presentation.view.SectionFragment

class SectionPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SectionFragment()
            1 -> SectionFragment()
            2 -> SectionFragment()
            3 -> SectionFragment()
            4 -> SectionFragment()
            else -> SectionFragment()
        }
    }

}