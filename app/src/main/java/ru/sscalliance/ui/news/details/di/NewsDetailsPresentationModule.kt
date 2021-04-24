package ru.sscalliance.ui.news.details.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.ui.news.details.presentation.INewsDetailsActivity
import ru.sscalliance.ui.news.details.presentation.INewsDetailsPresenter
import ru.sscalliance.ui.news.details.presentation.NewsDetailsPresenter

@Module
@InstallIn(ActivityComponent::class)
abstract class NewsDetailsPresentationModule {

    @Binds
    abstract fun bindNewsDetailsPresenter(impl: NewsDetailsPresenter<INewsDetailsActivity, INewsInteractor>): INewsDetailsPresenter<INewsDetailsActivity, INewsInteractor>

}