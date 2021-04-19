package ru.sscalliance.ui.news.main.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.news.main.interactor.INewsInteractor
import ru.sscalliance.domain.news.main.interactor.NewsInteractor
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.news.main.presentation.presenter.NewsPresenter
import ru.sscalliance.ui.news.main.presentation.view.INewsFragment

@Module
@InstallIn(FragmentComponent::class)
abstract class NewsPresentationModule {

    @Binds
    abstract fun bindNewsInteractor(impl: NewsInteractor): INewsInteractor

    @Binds
    abstract fun bindNewsPresenter(impl: NewsPresenter<INewsFragment, INewsInteractor>):
            IMvpPresenter<INewsFragment, INewsInteractor>

}