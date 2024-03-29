package ru.sscalliance.domain.team.interactor

import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.team.model.TeamBusinessModel
import ru.sscalliance.domain.team.repository.ITeamRepository
import javax.inject.Inject

interface ITeamInteractor: IMvpInteractor {
    fun getTeam(): List<TeamBusinessModel>
}

class TeamInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: ITeamRepository
) : ITeamInteractor, BaseInteractor() {
    override fun getTeam(): List<TeamBusinessModel> {
        return repository.getTeam()
    }
}