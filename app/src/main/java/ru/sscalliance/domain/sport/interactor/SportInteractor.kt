package ru.sscalliance.domain.sport.interactor

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.MvpInteractor
import ru.sscalliance.domain.sport.model.EventBusiness
import ru.sscalliance.domain.sport.model.SectionBusiness
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

interface ISportInteractor: MvpInteractor {
    fun getSections(): Observable<List<SectionBusiness>>
    fun getEvents(): Observable<List<EventBusiness>>
}

class SportInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: ISportRepository
): ISportInteractor, BaseInteractor() {

    override fun getSections(): Observable<List<SectionBusiness>> {
        return repository.getSections()
    }

    override fun getEvents(): Observable<List<EventBusiness>> {
        return repository.getEvents()
    }
}

