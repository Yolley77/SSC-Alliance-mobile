package ru.sscalliance.ui.news.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.news.presentation.view.INewsFragment
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface INewsPresenter<V: INewsFragment, I: INewsInteractor> : IMvpPresenter<V, I> {

}

class NewsPresenter<V: INewsFragment, I: INewsInteractor> @Inject constructor(
        disposable: CompositeDisposable,
        scheduleProvider: IScheduleProvider,
        interactor: I
) : BasePresenter<V, I>(
        compositeDisposable = disposable,
        scheduleProvider = scheduleProvider,
        interactor = interactor
), INewsPresenter<V, I> {

}