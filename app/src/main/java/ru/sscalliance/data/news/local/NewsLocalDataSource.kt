package ru.sscalliance.data.news.local

import ru.sscalliance.data.base.BaseCacheDataSource
import ru.sscalliance.data.network.ApiHelper
import ru.sscalliance.data.news.local.model.NewsStorageModel
import ru.sscalliance.domain.news.NewsBusinessModel
import javax.inject.Inject

interface INewsLocalDataSource {
    fun saveNews(news: List<NewsBusinessModel>)
    fun getNews(): List<NewsBusinessModel>
}

class NewsLocalDataSource @Inject constructor(
    private val apiHelper: ApiHelper,
) : INewsLocalDataSource, BaseCacheDataSource<NewsStorageModel>(NewsStorageModel::class.java) {

    override fun saveNews(news: List<NewsBusinessModel>) {
        TODO("Not yet implemented")
    }

    override fun getNews(): List<NewsBusinessModel> {
        TODO("Not yet implemented")
    }

}