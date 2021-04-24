package ru.sscalliance.domain.section.certain.interactor

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.section.certain.repository.ISectionRepository
import ru.sscalliance.domain.section.model.SectionBusinessModel
import ru.sscalliance.domain.section.model.SectionRequestParams
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface ISectionInteractor : IMvpInteractor {
    fun getSectionInfo(type: SectionType): Single<SectionBusinessModel>
    fun getNews(): Observable<List<NewsBusinessModel>>
}

class SectionInteractor @Inject constructor(
    private val repository: ISectionRepository
) : BaseInteractor(), ISectionInteractor {

    override fun getSectionInfo(type: SectionType): Single<SectionBusinessModel> {
        val sectionRequestPath = SectionUtils.getSectionRequestByType(type)
        return repository.getSectionsInfo(
            SectionRequestParams(
                request = sectionRequestPath
            )
        )
    }

    override fun getNews(): Observable<List<NewsBusinessModel>> {
        return repository.getNews()
    }

}