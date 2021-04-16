package ru.sscalliance.ui.sport.main.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.sport.main.interactor.ISportInteractor
import ru.sscalliance.domain.sport.main.interactor.SportInteractor
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sport.main.presentation.presenter.SportPresenter
import ru.sscalliance.ui.sport.main.presentation.view.ISportFragment

@Module
@InstallIn(ActivityComponent::class)
abstract class SportFragmentModule {

    @Binds
    abstract fun bindSportInteractor(impl: SportInteractor): ISportInteractor

    @Binds
    abstract fun bindSportPresenter(impl: SportPresenter<ISportFragment, ISportInteractor>):
            IMvpPresenter<ISportFragment, ISportInteractor>
}

