package ru.sscalliance.ui.team.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.FragmentTeamsBinding
import ru.sscalliance.domain.team.interactor.ITeamInteractor
import ru.sscalliance.domain.team.model.TeamBusinessModel
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IView
import ru.sscalliance.ui.team.presentation.presenter.TeamPresenter
import javax.inject.Inject

interface ITeamFragment: IView{
    fun getTeam(items: List<TeamBusinessModel>)
}

@AndroidEntryPoint
class TeamFragment : BaseFragment<FragmentTeamsBinding>(), ITeamFragment {

    @Inject
    lateinit var presenter: TeamPresenter<ITeamFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentTeamsBinding.inflate(layoutInflater)
        presenter.onAttach(this)
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun getTeam(items: List<TeamBusinessModel>) {
        TODO("Not yet implemented")
    }
}



