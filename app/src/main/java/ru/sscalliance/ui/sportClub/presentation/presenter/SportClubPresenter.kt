package ru.sscalliance.ui.sportClub.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.sportClub.interactor.ISportClubInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sportClub.presentation.view.ISportClubFragment
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface ISportClubPresenter<V: ISportClubFragment, I: ISportClubInteractor> : IMvpPresenter<V,I> {
    fun getSportClub(): Any?
}

class SportClubPresenter<V: ISportClubFragment, I: ISportClubInteractor> @Inject constructor(
    disposable: CompositeDisposable,
    scheduleProvider: IScheduleProvider,
    interactor: I
) : BasePresenter<V, I>(
    compositeDisposable = disposable,
    scheduleProvider = scheduleProvider,
    interactor = interactor
), ISportClubPresenter<V, I> {

    override fun getSportClub(): Any? = view?.let { view ->
        interactor.let {
            compositeDisposable.add(
                interactor.getSportClub()
                    .compose(scheduleProvider.ioToMainObservableScheduler())
                    .doOnSubscribe { view.showProgress() }
                    .doFinally { view.hideProgress() }
                    .subscribe({ items ->
                        view.getSportClub(items)
                    }, ::handleError)
            )
        }
    }
}

