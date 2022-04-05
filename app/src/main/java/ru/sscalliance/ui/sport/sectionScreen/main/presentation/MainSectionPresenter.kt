package ru.sscalliance.ui.sport.sectionScreen.main.presentation

import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.base.view.IView
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface IMainSectionPresenter<V : IView> : IPresenter<V> {
    fun configureViews()
}

class MainSectionPresenter<V : IMainSectionActivity> @Inject constructor() :
    BasePresenter<V>(), IMainSectionPresenter<V> {

    override fun configureViews() {
        val index = SectionUtils.getSectionPositionByType(SectionType.FOOTBALL)
        view?.setCurrentSection(index)
    }

}