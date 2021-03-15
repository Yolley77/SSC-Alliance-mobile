package ru.sscalliance.domain.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.EventBusiness
import ru.sscalliance.domain.sport.model.SectionBusiness

interface ISportRepository {
    fun getSections(): Observable<List<SectionBusiness>>
    fun getEvents(): Observable<List<EventBusiness>>
}
