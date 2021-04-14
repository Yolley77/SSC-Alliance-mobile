package ru.sscalliance.data.news.remote.model

import com.google.gson.annotations.Expose
import com.squareup.moshi.Json

data class NewsResponse(
    @Expose @Json(name = "status") val status: String,
    @Expose @Json(name = "data") val data: List<NewsItemResponse>
)

data class NewsItemResponse(
    @Expose @Json(name = "id") val id: String = "",
    @Expose @Json(name = "title") val title: String = "",
    @Expose @Json(name = "image") val image: String = "",
    @Expose @Json(name = "publicationDate") val publicationDate: String = "",
    @Expose @Json(name = "tag") val tag: String = "",
)