package ru.sscalliance.data.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.news.local.source.INewsLocalDataSource
import ru.sscalliance.data.news.local.source.NewsLocalDataSource
import ru.sscalliance.data.news.remote.source.INewsRemoteDataSource
import ru.sscalliance.data.news.remote.source.NewsRemoteDataSource
import ru.sscalliance.data.news.repository.NewsRepository
import ru.sscalliance.domain.news.main.repository.INewsRepository

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