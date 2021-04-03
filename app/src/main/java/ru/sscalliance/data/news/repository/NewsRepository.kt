package ru.sscalliance.data.news.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.news.repository.INewsRepository
import javax.inject.Inject

class NewsRepository @Inject constructor(

) : INewsRepository {

    override fun getNews(): Observable<List<NewsBusinessModel>> {
        val model1 = NewsBusinessModel(
            "Секция по футболу",
            "image",
            "20/05/2021",
            "#мирэаспортфамили"
        )
        val model2 = NewsBusinessModel("Секция по баскетболу", "image", "25/05/2021", "#баскетбол")
        val model3 = NewsBusinessModel("Секция по волейболу", "image", "30/06/2021", "#волейбол")
        return Observable.just(
            listOf(
                model1, model2, model3
            )
        )
    }

}
