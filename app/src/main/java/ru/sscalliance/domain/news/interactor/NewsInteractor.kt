package ru.sscalliance.domain.news.interactor

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.MvpInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.news.repository.INewsRepository
import javax.inject.Inject

interface INewsInteractor: MvpInteractor {
    fun getNews(): Observable<List<NewsBusinessModel>>
}

// TODO move preferences helper to domain

class NewsInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper,
    private val repository: INewsRepository
): INewsInteractor, BaseInteractor() {

    override fun getNews(): Observable<List<NewsBusinessModel>> {
        return repository.getNews()
    }

}
