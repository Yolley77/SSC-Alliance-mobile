package ru.sscalliance.ui.news.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.sscalliance.domain.news.INewsInteractor
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import javax.inject.Inject

interface INewsPresenter<V : INewsFragment> : IPresenter<V> {
    fun getNews(isProgressVisible: Boolean = true)
    fun onItemClicked(item: NewsBusinessModel)
}

class NewsPresenter<V : INewsFragment> @Inject constructor(
    private val interactor: INewsInteractor,
) : BasePresenter<V>(), INewsPresenter<V> {

    override fun getNews(isProgressVisible: Boolean) {
        launch {
            view?.run {
                if (isProgressVisible) showProgress()
                val result = withContext(Dispatchers.IO) { interactor.getNews() }
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
