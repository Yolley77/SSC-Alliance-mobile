package ru.sscalliance.data.news.remote.source

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.base.BaseCloudDataSource
import ru.sscalliance.data.news.remote.mapper.NewsNetToUIMapper
import ru.sscalliance.data.news.remote.model.NewsRequest
import ru.sscalliance.domain.news.model.NewsBusinessModel
import javax.inject.Inject

interface INewsRemoteDataSource {
    fun getNews(request: NewsRequest): Observable<List<NewsBusinessModel>>
}

class NewsRemoteDataSource @Inject constructor(

) : INewsRemoteDataSource, BaseCloudDataSource() {
    override fun getNews(request: NewsRequest): Observable<List<NewsBusinessModel>> {
        api.getNews(request).map { it.data.map { NewsNetToUIMapper::map } }

        val model1 = NewsBusinessModel(
            "1",
            "Секция по футболу",
            "image",
            "20/05/2021",
            "#мирэаспортфамили"
        )
        val model2 = NewsBusinessModel(
            "2",
            "Секция по баскетболу",
            "image",
            "25/05/2021",
            "#баскетбол"
        )
        val model3 = NewsBusinessModel(
            "3",
            "Секция по волейболу",
            "image",
            "30/06/2021",
            "#волейбол"
        )
        return Observable.just(
            listOf(
                model1, model2, model3
            )
        )
    }

}