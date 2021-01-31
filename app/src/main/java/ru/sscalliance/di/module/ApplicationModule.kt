package ru.sscalliance.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sscalliance.utils.INavigator
import ru.sscalliance.utils.Navigator
import ru.sscalliance.utils.ScheduleProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun bindContext(application: Application): Context

    @Binds
    @Singleton
    abstract fun bindNavigator(navigator: Navigator): INavigator

    @Binds
    @Singleton
    abstract fun bindScheduleProvider(scheduleProvider: ScheduleProvider): ScheduleProvider



}