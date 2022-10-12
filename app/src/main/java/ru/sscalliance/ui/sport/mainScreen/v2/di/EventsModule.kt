package ru.sscalliance.ui.sport.mainScreen.v2.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.sscalliance.ui.sport.mainScreen.v2.viewModel.EventsDelegate
import ru.sscalliance.ui.sport.mainScreen.v2.viewModel.IEventsDelegate
import ru.sscalliance.ui.sport.mainScreen.v2.viewModel.MainScreenViewModel

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class EventsModule {

    @Binds
    abstract fun bindMainScreenViewModel(impl: MainScreenViewModel): ViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindEventsDelegate(impl: EventsDelegate): IEventsDelegate

}