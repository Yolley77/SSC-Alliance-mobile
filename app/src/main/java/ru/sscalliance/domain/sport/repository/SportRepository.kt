package ru.sscalliance.domain.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.SportBusinessModel

interface ISportRepository {
    fun getSport(): Observable<List<SportBusinessModel>>
}
