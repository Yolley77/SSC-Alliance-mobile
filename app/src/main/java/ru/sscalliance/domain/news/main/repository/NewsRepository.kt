package ru.sscalliance.domain.news.main.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.news.main.model.NewsBusinessModel

interface INewsRepository {
    fun getNews(): Observable<List<NewsBusinessModel>>
}
