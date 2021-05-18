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
            "Новости секции по футболу",
            "image",
            "20/05/2021",
            "#мирэаспортфамили"
        )
        val model2 = NewsBusinessModel(
            "2",
            "Новости секции по баскетболу",
            "https://sun9-28.userapi.com/impg/bt9XrbuavpQcY8DdtvQMnBUJkSTabbX4cdFN1A/zvdSVVfoxf8.jpg?size=2560x1707&quality=96&sign=a5c5dec96796f7ab42dde8cebddf2f69&type=album",
            "25/05/2021",
            "#баскетбол"
        )
        val model3 = NewsBusinessModel(
            "3",
            "Новости секции по волейболу",
            "https://sun9-33.userapi.com/impg/yA1tzCE3O_unf5IBILN4tsmPsYI7zVy_01GumQ/Gadbf29OLZo.jpg?size=1919x1080&quality=96&sign=3799bbf349daadc2ff88d72367047929&type=album",
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