package ru.sscalliance.data.sport.mainScreen.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.SectionPreviewBusinessModel
import ru.sscalliance.domain.sport.mainScreen.repository.ISportRepository
import javax.inject.Inject

class SportRepository @Inject constructor(

) : ISportRepository {
    override fun getSections(): Observable<List<SectionPreviewBusinessModel>> {
        val model1 = SectionPreviewBusinessModel("Футбол", SectionType.FOOTBALL)
        val model2 = SectionPreviewBusinessModel("Баскетбол", SectionType.BASKETBALL)
        val model3 = SectionPreviewBusinessModel("Волейбол", SectionType.VOLLEYBALL)
        val model4 = SectionPreviewBusinessModel("Настольный теннис", SectionType.PING_PONG)
        val model5 = SectionPreviewBusinessModel("Бадминтон", SectionType.BADMINTON)
        val model6 = SectionPreviewBusinessModel("Шахматы", SectionType.CHESS)
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


