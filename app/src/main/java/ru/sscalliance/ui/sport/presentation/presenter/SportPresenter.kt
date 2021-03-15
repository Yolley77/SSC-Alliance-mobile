package ru.sscalliance.ui.sport.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sport.presentation.view.ISportFragment
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface ISportPresenter<V: ISportFragment, I: ISportInteractor> : IMvpPresenter<V, I> {
    fun getSections(): Any?
    fun getEvents(): Any?
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

    override fun getSections(): Any? = getView()?.let{ view ->
        interactor.let {
            compositeDisposable.add(
                    interactor.getSections()
                            .compose(scheduleProvider.ioToMainObservableScheduler())
                            .doOnSubscribe { view.showProgress() }
                            .doFinally { view.hideProgress() }
                            .subscribe({ items ->
                                view.showSections(items)
                            }, { error ->
                            })
            )
        }
    }

    override fun getEvents(): Any? = getView()?.let{ view ->
        interactor.let {
            compositeDisposable.add(
                    interactor.getEvents()
                            .compose(scheduleProvider.ioToMainObservableScheduler())
                            .doOnSubscribe { view.showProgress() }
                            .doFinally { view.hideProgress() }
                            .subscribe({ items ->
                                view.showEvents(items)
                            }, { error ->
                            })
            )
        }
    }
}
