package ru.sscalliance.domain.sport.mainScreen.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.SectionPreviewBusinessModel

interface ISportRepository {

    fun getSections(): Observable<List<SectionPreviewBusinessModel>>
    fun getEvents(): Observable<List<EventBusinessModel>>

}
