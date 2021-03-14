package ru.sscalliance.domain.team.interactor

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.MvpInteractor
import ru.sscalliance.domain.team.model.TeamBusinessModel
import ru.sscalliance.domain.team.repository.ITeamRepository
import javax.inject.Inject

interface ITeamInteractor: MvpInteractor {
    fun getTeam(): Observable<List<TeamBusinessModel>>
}

class TeamInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: ITeamRepository
): ITeamInteractor, BaseInteractor() {
    override fun getTeam(): Observable<List<TeamBusinessModel>> {
        return repository.getTeam()
    }
}