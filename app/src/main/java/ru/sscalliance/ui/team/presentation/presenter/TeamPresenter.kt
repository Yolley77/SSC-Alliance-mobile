package ru.sscalliance.ui.team.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.team.interactor.ITeamInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.team.presentation.view.ITeamFragment
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface ITeamPresenter<V: ITeamFragment, I: ITeamInteractor> : IMvpPresenter<V,I> {
    fun getTeam(): Any?
}

class TeamPresenter<V: ITeamFragment, I: ITeamInteractor> @Inject constructor(
        disposable: CompositeDisposable,
        scheduleProvider: IScheduleProvider,
        interactor: I
): BasePresenter<V,I> (
        compositeDisposable = disposable,
        scheduleProvider = scheduleProvider,
        interactor = interactor
), ITeamPresenter<V,I> {
    override fun getTeam(): Any? = getView()?.let{ view ->
        interactor.let {
            compositeDisposable.add(
                    interactor.getTeam()
                            .compose(scheduleProvider.ioToMainObservableScheduler())
                            .doOnSubscribe { view.showProgress() }
                            .doFinally { view.hideProgress() }
                            .subscribe({ items ->
                                view.getTeam(items)
                            }, { error->

                            })
            )
        }
    }
}


