package ru.sscalliance.ui.sport.eventDetails.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sport.eventDetails.presentation.view.IEventDetailsActivity
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface IEventDetailsPresenter<V : IEventDetailsActivity, I : ISportInteractor> :
    IMvpPresenter<V, I> {

}

class EventDetailsPresenter<V : IEventDetailsActivity, I : ISportInteractor> @Inject constructor(
    compositeDisposable: CompositeDisposable,
    scheduleProvider: IScheduleProvider,
    interactor: I
) : BasePresenter<V, I>(
    compositeDisposable,
    scheduleProvider,
    interactor
), IEventDetailsPresenter<V, I> {

}