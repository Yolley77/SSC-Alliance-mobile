package ru.sscalliance.domain.news.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsBusinessModel(
    var id: String = "",
    var title: String = "",
    var image: String = "",
    var publicationDate: String = "",
    var tag: String = "",
) : Parcelable
