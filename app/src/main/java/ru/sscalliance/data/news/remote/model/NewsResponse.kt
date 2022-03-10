package ru.sscalliance.data.news.remote.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: List<NewsItemResponse>
)

data class NewsItemResponse(
    @SerializedName("id") val id: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("image") val image: String = "",
    @SerializedName("publicationDate") val publicationDate: String = "",
    @SerializedName("tag") val tag: String = "",
)