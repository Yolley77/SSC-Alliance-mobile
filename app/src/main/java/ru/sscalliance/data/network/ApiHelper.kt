package ru.sscalliance.data.network

import io.reactivex.rxjava3.core.Observable
import retrofit2.HttpException
import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.data.news.remote.model.NewsResponse
import javax.inject.Inject

interface IApiHelper {
    fun getNews(request: NewsRequest): Observable<NewsResponse>
}

class ApiHelper @Inject constructor(private val service: ApiService) : IApiHelper {

    override fun getNews(request: NewsRequest): Observable<NewsResponse> =
        service.getNews(request.start)
            .flatMap { response ->
                when (response.isSuccessful) {
                    true -> Observable.just(response.body())
                    false -> Observable.error(HttpException(response))
                }
            }


}