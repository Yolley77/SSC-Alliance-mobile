package ru.sscalliance.domain.news

interface INewsRepository {
    suspend fun getNews(): List<NewsBusinessModel>
}
