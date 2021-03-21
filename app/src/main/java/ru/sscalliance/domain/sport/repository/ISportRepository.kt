package ru.sscalliance.domain.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.EventBusinessModel
import ru.sscalliance.domain.sport.model.SectionBusinessModel

interface ISportRepository {

    fun getSections(): Observable<List<SectionBusinessModel>>
    fun getEvents(): Observable<List<EventBusinessModel>>

}
