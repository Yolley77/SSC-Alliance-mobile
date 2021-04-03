package ru.sscalliance.data.news.cloud.mapper

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.news.cloud.model.NewsItemResponse
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