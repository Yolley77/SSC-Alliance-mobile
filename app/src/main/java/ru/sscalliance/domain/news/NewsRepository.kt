package ru.sscalliance.domain.news

interface INewsRepository {
    fun getNews(): List<NewsBusinessModel>
}
