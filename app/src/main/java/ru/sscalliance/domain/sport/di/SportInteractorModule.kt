package ru.sscalliance.domain.sport.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.data.sport.repository.SportRepository
import ru.sscalliance.domain.sport.repository.ISportRepository

@Module
@InstallIn(ActivityComponent::class)
abstract class SportInteractorModule {

    @Binds
    abstract fun bindSportRepository(impl: SportRepository): ISportRepository

}
