package ru.sscalliance.data.section.repository

import io.reactivex.rxjava3.core.Single
import ru.sscalliance.domain.section.certain.repository.ISectionRepository
import ru.sscalliance.domain.section.model.SectionBusinessModel
import ru.sscalliance.domain.section.model.SectionRequestParams
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.utils.AppConstants
import javax.inject.Inject

class SectionRepository @Inject constructor(

) : ISectionRepository {
    override fun getSectionsInfo(sectionRequest: SectionRequestParams): Single<SectionBusinessModel> {
        val section: SectionBusinessModel = when (sectionRequest.request) {
            AppConstants.FOOTBALL_REQUEST ->
                SectionBusinessModel(
                    id = "1",
                    title = "Футбол",
                    description = "DESCRIPTION",
                )
            AppConstants.VOLLEYBALL_REQUEST ->
                SectionBusinessModel(
                    id = "2",
                    title = "волейбол",
                    description = "DESCRIPTION",
                )
            AppConstants.BASKETBALL_REQUEST ->
                SectionBusinessModel(
                    id = "3",
                    title = "баскетбол",
                    description = "DESCRIPTION",
                )
            AppConstants.CHESS_REQUEST ->
                SectionBusinessModel(
                    id = "4",
                    title = "шахматы",
                    description = "шахматы",
                )
            AppConstants.PING_PONG_REQUEST ->
                SectionBusinessModel(
                    id = "5",
                    title = "теннис",
                    description = "натольный теннис",
                )
            else -> SectionBusinessModel(
                id = "6",
                title = "бадминтон",
                description = "бадминтон",
            )
        }

        return Single.just(
            section
        )
    }
}