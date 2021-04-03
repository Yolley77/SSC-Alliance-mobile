package ru.sscalliance.ui.section.main.presentation.view

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.ActivityMainSectionBinding
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.section.main.presentation.adapter.SectionPagerAdapter

interface IMainSectionActivity : IMvpView {

}

@AndroidEntryPoint
class MainSectionActivity : BaseActivity(R.layout.activity_main), IMainSectionActivity {

    private lateinit var binding: ActivityMainSectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpSectionsPager.adapter = SectionPagerAdapter(this)
        TabLayoutMediator(binding.tlSections, binding.vpSectionsPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Football"
                1 -> tab.text = "Basketball"
                2 -> tab.text = "Basketball"
                3 -> tab.text = "Basketball"
                4 -> tab.text = "Basketball"
                else -> tab.text = "Gaming"
            }
        }.attach()
    }

}