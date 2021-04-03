package ru.sscalliance.data.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.news.database.source.INewsStorageDataSource
import ru.sscalliance.data.news.database.source.NewsStorageDataSource
import ru.sscalliance.data.news.cloud.source.INewsCloudDataSource
import ru.sscalliance.data.news.cloud.source.NewsCloudDataSource

@Module
@InstallIn(FragmentComponent::class)
abstract class NewsRepositoryModule {

    @Binds
    abstract fun bindNewsCacheDataSource(impl: NewsStorageDataSource): INewsStorageDataSource

    @Binds
    abstract fun bindsNewsCloudDataSource(impl: NewsCloudDataSource): INewsCloudDataSource

}