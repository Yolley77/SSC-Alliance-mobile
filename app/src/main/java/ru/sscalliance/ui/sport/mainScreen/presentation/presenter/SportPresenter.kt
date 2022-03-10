package ru.sscalliance.ui.sport.mainScreen.presentation.presenter

import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.domain.sport.mainScreen.interactor.ISportInteractor
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sport.mainScreen.presentation.view.ISportFragment
import javax.inject.Inject

interface ISportPresenter<V : ISportFragment, I : ISportInteractor> : IMvpPresenter<V, I> {
    fun getSections(): Any?
    fun onSectionClicked(itemType: SectionType)
    fun getEvents(): Any?
    fun onEventClicked(item: EventBusinessModel)
}

class SportPresenter<V : ISportFragment, I : ISportInteractor> @Inject constructor(
    interactor: I,
) : BasePresenter<V, I>(
    interactor = interactor
), ISportPresenter<V, I> {

    override fun getSections(): Any? = view?.let { view ->
        interactor.let {
            view.showSections(it.getSections())
        }
    }

    override fun getEvents(): Any? = view?.let { view ->
        interactor.let {
            view.showEvents(it.getEvents())
        }
    }

    override fun onSectionClicked(itemType: SectionType) {
        view?.openMainSectionsScreen()
    }

    override fun onEventClicked(item: EventBusinessModel) {
        view?.openEventDetailsScreen(item)
    }
}
