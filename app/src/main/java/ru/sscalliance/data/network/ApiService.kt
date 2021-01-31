package ru.sscalliance.data.network

import retrofit2.http.GET
import ru.sscalliance.utils.AppConstants

interface ApiService {

    @GET(AppConstants.BASE_URL)
    fun getNews()

}