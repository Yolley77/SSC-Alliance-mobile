package ru.sscalliance.ui.section.certain.presentation

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.section.certain.interactor.ISectionInteractor
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.utils.IScheduleProvider
import javax.inject.Inject

interface ISectionPresenter<V : ISectionFragment, I : ISectionInteractor> {
    fun configureViews(type: SectionType): Any?
    fun onRegisterButtonClicked()

    // [Organizers Region]
    fun getSectionOrganizers()
    fun onOrganizerItemClicked()
    // [End Organizers Region]

    // [Photo Region]
    fun getSectionPhotos()
    fun onPhotoItemClicked()
    // [End Photo Region]

    // [News Region]
    fun getSectionNews()
    fun onNewsItemClicked(item: NewsBusinessModel)
    // [End News Region]
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

    override fun configureViews(type: SectionType): Any? = view?.let { view ->
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

    override fun getSectionOrganizers() {
        TODO("Not yet implemented")
    }

    override fun onOrganizerItemClicked() {
        TODO("Not yet implemented")
    }

    override fun getSectionPhotos() {
        TODO("Not yet implemented")
    }

    override fun onPhotoItemClicked() {
        TODO("Not yet implemented")
    }

    override fun getSectionNews() {
        interactor.let {
            compositeDisposable.add(
                interactor.getNews()
                    .compose(scheduleProvider.ioToMainObservableScheduler())
                    .doOnSubscribe { view?.showProgress() }
                    .doFinally { view?.hideProgress() }
                    .subscribe({ items ->
                        view?.setNewsInfo(items)
                    }, this::handleError)
            )
        }
    }

    override fun onNewsItemClicked(item: NewsBusinessModel) {
        view?.openNewsDetailsScreen(item)
    }

    override fun onRegisterButtonClicked() {

    }

}