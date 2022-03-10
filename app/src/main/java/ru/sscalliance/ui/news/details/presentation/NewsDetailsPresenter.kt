package ru.sscalliance.ui.news.details.presentation

import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import javax.inject.Inject

interface INewsDetailsPresenter<V : INewsDetailsActivity, I : INewsInteractor> : IMvpPresenter<V, I> {

}

class NewsDetailsPresenter<V : INewsDetailsActivity, I : INewsInteractor> @Inject constructor(
    interactor: I
) : BasePresenter<V, I>(
    interactor
), INewsDetailsPresenter<V, I> {

}