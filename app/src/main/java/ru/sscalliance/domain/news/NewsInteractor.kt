package ru.sscalliance.domain.news

import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import javax.inject.Inject

interface INewsInteractor : IMvpInteractor {
    suspend fun getNews(): List<NewsBusinessModel>
}

// TODO move preferences helper to domain

class NewsInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: INewsRepository
) : INewsInteractor, BaseInteractor() {

    override suspend fun getNews(): List<NewsBusinessModel> {
        return repository.getNews()
    }

}
