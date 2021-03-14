package ru.sscalliance.data.team.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.team.model.TeamBusinessModel
import ru.sscalliance.domain.team.repository.ITeamRepository
import javax.inject.Inject

class TeamRepository @Inject constructor(

): ITeamRepository {
    override fun getTeam(): Observable<List<TeamBusinessModel>> {
        val model = TeamBusinessModel("4")
        return Observable.just(
            listOf(
                model
            )
        )
    }
}


