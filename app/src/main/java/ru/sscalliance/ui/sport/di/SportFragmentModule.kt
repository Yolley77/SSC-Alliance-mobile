package ru.sscalliance.ui.sport.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.domain.sport.interactor.SportInteractor
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sport.presentation.presenter.SportPresenter
import ru.sscalliance.ui.sport.presentation.view.ISportFragment

@Module
@InstallIn(FragmentComponent::class)
abstract class SportFragmentModule {

    @Binds
    abstract fun bindSportInteractor(impl: SportInteractor): ISportInteractor

    @Binds
    abstract fun bindSportPresenter(impl: SportPresenter<ISportFragment, ISportInteractor>):
            IMvpPresenter<ISportFragment, ISportInteractor>
}

