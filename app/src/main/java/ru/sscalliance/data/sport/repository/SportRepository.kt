package ru.sscalliance.data.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.EventBusinessModel
import ru.sscalliance.domain.sport.model.SectionBusinessModel
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

class SportRepository @Inject constructor(

): ISportRepository {
    override fun getSections(): Observable<List<SectionBusinessModel>> {
        val model1 = SectionBusinessModel("Футбол", "image")
        val model2 = SectionBusinessModel("Баскетбол", "image")
        val model3 = SectionBusinessModel("Волейбол", "image")
        return Observable.just(
                listOf(
                        model1, model2, model3, model3, model3, model3
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


