package ru.sscalliance.data.news.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class NewsResponse(
    @SerializedName("id") val id: String,
    @SerializedName("description") val description: String = "",
    @SerializedName("title") val title: String,
    @SerializedName("gallery") val image: List<String> = emptyList(),
    @SerializedName("date") val publicationDate: Date = Date(),
    @SerializedName("photoPreview") val photoPreview: String,
    )

// todo delete
data class NewsItemResponse(
    @SerializedName("id") val id: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("image") val image: String = "",
    @SerializedName("publicationDate") val publicationDate: String = "",
    @SerializedName("tag") val tag: String = "",
)