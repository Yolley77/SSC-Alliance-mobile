package ru.sscalliance.domain.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.EventBusinessModel
import ru.sscalliance.domain.sport.model.SectionPreviewBusinessModel

interface ISportRepository {

    fun getSections(): Observable<List<SectionPreviewBusinessModel>>
    fun getEvents(): Observable<List<EventBusinessModel>>

}
