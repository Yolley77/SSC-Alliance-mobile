package ru.sscalliance.domain.sport.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventBusinessModel(
    var title: String = "",
    var image: String = "",
    var publicationDate: String = "",
) : Parcelable