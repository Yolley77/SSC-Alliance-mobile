package ru.sscalliance.domain.sportClub.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sportClub.model.SportClubBusinessModel

interface ISportClubRepository {
    fun getSportClub(): Observable<List<SportClubBusinessModel>>
}
