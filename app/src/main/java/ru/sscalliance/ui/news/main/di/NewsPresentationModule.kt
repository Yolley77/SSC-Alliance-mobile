package ru.sscalliance.ui.news.main.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.domain.news.interactor.NewsInteractor
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.news.main.presentation.NewsPresenter
import ru.sscalliance.ui.news.main.presentation.INewsFragment

@Module
@InstallIn(ActivityComponent::class)
abstract class NewsPresentationModule {

    @Binds
    abstract fun bindNewsInteractor(impl: NewsInteractor): INewsInteractor

    @Binds
    abstract fun bindNewsPresenter(impl: NewsPresenter<INewsFragment, INewsInteractor>):
            IMvpPresenter<INewsFragment, INewsInteractor>

}