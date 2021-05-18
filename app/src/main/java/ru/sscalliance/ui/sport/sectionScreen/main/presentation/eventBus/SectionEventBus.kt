package ru.sscalliance.ui.sport.sectionScreen.main.presentation.eventBus

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.ui.base.eventBus.RxEventBus

class SectionEventBus {

    private val sectionTypeEventBus = RxEventBus<SectionType>()

    fun sendSectionType(sectionType: SectionType) =
        sectionTypeEventBus.onNext(sectionType)

    fun listenSectionType(): Observable<SectionType> =
        sectionTypeEventBus.listen()

}