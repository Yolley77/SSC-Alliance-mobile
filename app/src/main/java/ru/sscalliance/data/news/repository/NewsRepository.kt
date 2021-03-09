package ru.sscalliance.data.news.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.news.repository.INewsRepository
import javax.inject.Inject

class NewsRepository @Inject constructor(

) : INewsRepository {

    override fun getNews(): Observable<List<NewsBusinessModel>> {
        val model = NewsBusinessModel("1")
        return Observable.just(
                listOf<NewsBusinessModel>(
                        model, model, model, model
                )
        )
    }

}
