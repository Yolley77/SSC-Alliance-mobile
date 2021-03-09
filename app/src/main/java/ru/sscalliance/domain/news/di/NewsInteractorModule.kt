package ru.sscalliance.domain.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.news.repository.NewsRepository
import ru.sscalliance.domain.news.repository.INewsRepository

// TODO think about di package and repository in data

@Module
@InstallIn(FragmentComponent::class)
abstract class NewsInteractorModule {

    @Binds
    abstract fun bindNewsRepository(impl: NewsRepository): INewsRepository

}
