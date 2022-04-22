package ru.sscalliance.domain.team.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamBusinessModel (
    var id: String = "",
    var title: String = "",
    var logo: String = "",
    var trainingGallery: List<String> = listOf(),
    var trainingSchedule: List<String> = listOf(),
    var trainingAddress: String = "",
    var history: String = ""
): Parcelable