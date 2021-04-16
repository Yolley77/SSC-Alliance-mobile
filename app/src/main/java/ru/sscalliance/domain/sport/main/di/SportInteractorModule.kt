package ru.sscalliance.domain.sport.main.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.sport.repository.SportRepository
import ru.sscalliance.domain.sport.main.repository.ISportRepository

@Module
@InstallIn(ActivityComponent::class)
abstract class SportInteractorModule {

    @Binds
    abstract fun bindSportRepository(impl: SportRepository): ISportRepository

}
