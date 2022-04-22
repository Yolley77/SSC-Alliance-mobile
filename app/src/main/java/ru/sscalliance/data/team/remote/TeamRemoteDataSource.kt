package ru.sscalliance.data.team.remote

import ru.sscalliance.data.base.BaseCloudDataSource
import ru.sscalliance.data.news.remote.NewsNetToUIMapper
import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.data.team.remote.model.TeamRequest
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.domain.team.model.TeamBusinessModel
import javax.inject.Inject


interface ITeamRemoteDataSource {
    suspend fun getTeam(request: TeamRequest): List<TeamBusinessModel>
}

class TeamRemoteDataSource @Inject constructor(

): ITeamRemoteDataSource, BaseCloudDataSource() {
    override suspend fun getTeam(request: TeamRequest): List<TeamBusinessModel> {
        val result = api.getTeams(request)?.map(TeamNetToUIMapper::map)
        return result.orEmpty()
    }
}