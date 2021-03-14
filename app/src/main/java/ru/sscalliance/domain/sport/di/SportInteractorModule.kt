package ru.sscalliance.domain.sport.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.sport.repository.SportRepository
import ru.sscalliance.domain.sport.repository.ISportRepository

@Module
@InstallIn(FragmentComponent::class)
abstract class SportInteractorModule {
    @Binds
    abstract fun bindSportRepository(impl: SportRepository): ISportRepository
}
