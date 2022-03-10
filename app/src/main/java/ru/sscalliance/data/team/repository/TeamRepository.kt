package ru.sscalliance.data.team.repository

import ru.sscalliance.domain.team.model.TeamBusinessModel
import ru.sscalliance.domain.team.repository.ITeamRepository
import javax.inject.Inject

class TeamRepository @Inject constructor(

): ITeamRepository {
    override fun getTeam(): List<TeamBusinessModel> {
        val model = TeamBusinessModel("4")
        return listOf(
            model
        )
    }
}


