package ru.sscalliance.data.sport.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.model.SportBusinessModel
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

class SportRepository @Inject constructor(

): ISportRepository {
    override fun getSport(): Observable<List<SportBusinessModel>> {
        val model = SportBusinessModel("2")
        return Observable.just(
            listOf(
                model, model, model, model
            )
        )
    }
}


