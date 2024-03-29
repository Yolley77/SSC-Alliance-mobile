package ru.sscalliance.domain.sportClub.interactor

import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.sportClub.model.SportClubBusinessModel
import ru.sscalliance.domain.sportClub.repository.ISportClubRepository
import javax.inject.Inject

interface ISportClubInteractor : IMvpInteractor {
    fun getSportClub(): List<SportClubBusinessModel>
}

class SportClubInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: ISportClubRepository
) : ISportClubInteractor, BaseInteractor() {
    override fun getSportClub(): List<SportClubBusinessModel> {
        return repository.getSportClub()
    }
}

