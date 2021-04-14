package ru.sscalliance.data.base

import ru.sscalliance.data.network.IApiHelper
import javax.inject.Inject

open class BaseCloudDataSource {

    @Inject
    lateinit var api: IApiHelper

}