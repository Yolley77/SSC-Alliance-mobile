package ru.sscalliance.data.sportClub.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sportClub.model.SportClubBusinessModel
import ru.sscalliance.domain.sportClub.repository.ISportClubRepository
import javax.inject.Inject

class SportClubRepository @Inject constructor(

): ISportClubRepository {
    override fun getSportClub(): Observable<List<SportClubBusinessModel>> {
        val model = SportClubBusinessModel("3")
        return Observable.just(
            listOf(
                model, model, model, model
            )
        )
    }
}

