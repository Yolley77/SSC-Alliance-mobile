package ru.sscalliance.domain.news.repository

import ru.sscalliance.domain.news.model.NewsBusinessModel

interface INewsRepository {
    fun getNews(): List<NewsBusinessModel>
}
