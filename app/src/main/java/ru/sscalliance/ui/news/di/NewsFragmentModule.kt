package ru.sscalliance.ui.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.domain.news.interactor.NewsInteractor
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.news.presentation.viewModel.NewsViewModel
import ru.sscalliance.ui.news.presentation.view.INewsFragment

@Module
@InstallIn(FragmentComponent::class)
abstract class NewsFragmentModule {

    @Binds
    abstract fun bindNewsInteractor(impl: NewsInteractor): INewsInteractor

    @Binds
    abstract fun bindNewsPresenter(impl: NewsViewModel<INewsFragment, INewsInteractor>):
            IMvpPresenter<INewsFragment, INewsInteractor>

}