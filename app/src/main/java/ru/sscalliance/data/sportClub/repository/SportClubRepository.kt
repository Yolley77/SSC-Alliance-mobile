package ru.sscalliance.data.sportClub.repository

import ru.sscalliance.domain.sportClub.model.SportClubBusinessModel
import ru.sscalliance.domain.sportClub.repository.ISportClubRepository
import javax.inject.Inject

class SportClubRepository @Inject constructor(

): ISportClubRepository {
    override fun getSportClub(): List<SportClubBusinessModel> {
        val model = SportClubBusinessModel("3")
        return listOf(
            model, model, model, model
        )
    }
}

