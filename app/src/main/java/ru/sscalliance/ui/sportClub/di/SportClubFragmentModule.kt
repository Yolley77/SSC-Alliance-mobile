package ru.sscalliance.ui.sportClub.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.sportClub.interactor.ISportClubInteractor
import ru.sscalliance.domain.sportClub.interactor.SportClubInteractor
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.sportClub.presentation.presenter.SportClubPresenter
import ru.sscalliance.ui.sportClub.presentation.view.ISportClubFragment

@Module
@InstallIn(FragmentComponent::class)
abstract class SportClubFragmentModule {

    @Binds
    abstract fun bindSportClubInteractor(impl: SportClubInteractor): ISportClubInteractor

    @Binds
    abstract fun bindSportClubPresenter(impl: SportClubPresenter<ISportClubFragment
            , ISportClubInteractor>): IMvpPresenter<ISportClubFragment, ISportClubInteractor>
}

