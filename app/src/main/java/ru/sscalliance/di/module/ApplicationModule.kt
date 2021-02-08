package ru.sscalliance.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import ru.sscalliance.data.base.preferences.IPreferencesHelper
import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.data.network.ApiHelper
import ru.sscalliance.data.network.IApiHelper
import ru.sscalliance.utils.*
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

    @Binds
    @Singleton
    abstract fun bindsApiHelper(apiHelper: ApiHelper): IApiHelper

    @Binds
    @Singleton
    abstract fun bindsCompositeDisposable(disposable: CompositeDisposable): CompositeDisposable

    @Binds
    @Singleton
    abstract fun bindsToastsHandler(toastsHandler: ToastsHandler): IToastsHandler

    @Binds
    @Singleton
    abstract fun bindsPreferencesHelper(preferencesHelper: PreferencesHelper): IPreferencesHelper

}