package ru.sscalliance.ui.section.main.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.section.main.interactor.IMainSectionInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.section.main.presentation.eventBus.SectionEventBus
import ru.sscalliance.ui.section.main.presentation.view.IMainSectionActivity
import ru.sscalliance.utils.IScheduleProvider
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface IMainSectionPresenter<V : IMvpView, I : IMvpInteractor> : IMvpPresenter<V, I> {
    fun configureViews()
}

class MainSectionPresenter<V : IMainSectionActivity, I : IMainSectionInteractor> @Inject constructor(
    disposable: CompositeDisposable,
    scheduleProvider: IScheduleProvider,
    interactor: I,
    private val sectionEventBus: SectionEventBus
) : BasePresenter<V, I>(
    disposable,
    scheduleProvider,
    interactor
), IMainSectionPresenter<V, I> {

    override fun configureViews() {
        compositeDisposable.add(
            sectionEventBus.listenSectionType()
                .subscribe({ type ->
                    val index = SectionUtils.getSectionPositionByType(type)
                    view?.setCurrentSection(index)
                }, this::handleError)
        )
    }

}