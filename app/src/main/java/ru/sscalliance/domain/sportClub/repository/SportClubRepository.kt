package ru.sscalliance.domain.sportClub.repository

import ru.sscalliance.domain.sportClub.model.SportClubBusinessModel

interface ISportClubRepository {
    fun getSportClub(): List<SportClubBusinessModel>
}
