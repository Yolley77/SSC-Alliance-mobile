package ru.sscalliance.data.news.cloud.model

import com.google.gson.annotations.Expose
import com.squareup.moshi.Json

data class NewsRequest(
    val start: Int
)