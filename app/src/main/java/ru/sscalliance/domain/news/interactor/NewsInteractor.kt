package ru.sscalliance.domain.news.interactor

import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.news.repository.INewsRepository
import javax.inject.Inject

interface INewsInteractor : IMvpInteractor {
    fun getNews(): List<NewsBusinessModel>
}

// TODO move preferences helper to domain

class NewsInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: INewsRepository
) : INewsInteractor, BaseInteractor() {

    override fun getNews(): List<NewsBusinessModel> {
        return repository.getNews()
    }

}
