package ru.sscalliance.data.news.repository

import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.data.news.local.INewsLocalDataSource
import ru.sscalliance.data.news.remote.FakeData
import ru.sscalliance.data.news.remote.INewsRemoteDataSource
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.domain.news.INewsRepository
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsCloud: INewsRemoteDataSource,
    private val newsCache: INewsLocalDataSource
) : INewsRepository {

    override suspend fun getNews(): List<NewsBusinessModel> {
        return newsCloud.getNews(NewsRequest(0)).plus(FakeData.getNews())
    }

}
