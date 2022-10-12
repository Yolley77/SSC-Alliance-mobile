package ru.sscalliance.ui.sport.mainScreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.sscalliance.domain.sport.mainScreen.interactor.ISportInteractor
import ru.sscalliance.domain.sport.mainScreen.interactor.SportInteractor
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.sport.mainScreen.presentation.ISportFragment
import ru.sscalliance.ui.sport.mainScreen.presentation.SportPresenter

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class SportFragmentModule {

    @Binds
    abstract fun bindSportInteractor(impl: SportInteractor): ISportInteractor

    @Binds
    abstract fun bindSportPresenter(impl: SportPresenter<ISportFragment>): IPresenter<ISportFragment>
}

