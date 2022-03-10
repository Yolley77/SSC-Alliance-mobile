package ru.sscalliance.data.news.repository

import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.data.news.local.source.INewsLocalDataSource
import ru.sscalliance.data.news.remote.source.INewsRemoteDataSource
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.news.repository.INewsRepository
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsCloud: INewsRemoteDataSource,
    private val newsCache: INewsLocalDataSource
) : INewsRepository {

    override fun getNews(): List<NewsBusinessModel> {
        return newsCloud.getNews(NewsRequest(0))
    }

}
