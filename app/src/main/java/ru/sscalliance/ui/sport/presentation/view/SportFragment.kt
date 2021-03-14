package ru.sscalliance.ui.sport.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.domain.sport.model.SportBusinessModel
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.presentation.presenter.SportPresenter
import javax.inject.Inject

interface ISportFragment: IMvpView {
    fun showSport(items: List<SportBusinessModel>)
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

    override fun showSport(items: List<SportBusinessModel>) {
        TODO("Not yet implemented")
    }
}



