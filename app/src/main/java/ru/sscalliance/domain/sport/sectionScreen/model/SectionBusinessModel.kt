package ru.sscalliance.domain.sport.sectionScreen.model

import android.os.Parcelable
import io.realm.annotations.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class SectionBusinessModel(
    var id: String = "",
    var title: String = "",
    var logo: String = "",
    var description: String = "",
    var address: String = "",
    var schedule: List<String> = listOf()
): Parcelable
