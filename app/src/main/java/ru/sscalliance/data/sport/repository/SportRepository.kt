package ru.sscalliance.data.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.EventBusiness
import ru.sscalliance.domain.sport.model.SectionBusiness
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

class SportRepository @Inject constructor(

): ISportRepository {
    override fun getSections(): Observable<List<SectionBusiness>> {
        val model1 = SectionBusiness("Секция по футболу", "image", "20/05/2021", "#мирэаспортфамили")
        val model2 = SectionBusiness("Секция по баскетболу", "image", "25/05/2021", "#баскетбол")
        val model3 = SectionBusiness("Секция по волейболу", "image", "30/06/2021", "#волейбол")
        return Observable.just(
                listOf(
                        model1, model2, model3
                )
        )
    }

    override fun getEvents(): Observable<List<EventBusiness>> {
        val model = EventBusiness("3")
        return Observable.just(
                listOf(
                        model
                )
        )
    }
}


