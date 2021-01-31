package ru.sscalliance.data.network

import javax.inject.Inject

interface IApiHelper {

}

class ApiHelper @Inject constructor(private val service: ApiService) : IApiHelper {

}