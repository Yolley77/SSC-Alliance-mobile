package ru.sscalliance.ui.sport.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.domain.sport.model.EventBusiness
import ru.sscalliance.domain.sport.model.SectionBusiness
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.presentation.presenter.SportPresenter
import javax.inject.Inject

interface ISportFragment: IMvpView {
    fun showSections(items: List<SectionBusiness>)
    fun showEvents(items: List<EventBusiness>)
}

@AndroidEntryPoint
class SportFragment: BaseFragment(R.layout.fragment_sport), ISportFragment {

    @Inject
    lateinit var presenter: SportPresenter<ISportFragment, ISportInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.bindView(this)
    }

    override fun onDestroyView() {
        presenter.unbindView()
        super.onDestroyView()
    }

    override fun showSections(items: List<SectionBusiness>) {
        TODO("Not yet implemented")
    }

    override fun showEvents(items: List<EventBusiness>) {
        TODO("Not yet implemented")
    }
}



