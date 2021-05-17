package ru.sscalliance.domain.sport.sectionScreen.certain.repository

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionRequestParams

interface ISectionRepository {
    fun getSectionsInfo(sectionRequest: SectionRequestParams): Single<SectionBusinessModel>
    fun getNews(): Observable<List<NewsBusinessModel>>
}