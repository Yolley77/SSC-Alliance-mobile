package ru.sscalliance.ui.news.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.sscalliance.domain.news.INewsRepository
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import javax.inject.Inject

interface INewsPresenter<V : INewsFragment> : IPresenter<V> {
    fun getNews(isProgressVisible: Boolean = true)
    fun onItemClicked(item: NewsBusinessModel)
}

class NewsPresenter<V : INewsFragment> @Inject constructor(
    private val repository: INewsRepository
) : BasePresenter<V>(), INewsPresenter<V> {

    override fun getNews(isProgressVisible: Boolean) {
        launch {
            view?.run {
                if (isProgressVisible) showProgress()
                val result = withContext(Dispatchers.IO) { repository.getNews() }
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
