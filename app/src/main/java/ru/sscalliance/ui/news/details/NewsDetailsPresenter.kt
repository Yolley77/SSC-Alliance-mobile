package ru.sscalliance.ui.news.details

import ru.sscalliance.domain.news.INewsInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import javax.inject.Inject

interface INewsDetailsPresenter<V : INewsDetailsActivity, I : INewsInteractor> : IPresenter<V, I> {

}

class NewsDetailsPresenter<V : INewsDetailsActivity, I : INewsInteractor> @Inject constructor(
    interactor: I
) : BasePresenter<V, I>(
    interactor
), INewsDetailsPresenter<V, I> {

}