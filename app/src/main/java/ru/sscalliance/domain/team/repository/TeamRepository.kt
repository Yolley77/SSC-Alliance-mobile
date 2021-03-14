package ru.sscalliance.domain.team.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.team.model.TeamBusinessModel

interface ITeamRepository {
    fun getTeam(): Observable<List<TeamBusinessModel>>
}

