package ru.sscalliance.data.network

import retrofit2.Response
import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.data.news.remote.model.NewsResponse
import ru.sscalliance.data.sport.eventScreen.remote.model.EventRequest
import ru.sscalliance.data.sport.eventScreen.remote.model.EventResponse
import ru.sscalliance.data.sport.sectionScreen.remote.model.SectionRequest
import ru.sscalliance.data.sport.sectionScreen.remote.model.SectionResponse
import ru.sscalliance.data.team.remote.model.TeamRequest
import ru.sscalliance.data.team.remote.model.TeamResponse
import javax.inject.Inject

interface IApiHelper {
    suspend fun getNews(request: NewsRequest): List<NewsResponse>?
    suspend fun getSections(request: SectionRequest): List<SectionResponse>?
    suspend fun getEvents(request: EventRequest): List<EventResponse>?
    suspend fun getTeams(request: TeamRequest): List<TeamResponse>?
}

class ApiHelper @Inject constructor(private val service: ApiService) : IApiHelper {

    override suspend fun getNews(request: NewsRequest): List<NewsResponse>? {
        return handleResponse(service.getNews())
    }

    override suspend fun getSections(request: SectionRequest): List<SectionResponse>? {
        return handleResponse(service.getSections())
    }

    override suspend fun getEvents(request: EventRequest): List<EventResponse>? {
        return handleResponse(service.getEvents())
    }

    override suspend fun getTeams(request: TeamRequest): List<TeamResponse>? {
        return handleResponse(service.getTeams())
    }

    private fun <T> handleResponse(response: Response<T>): T? {
        return if (response.isSuccessful) response.body()
        else null
    }

}