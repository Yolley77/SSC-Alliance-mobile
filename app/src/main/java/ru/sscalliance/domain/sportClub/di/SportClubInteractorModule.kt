package ru.sscalliance.domain.sportClub.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.sportClub.repository.SportClubRepository
import ru.sscalliance.domain.sportClub.repository.ISportClubRepository

@Module
@InstallIn(FragmentComponent::class)
abstract class SportClubInteractorModule {
    @Binds
    abstract fun bindSportClubRepository(impl: SportClubRepository): ISportClubRepository
}


