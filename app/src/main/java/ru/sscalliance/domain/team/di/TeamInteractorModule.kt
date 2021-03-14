package ru.sscalliance.domain.team.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.team.repository.TeamRepository
import ru.sscalliance.domain.team.repository.ITeamRepository

@Module
@InstallIn(FragmentComponent::class)
abstract class TeamInteractorModule {
    @Binds
    abstract fun bindTeamRepository(impl: TeamRepository): ITeamRepository
}