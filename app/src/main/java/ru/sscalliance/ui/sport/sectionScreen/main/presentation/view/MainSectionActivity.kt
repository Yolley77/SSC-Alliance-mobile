package ru.sscalliance.ui.sport.sectionScreen.main.presentation.view

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.ActivityMainSectionBinding
import ru.sscalliance.domain.sport.sectionScreen.main.interactor.IMainSectionInteractor
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.adapter.SectionPagerAdapter
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.presenter.IMainSectionPresenter
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface IMainSectionActivity : IMvpView {
    fun setCurrentSection(number: Int)
}

@AndroidEntryPoint
class MainSectionActivity : BaseActivity<ActivityMainSectionBinding>(), IMainSectionActivity {

    @Inject
    lateinit var presenter: IMainSectionPresenter<IMainSectionActivity, IMainSectionInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        binding = ActivityMainSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpSectionsPager.adapter = SectionPagerAdapter(this)
        TabLayoutMediator(binding.tlSections, binding.vpSectionsPager) { tab, position ->
            tab.text = SectionUtils.getSectionNameByPosition(position, baseContext)
        }.attach()
        binding.vpSectionsPager.isUserInputEnabled = false
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