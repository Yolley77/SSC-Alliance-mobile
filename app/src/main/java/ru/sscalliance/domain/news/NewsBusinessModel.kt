package ru.sscalliance.domain.news

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsBusinessModel(
    var id: String = "",
    var title: String = "",
    var image: String = "",
    val videoUrl: String = "",
    var publicationDate: String = "",
    var tag: String = "",
) : Parcelable
