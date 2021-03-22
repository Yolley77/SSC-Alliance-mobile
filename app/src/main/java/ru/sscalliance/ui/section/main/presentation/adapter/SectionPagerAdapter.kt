package ru.sscalliance.ui.section.main.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.sscalliance.ui.news.presentation.view.NewsFragment
import ru.sscalliance.ui.section.football.presentation.view.FootballFragment

class SectionPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewsFragment()
            1 -> FootballFragment()
            else -> FootballFragment()
        }
    }

}