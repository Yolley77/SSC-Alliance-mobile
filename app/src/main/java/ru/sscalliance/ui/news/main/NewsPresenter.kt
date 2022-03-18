package ru.sscalliance.ui.news.main

import ru.sscalliance.domain.news.INewsInteractor
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import javax.inject.Inject

interface INewsPresenter<V : INewsFragment, I : INewsInteractor> : IPresenter<V, I> {
    fun getNews(): Any?
    fun onItemClicked(item: NewsBusinessModel)
}

class NewsPresenter<V : INewsFragment, I : INewsInteractor> @Inject constructor(
    interactor: I
) : BasePresenter<V, I>(
    interactor = interactor
), INewsPresenter<V, I> {

    override fun getNews(): Any? = view?.let { view ->
        interactor.let {
            view.showNews(it.getNews())
        }
    }

    override fun onItemClicked(item: NewsBusinessModel) {
        view?.openNewsDetailsScreen(item)
    }

}
