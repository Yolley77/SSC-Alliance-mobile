package ru.sscalliance.ui.team.presentation.presenter

import ru.sscalliance.domain.team.interactor.ITeamInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.team.presentation.view.ITeamFragment
import javax.inject.Inject

interface ITeamPresenter<V : ITeamFragment, I : ITeamInteractor> : IMvpPresenter<V, I> {
    fun getTeam(): Any?
}

class TeamPresenter<V : ITeamFragment, I : ITeamInteractor> @Inject constructor(
    interactor: I
) : BasePresenter<V, I>(
    interactor = interactor
), ITeamPresenter<V, I> {
    override fun getTeam(): Any? = view?.let { view ->
        interactor.let {
            view.getTeam(it.getTeam())
        }
    }
}


