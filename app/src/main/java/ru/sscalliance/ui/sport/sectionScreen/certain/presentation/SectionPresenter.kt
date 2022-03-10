package ru.sscalliance.ui.sport.sectionScreen.certain.presentation

import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.certain.interactor.ISectionInteractor
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.ui.base.presenter.BasePresenter
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
    interactor: I,
) : BasePresenter<V, I>(interactor), ISectionPresenter<V, I> {

    override fun configureViews(type: SectionType): Any? = view?.let { view ->
        view.setInfo(interactor.getSectionInfo(type))
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
            view?.setNewsInfo(interactor.getNews())
        }
    }

    override fun onNewsItemClicked(item: NewsBusinessModel) {
        view?.openNewsDetailsScreen(item)
    }

    override fun onRegisterButtonClicked() {
        TODO("Not yet implemented")
    }

}