package ru.sscalliance.domain.sport.sectionScreen.certain.repository

import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionRequestParams

interface ISectionRepository {
    fun getSectionsInfo(sectionRequest: SectionRequestParams): SectionBusinessModel
    fun getNews(): List<NewsBusinessModel>
}