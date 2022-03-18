package ru.sscalliance.data.news.local

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.news.local.model.NewsStorageModel
import ru.sscalliance.domain.news.NewsBusinessModel

object NewsStorageToUIMapper : Mapper<NewsStorageModel, NewsBusinessModel> {
    override fun map(from: NewsStorageModel): NewsBusinessModel = NewsBusinessModel().apply {
        id = from.id
        title = from.title
        image = from.image
        publicationDate = from.publicationDate
        tag = from.tag
    }
}

object NewsUIToStorageMapper : Mapper<NewsBusinessModel, NewsStorageModel> {
    override fun map(from: NewsBusinessModel): NewsStorageModel = NewsStorageModel().apply {
        id = from.id
        title = from.title
        image = from.image
        publicationDate = from.publicationDate
        tag = from.tag
    }
}