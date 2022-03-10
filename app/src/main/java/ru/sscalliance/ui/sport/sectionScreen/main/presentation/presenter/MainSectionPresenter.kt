package ru.sscalliance.ui.sport.sectionScreen.main.presentation.presenter

import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.sport.sectionScreen.main.interactor.IMainSectionInteractor
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.view.IMainSectionActivity
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface IMainSectionPresenter<V : IMvpView, I : IMvpInteractor> : IMvpPresenter<V, I> {
    fun configureViews()
}

class MainSectionPresenter<V : IMainSectionActivity, I : IMainSectionInteractor> @Inject constructor(
    interactor: I,
) : BasePresenter<V, I>(
    interactor
), IMainSectionPresenter<V, I> {

    override fun configureViews() {
        val index = SectionUtils.getSectionPositionByType(SectionType.FOOTBALL)
        view?.setCurrentSection(index)
    }

}