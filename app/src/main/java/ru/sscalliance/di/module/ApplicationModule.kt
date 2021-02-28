package ru.sscalliance.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sscalliance.data.base.preferences.IPreferencesHelper
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.data.network.ApiHelper
import ru.sscalliance.data.network.IApiHelper
import ru.sscalliance.utils.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ApplicationModule {

    @Binds
    @Singleton
    fun bindContext(application: Application): Context

    @Binds
    @Singleton
    fun bindNavigator(navigator: Navigator): INavigator

    @Binds
    @Singleton
    fun bindsApiHelper(apiHelper: ApiHelper): IApiHelper

    @Binds
    fun bindsToastsHandler(toastsHandler: ToastsHandler): IToastsHandler

    @Binds
    @Singleton
    fun bindsPreferencesHelper(preferencesHelper: PreferencesHelper): IPreferencesHelper

}