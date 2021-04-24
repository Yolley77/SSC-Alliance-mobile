package ru.sscalliance.ui.news.details.presentation

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface INewsDetailsPresenter<V : INewsDetailsActivity, I : INewsInteractor> : IMvpPresenter<V, I> {

}

class NewsDetailsPresenter<V : INewsDetailsActivity, I : INewsInteractor> @Inject constructor(
    compositeDisposable: CompositeDisposable,
    scheduleProvider: IScheduleProvider,
    interactor: I
) : BasePresenter<V, I>(
    compositeDisposable, scheduleProvider, interactor
), INewsDetailsPresenter<V, I> {

}