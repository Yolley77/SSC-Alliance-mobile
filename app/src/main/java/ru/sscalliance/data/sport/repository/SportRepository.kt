package ru.sscalliance.data.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.domain.sport.model.EventBusinessModel
import ru.sscalliance.domain.sport.model.SectionPreviewBusinessModel
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

class SportRepository @Inject constructor(

) : ISportRepository {
    override fun getSections(): Observable<List<SectionPreviewBusinessModel>> {
        val model1 = SectionPreviewBusinessModel("Футбол", "image", SectionType.FOOTBALL)
        val model2 = SectionPreviewBusinessModel("Баскетбол", "image", SectionType.BASKETBALL)
        val model3 = SectionPreviewBusinessModel("Волейбол", "image", SectionType.VOLLEYBALL)
        val model4 = SectionPreviewBusinessModel("Настольный теннис", "image", SectionType.PING_PONG)
        val model5 = SectionPreviewBusinessModel("Бадминтон", "image", SectionType.BADMINTON)
        val model6 = SectionPreviewBusinessModel("Шахматы", "image", SectionType.CHESS)
        return Observable.just(
            listOf(
                model1, model2, model3, model4, model5, model6
            )
        )
    }

    override fun getEvents(): Observable<List<EventBusinessModel>> {
        val model1 = EventBusinessModel("Секция по футболу", "image", "20/05/2021")
        val model2 = EventBusinessModel("Секция по баскетболу", "image", "25/05/2021")
        val model3 = EventBusinessModel("Секция по волейболу", "image", "30/06/2021")
        return Observable.just(
            listOf(
                model1, model2, model3
            )
        )
    }
}


