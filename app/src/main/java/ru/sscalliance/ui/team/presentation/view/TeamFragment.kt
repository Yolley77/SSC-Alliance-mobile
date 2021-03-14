package ru.sscalliance.ui.team.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.domain.team.interactor.ITeamInteractor
import ru.sscalliance.domain.team.model.TeamBusinessModel
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.team.presentation.presenter.TeamPresenter
import javax.inject.Inject

interface ITeamFragment: IMvpView{
    fun getTeam(items: List<TeamBusinessModel>)
}

@AndroidEntryPoint
class TeamFragment: BaseFragment(R.layout.fragment_teams), ITeamFragment {

    @Inject
    lateinit var presenter: TeamPresenter<ITeamFragment, ITeamInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.bindView(this)
    }

    override fun onDestroyView() {
        presenter.unbindView()
        super.onDestroyView()
    }
    override fun getTeam(items: List<TeamBusinessModel>) {
        TODO("Not yet implemented")
    }
}



