package ru.sscalliance.data.news.remote

import ru.sscalliance.data.base.BaseCloudDataSource
import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.domain.news.NewsBusinessModel
import javax.inject.Inject

interface INewsRemoteDataSource {
    suspend fun getNews(request: NewsRequest): List<NewsBusinessModel>
}

class NewsRemoteDataSource @Inject constructor(

) : INewsRemoteDataSource, BaseCloudDataSource() {

    override suspend fun getNews(request: NewsRequest): List<NewsBusinessModel> {
        val result = api.getNews(request)?.map(NewsNetToUIMapper::map)
        return result.orEmpty()
    }

}