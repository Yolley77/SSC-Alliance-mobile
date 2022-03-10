package ru.sscalliance.data.network

import ru.sscalliance.data.news.remote.model.NewsItemResponse
import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.data.news.remote.model.NewsResponse
import javax.inject.Inject

interface IApiHelper {
    fun getNews(request: NewsRequest): NewsResponse?
}

class ApiHelper @Inject constructor(private val service: ApiService) : IApiHelper {

    override fun getNews(request: NewsRequest): NewsResponse? = NewsResponse("status", listOf(NewsItemResponse()))
        //service.getNews(request.start)

}