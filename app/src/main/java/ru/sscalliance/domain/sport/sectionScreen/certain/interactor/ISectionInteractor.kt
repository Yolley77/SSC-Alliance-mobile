package ru.sscalliance.domain.sport.sectionScreen.certain.interactor

import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.certain.repository.ISectionRepository
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionRequestParams
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface ISectionInteractor : IMvpInteractor {
    fun getSectionInfo(type: SectionType): SectionBusinessModel
    fun getNews(): List<NewsBusinessModel>
}

class SectionInteractor @Inject constructor(
    private val repository: ISectionRepository
) : BaseInteractor(), ISectionInteractor {

    override fun getSectionInfo(type: SectionType): SectionBusinessModel {
        val sectionRequestPath = SectionUtils.getSectionRequestByType(type)
        return repository.getSectionsInfo(
            SectionRequestParams(
                request = sectionRequestPath
            )
        )
    }

    override fun getNews(): List<NewsBusinessModel> {
        return repository.getNews()
    }

}