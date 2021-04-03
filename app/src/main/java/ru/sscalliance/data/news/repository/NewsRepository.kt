package ru.sscalliance.data.news.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.data.news.cloud.model.NewsRequest
import ru.sscalliance.data.news.database.source.INewsStorageDataSource
import ru.sscalliance.data.news.cloud.source.INewsCloudDataSource
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.news.repository.INewsRepository
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsCloud: INewsCloudDataSource,
    private val newsCache: INewsStorageDataSource
) : INewsRepository {

    override fun getNews(): Observable<List<NewsBusinessModel>> {
        newsCloud.getNews(NewsRequest(0))

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
