package ru.sscalliance.domain.sport.interactor

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.sport.model.EventBusinessModel
import ru.sscalliance.domain.sport.model.SectionBusinessModel
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

interface ISportInteractor: IMvpInteractor {
    fun getSections(): Observable<List<SectionBusinessModel>>
    fun getEvents(): Observable<List<EventBusinessModel>>
}

class SportInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: ISportRepository
): ISportInteractor, BaseInteractor() {

    override fun getSections(): Observable<List<SectionBusinessModel>> {
        return repository.getSections()
    }

    override fun getEvents(): Observable<List<EventBusinessModel>> {
        return repository.getEvents()
    }
}

