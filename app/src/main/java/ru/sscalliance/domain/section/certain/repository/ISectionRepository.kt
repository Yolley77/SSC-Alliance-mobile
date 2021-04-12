package ru.sscalliance.domain.section.certain.repository

import io.reactivex.rxjava3.core.Single
import ru.sscalliance.domain.section.model.SectionBusinessModel
import ru.sscalliance.domain.section.model.SectionRequestParams
import ru.sscalliance.domain.section.model.SectionType

interface ISectionRepository {
    fun getSectionsInfo(sectionRequest: SectionRequestParams): Single<SectionBusinessModel>
}