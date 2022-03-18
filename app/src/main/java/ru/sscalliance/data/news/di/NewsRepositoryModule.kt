package ru.sscalliance.data.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.data.news.local.INewsLocalDataSource
import ru.sscalliance.data.news.local.NewsLocalDataSource
import ru.sscalliance.data.news.remote.INewsRemoteDataSource
import ru.sscalliance.data.news.remote.NewsRemoteDataSource
import ru.sscalliance.data.news.NewsRepository
import ru.sscalliance.domain.news.INewsRepository

@Module
@InstallIn(ActivityComponent::class)
abstract class NewsRepositoryModule {

    @Binds
    abstract fun bindNewsCacheDataSource(impl: NewsLocalDataSource): INewsLocalDataSource

    @Binds
    abstract fun bindsNewsCloudDataSource(impl: NewsRemoteDataSource): INewsRemoteDataSource

    @Binds
    abstract fun bindNewsRepository(impl: NewsRepository): INewsRepository

}