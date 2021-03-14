package ru.sscalliance.ui.sport.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sport.presentation.view.ISportFragment
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface ISportPresenter<V: ISportFragment, I: ISportInteractor> : IMvpPresenter<V, I> {
    fun getSport(): Any?
}

class SportPresenter<V: ISportFragment, I: ISportInteractor> @Inject constructor(
    disposable: CompositeDisposable,
    scheduleProvider: IScheduleProvider,
    interactor: I
) : BasePresenter<V, I>(
    compositeDisposable = disposable,
    scheduleProvider = scheduleProvider,
    interactor = interactor
), ISportPresenter<V, I> {
    override fun getSport(): Any? = getView()?.let{ view ->
        interactor.let {
            compositeDisposable.add(
                interactor.getSport()
                    .compose(scheduleProvider.ioToMainObservableScheduler())
                    .doOnSubscribe { view.showProgress() }
                    .doFinally { view.hideProgress() }
                    .subscribe({ items ->
                        view.showSport(items)
                    }, { error ->
                    })
            )
        }
    }
}
