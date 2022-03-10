package ru.sscalliance.ui.news.main.presentation

import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import javax.inject.Inject

interface INewsPresenter<V : INewsFragment, I : INewsInteractor> : IMvpPresenter<V, I> {
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
