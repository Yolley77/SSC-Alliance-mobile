package ru.sscalliance.domain.sport.mainScreen.interactor

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.SectionPreviewBusinessModel
import ru.sscalliance.domain.sport.mainScreen.repository.ISportRepository
import javax.inject.Inject

interface ISportInteractor : IMvpInteractor {
    fun getSections(): Observable<List<SectionPreviewBusinessModel>>
    fun getEvents(): Observable<List<EventBusinessModel>>
}

class SportInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: ISportRepository
) : ISportInteractor, BaseInteractor() {

    override fun getSections(): Observable<List<SectionPreviewBusinessModel>> {
        // create algorithm for sections init
        // and how set logo by name
        val model1 = SectionPreviewBusinessModel("Футбол", SectionType.FOOTBALL)
        val model2 = SectionPreviewBusinessModel("Волейбол", SectionType.VOLLEYBALL)
        val model3 = SectionPreviewBusinessModel("Баскетбол", SectionType.BASKETBALL)
        val model4 = SectionPreviewBusinessModel("Шахматы", SectionType.CHESS)
        val model5 = SectionPreviewBusinessModel("Настольный теннис", SectionType.PING_PONG)
        val model6 = SectionPreviewBusinessModel("Бадминтон", SectionType.BADMINTON)
        return Observable.just(
            listOf(
                model1, model2, model3, model4, model5, model6
            )
        )
    }

    override fun getEvents(): Observable<List<EventBusinessModel>> {
        return repository.getEvents()
    }
}

