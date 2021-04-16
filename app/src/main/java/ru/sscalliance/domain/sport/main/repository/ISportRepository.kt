package ru.sscalliance.domain.sport.main.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.main.model.EventBusinessModel
import ru.sscalliance.domain.sport.main.model.SectionPreviewBusinessModel

interface ISportRepository {

    fun getSections(): Observable<List<SectionPreviewBusinessModel>>
    fun getEvents(): Observable<List<EventBusinessModel>>

}
