package ru.sscalliance.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.sscalliance.data.news.remote.model.NewsResponse

interface ApiService {

    @GET("posts")
    suspend fun getNews(): Response<List<NewsResponse>?>

    @GET("sections")
    suspend fun getSections(): Response<List<Any>>

}