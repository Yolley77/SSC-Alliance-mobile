package ru.sscalliance.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.sscalliance.data.news.remote.model.NewsResponse
import ru.sscalliance.data.sport.eventScreen.remote.model.EventResponse
import ru.sscalliance.data.sport.sectionScreen.remote.model.SectionResponse
import ru.sscalliance.data.team.remote.model.TeamResponse

interface ApiService {

    @GET("events")
    suspend fun getEvents(): Response<List<EventResponse>?>

    @GET("posts")
    suspend fun getNews(): Response<List<NewsResponse>?>

    @GET("sections")
    suspend fun getSections(): Response<List<SectionResponse>?>

    @GET("teams")
    suspend fun getTeams(): Response<List<TeamResponse>?>

}