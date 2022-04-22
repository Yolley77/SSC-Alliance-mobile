package ru.sscalliance.domain.sport.eventScreen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventBusinessModel(
    var id: String = "",
    var title: String = "",
    var description: String = "",
 //   var docs: List<String> = listOf(),
    var address: String = "",
    var eventDate: String = "",
   // var startTime: Double = 0.0
): Parcelable