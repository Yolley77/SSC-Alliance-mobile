package ru.sscalliance.ui.sport.sectionScreen.main.presentation.presenter

import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.sport.sectionScreen.main.interactor.IMainSectionInteractor
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.base.view.IView
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.view.IMainSectionActivity
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface IMainSectionPresenter<V : IView, I : IMvpInteractor> : IPresenter<V, I> {
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