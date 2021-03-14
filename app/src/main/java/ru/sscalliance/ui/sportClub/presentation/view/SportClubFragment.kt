package ru.sscalliance.ui.sportClub.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.domain.sportClub.interactor.ISportClubInteractor
import ru.sscalliance.domain.sportClub.model.SportClubBusinessModel
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sportClub.presentation.presenter.SportClubPresenter
import javax.inject.Inject

interface ISportClubFragment: IMvpView {
    fun getSportClub(items: List<SportClubBusinessModel>)
}

@AndroidEntryPoint
class SportClubFragment: BaseFragment(R.layout.fragment_sport_club), ISportClubFragment {

    @Inject
    lateinit var presenter: SportClubPresenter<ISportClubFragment, ISportClubInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.bindView(this)
    }

    override fun onDestroyView() {
        presenter.unbindView()
        super.onDestroyView()
    }
    override fun getSportClub(items: List<SportClubBusinessModel>) {
        TODO("Not yet implemented")
    }
}

