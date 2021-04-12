package ru.sscalliance.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.ui.section.main.presentation.eventBus.SectionEventBus
import ru.sscalliance.utils.IScheduleProvider
import ru.sscalliance.utils.ScheduleProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RxModule {

    @Provides
    fun provideScheduleProvider(): IScheduleProvider = ScheduleProvider()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    fun provideSectionEventBus(): SectionEventBus = SectionEventBus()

}