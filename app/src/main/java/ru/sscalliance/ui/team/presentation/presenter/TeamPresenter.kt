package ru.sscalliance.ui.team.presentation.presenter

import ru.sscalliance.domain.team.interactor.ITeamInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.team.presentation.view.ITeamFragment
import javax.inject.Inject

interface ITeamPresenter<V : ITeamFragment> : IPresenter<V> {
    fun getTeam(): Any?
}

class TeamPresenter<V : ITeamFragment> @Inject constructor(
    private val interactor: ITeamInteractor,
) : BasePresenter<V>(), ITeamPresenter<V> {
    override fun getTeam(): Any? = view?.let { view ->
        interactor.let {
            view.getTeam(it.getTeam())
        }
    }
}


