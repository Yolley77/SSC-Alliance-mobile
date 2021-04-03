package ru.sscalliance.data.network

import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import ru.sscalliance.data.news.cloud.model.NewsRequest
import ru.sscalliance.data.news.cloud.model.NewsResponse
import ru.sscalliance.utils.AppConstants

interface ApiService {

    @GET(AppConstants.BASE_URL)
    fun getNews(@Query("start") start: Int): Observable<Response<NewsResponse>>

}