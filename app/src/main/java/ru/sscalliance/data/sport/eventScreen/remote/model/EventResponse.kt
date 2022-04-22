package ru.sscalliance.data.sport.eventScreen.remote.model

import com.google.gson.annotations.SerializedName

data class EventResponse (
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
 //   @SerializedName("docs") val docs: List<String>,
    @SerializedName("address") val address: String,
    @SerializedName("eventDate") val eventDate: String,
   // @SerializedName("startTime") val startTime: Double
)