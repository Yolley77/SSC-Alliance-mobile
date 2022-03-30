package ru.sscalliance.data.network

import retrofit2.Response
import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.data.news.remote.model.NewsResponse
import javax.inject.Inject

interface IApiHelper {
    suspend fun getNews(request: NewsRequest): List<NewsResponse>?
}

class ApiHelper @Inject constructor(private val service: ApiService) : IApiHelper {

    override suspend fun getNews(request: NewsRequest): List<NewsResponse>? {
        return handleResponse(service.getNews())
    }

    private fun <T> handleResponse(response: Response<T>): T? {
        return if (response.isSuccessful) response.body()
        else null
    }

}