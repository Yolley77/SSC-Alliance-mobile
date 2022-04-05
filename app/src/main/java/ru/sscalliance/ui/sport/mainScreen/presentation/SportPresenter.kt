package ru.sscalliance.ui.sport.mainScreen.presentation

import kotlinx.coroutines.launch
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.domain.sport.mainScreen.interactor.ISportInteractor
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import javax.inject.Inject

interface ISportPresenter<V : ISportFragment> : IPresenter<V> {
    fun getSections(): Any?
    fun onSectionClicked(itemType: SectionType)
    fun getEvents()
    fun onEventClicked(item: EventBusinessModel)
}

class SportPresenter<V : ISportFragment> @Inject constructor(
    private val interactor: ISportInteractor,
) : BasePresenter<V>(), ISportPresenter<V> {

    override fun getSections(): Any? = view?.let { view ->
        interactor.let {
            view.showSections(it.getSections())
        }
    }

    override fun getEvents() {
        launch {
            view?.run {
                showProgress()
                showEvents(interactor.getEvents())
                hideProgress()
            }
        }

    }

    override fun onSectionClicked(itemType: SectionType) {
        view?.openMainSectionsScreen()
    }

    override fun onEventClicked(item: EventBusinessModel) {
        view?.openEventDetailsScreen(item)
    }
}
