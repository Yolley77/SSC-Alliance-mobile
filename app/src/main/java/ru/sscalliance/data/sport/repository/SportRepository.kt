package ru.sscalliance.data.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.EventBusiness
import ru.sscalliance.domain.sport.model.SectionBusiness
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

class SportRepository @Inject constructor(

): ISportRepository {
    override fun getSections(): Observable<List<SectionBusiness>> {
        val model = SectionBusiness("2")
        return Observable.just(
            listOf(
                    model, model, model, model
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


