package ru.sscalliance.ui.team.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.team.interactor.ITeamInteractor
import ru.sscalliance.domain.team.interactor.TeamInteractor
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.team.presentation.presenter.TeamPresenter
import ru.sscalliance.ui.team.presentation.view.ITeamFragment

@Module
@InstallIn(FragmentComponent::class)
abstract class TeamFragmentModule {

    @Binds
    abstract fun bindTeamInteractor(impl: TeamInteractor): ITeamInteractor

    @Binds
    abstract fun bindTeamPresenter(impl: TeamPresenter<ITeamFragment, ITeamInteractor>):
            IPresenter<ITeamFragment, ITeamInteractor>
}


