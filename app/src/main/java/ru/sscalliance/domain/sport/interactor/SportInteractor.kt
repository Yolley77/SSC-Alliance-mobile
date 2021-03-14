package ru.sscalliance.domain.sport.interactor

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.MvpInteractor
import ru.sscalliance.domain.sport.model.SportBusinessModel
import ru.sscalliance.domain.sport.repository.ISportRepository
import javax.inject.Inject

interface ISportInteractor: MvpInteractor {
    fun getSport(): Observable<List<SportBusinessModel>>
}

class SportInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: ISportRepository
): ISportInteractor, BaseInteractor() {

    override fun getSport(): Observable<List<SportBusinessModel>> {
        return repository.getSport()
    }
}

