package ru.sscalliance.data.sport.sectionScreen.remote.model

import com.google.gson.annotations.SerializedName

data class SectionResponse (
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("description") val description: String,
    @SerializedName("address") val address: String,
    //@SerializedName("schedule") val schedule: List<String>
)