package ru.sscalliance.domain.team.repository

import ru.sscalliance.domain.team.model.TeamBusinessModel

interface ITeamRepository {
    fun getTeam(): List<TeamBusinessModel>
}

