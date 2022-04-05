package ru.sscalliance.ui.news.main

import kotlinx.coroutines.launch
import ru.sscalliance.domain.news.INewsInteractor
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import javax.inject.Inject

interface INewsPresenter<V : INewsFragment> : IPresenter<V> {
    fun getNews()
    fun onItemClicked(item: NewsBusinessModel)
}

class NewsPresenter<V : INewsFragment> @Inject constructor(
    private val interactor: INewsInteractor,
) : BasePresenter<V>(), INewsPresenter<V> {

    override fun getNews() {
        launch {
            view?.run {
                showProgress()
                val result = interactor.getNews()
                showNews(result)
                stopRefreshing()
                hideProgress()
            }
        }
    }

    override fun onItemClicked(item: NewsBusinessModel) {
        view?.openNewsDetailsScreen(item)
    }

}
