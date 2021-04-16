package ru.sscalliance.domain.sport.main.interactor

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.domain.sport.main.model.EventBusinessModel
import ru.sscalliance.domain.sport.main.model.SectionPreviewBusinessModel
import ru.sscalliance.domain.sport.main.repository.ISportRepository
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
        return repository.getEvents()
    }
}

