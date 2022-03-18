package ru.sscalliance.ui.news.details

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.domain.news.INewsInteractor

@Module
@InstallIn(ActivityComponent::class)
abstract class NewsDetailsPresentationModule {

    @Binds
    abstract fun bindNewsDetailsPresenter(impl: NewsDetailsPresenter<INewsDetailsActivity, INewsInteractor>): INewsDetailsPresenter<INewsDetailsActivity, INewsInteractor>

}