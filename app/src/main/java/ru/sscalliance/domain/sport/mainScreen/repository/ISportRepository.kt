package ru.sscalliance.domain.sport.mainScreen.repository

import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.SectionPreviewBusinessModel

interface ISportRepository {

    fun getSections(): List<SectionPreviewBusinessModel>
    fun getEvents(): List<EventBusinessModel>

}
