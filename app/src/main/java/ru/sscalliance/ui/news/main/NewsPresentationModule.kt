package ru.sscalliance.ui.news.main

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.domain.news.INewsInteractor
import ru.sscalliance.domain.news.NewsInteractor
import ru.sscalliance.ui.base.presenter.IPresenter

@Module
@InstallIn(ActivityComponent::class)
abstract class NewsPresentationModule {

    @Binds
    abstract fun bindNewsInteractor(impl: NewsInteractor): INewsInteractor

    @Binds
    abstract fun bindNewsPresenter(impl: NewsPresenter<INewsFragment, INewsInteractor>):
            IPresenter<INewsFragment, INewsInteractor>

}