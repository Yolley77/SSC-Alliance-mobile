package ru.sscalliance.domain.news.repository

import io.reactivex.rxjava3.core.Observable
import ru.sscalliance.domain.news.model.NewsBusinessModel

interface INewsRepository {
    fun getNews(): Observable<List<NewsBusinessModel>>
}
