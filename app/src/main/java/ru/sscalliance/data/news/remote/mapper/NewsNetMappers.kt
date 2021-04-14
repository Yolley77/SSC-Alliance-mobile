package ru.sscalliance.data.news.remote.mapper

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.news.remote.model.NewsItemResponse
import ru.sscalliance.domain.news.model.NewsBusinessModel

object NewsNetToUIMapper : Mapper<NewsItemResponse, NewsBusinessModel> {
    override fun map(from: NewsItemResponse): NewsBusinessModel = NewsBusinessModel().apply {
        id = from.id
        title = from.title
        image = from.image
        publicationDate = from.publicationDate
        tag = from.tag
    }
}