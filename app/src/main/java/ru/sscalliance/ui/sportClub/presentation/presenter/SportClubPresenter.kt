package ru.sscalliance.ui.sportClub.presentation.presenter

import ru.sscalliance.domain.sportClub.interactor.ISportClubInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.sportClub.presentation.view.ISportClubFragment
import javax.inject.Inject

interface ISportClubPresenter<V: ISportClubFragment, I: ISportClubInteractor> : IPresenter<V,I> {
    fun getSportClub(): Any?
}

class SportClubPresenter<V: ISportClubFragment, I: ISportClubInteractor> @Inject constructor(
    interactor: I
) : BasePresenter<V, I>(
    interactor = interactor
), ISportClubPresenter<V, I> {

    override fun getSportClub(): Any? = view?.let { view ->
        interactor.let {
            view.getSportClub(interactor.getSportClub())
        }
    }
}

