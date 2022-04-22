package ru.sscalliance.data.team.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class TeamResponse (
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("logo") val logo: String,
   // @SerializedName("trainingGallery") val trainingGallery: List<String> = emptyList(),
   // @SerializedName("trainingSchedule") val trainingSchedule: List<String> = emptyList(),
    @SerializedName("trainingAddress") val trainingAddress: String,
    @SerializedName("history") val history: String,
)