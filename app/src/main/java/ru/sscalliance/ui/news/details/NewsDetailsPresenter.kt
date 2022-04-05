package ru.sscalliance.ui.news.details

import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import javax.inject.Inject

interface INewsDetailsPresenter<V : INewsDetailsActivity> : IPresenter<V> {

}

class NewsDetailsPresenter<V : INewsDetailsActivity> @Inject constructor() :
    BasePresenter<V>(), INewsDetailsPresenter<V> {

}