package ru.sscalliance.domain.sport.mainScreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import ru.sscalliance.data.sport.mainScreen.repository.SportRepository
import ru.sscalliance.domain.sport.mainScreen.repository.ISportRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class SportInteractorModule {

    @Binds
    abstract fun bindSportRepository(impl: SportRepository): ISportRepository

}
