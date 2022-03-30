package ru.sscalliance.data.news.remote

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.news.remote.model.NewsResponse
import ru.sscalliance.domain.news.NewsBusinessModel
import java.text.SimpleDateFormat

object NewsNetToUIMapper : Mapper<NewsResponse, NewsBusinessModel> {
    override fun map(from: NewsResponse): NewsBusinessModel = NewsBusinessModel().apply {
        id = from.id
        title = from.title
        image = from.image.first()
        publicationDate = SimpleDateFormat.getDateInstance().format(from.publicationDate)
    }
}