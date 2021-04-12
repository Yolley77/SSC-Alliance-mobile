package ru.sscalliance.ui.section.certain.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.section.certain.interactor.ISectionInteractor
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.section.certain.presentation.view.ISectionFragment
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface ISectionPresenter<V : ISectionFragment, I : ISectionInteractor> {
    fun configureViews(type: SectionType): Any?
}

class SectionPresenter<V : ISectionFragment, I : ISectionInteractor> @Inject constructor(
    compositeDisposable: CompositeDisposable,
    scheduleProvider: IScheduleProvider,
    interactor: I,
) : BasePresenter<V, I>(
    compositeDisposable,
    scheduleProvider,
    interactor
), ISectionPresenter<V, I> {

    override fun configureViews(type: SectionType): Any? = getView()?.let { view ->
        compositeDisposable.add(
            interactor.getSectionInfo(type)
                .compose(scheduleProvider.ioToMainSingleScheduler())
                .doOnSubscribe { view.showProgress() }
                .doFinally { view.hideProgress() }
                .subscribe({ section ->
                    view.setInfo(section)
                }, this::handleError)
        )
    }

}