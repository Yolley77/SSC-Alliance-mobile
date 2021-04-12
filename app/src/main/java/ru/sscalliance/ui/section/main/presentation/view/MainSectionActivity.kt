package ru.sscalliance.ui.section.main.presentation.view

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.ActivityMainSectionBinding
import ru.sscalliance.domain.section.main.interactor.IMainSectionInteractor
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.section.main.presentation.adapter.SectionPagerAdapter
import ru.sscalliance.ui.section.main.presentation.presenter.IMainSectionPresenter
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface IMainSectionActivity : IMvpView {
    fun setCurrentSection(number: Int)
}

@AndroidEntryPoint
class MainSectionActivity : BaseActivity(R.layout.activity_main), IMainSectionActivity {

    @Inject
    lateinit var presenter: IMainSectionPresenter<IMainSectionActivity, IMainSectionInteractor>

    private lateinit var binding: ActivityMainSectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        binding = ActivityMainSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpSectionsPager.adapter = SectionPagerAdapter(this)
        TabLayoutMediator(binding.tlSections, binding.vpSectionsPager) { tab, position ->
            tab.text = SectionUtils.getSectionNameByPosition(position, baseContext)
        }.attach()
        presenter.configureViews()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun setCurrentSection(number: Int) {
        binding.vpSectionsPager.currentItem = number
    }

}