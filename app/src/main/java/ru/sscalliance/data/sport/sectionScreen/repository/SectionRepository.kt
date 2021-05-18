package ru.sscalliance.data.sport.sectionScreen.repository

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.certain.repository.ISectionRepository
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionRequestParams
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
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
                    description = "Описание секции по футболу",
                    type = SectionType.FOOTBALL,
                )
            AppConstants.VOLLEYBALL_REQUEST ->
                SectionBusinessModel(
                    id = "2",
                    title = "Волейбол",
                    description = "Описание секции по волейболу",
                    type = SectionType.VOLLEYBALL,
                )
            AppConstants.BASKETBALL_REQUEST ->
                SectionBusinessModel(
                    id = "3",
                    title = "Баскетбол",
                    description = "Описание секции по баскетболу",
                    type = SectionType.BASKETBALL,
                )
            AppConstants.CHESS_REQUEST ->
                SectionBusinessModel(
                    id = "4",
                    title = "Шахматы",
                    description = "Описание секции по шахматам",
                    type = SectionType.CHESS,
                )
            AppConstants.PING_PONG_REQUEST ->
                SectionBusinessModel(
                    id = "5",
                    title = "Теннис",
                    description = "Описание секции по настольному теннису",
                    type = SectionType.PING_PONG,
                )
            else -> SectionBusinessModel(
                id = "6",
                title = "Бадминтон",
                description = "Описание секции по бадминтону",
                type = SectionType.BADMINTON,
            )
        }

        return Single.just(
            section
        )
    }

    override fun getNews(): Observable<List<NewsBusinessModel>> {
        val model1 = NewsBusinessModel(
            "1",
            "Секция по футболу",
            "image",
            "20/05/2021",
            "#мирэаспортфамили"
        )
        val model2 = NewsBusinessModel(
            "2",
            "Секция по баскетболу",
            "image",
            "25/05/2021",
            "#баскетбол"
        )
        val model3 = NewsBusinessModel(
            "3",
            "Секция по волейболу",
            "image",
            "30/06/2021",
            "#волейбол"
        )
        return Observable.just(
            listOf(
                model1, model2, model3
            )
        )
    }
}