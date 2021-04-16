package ru.sscalliance.ui.sport.eventDetails.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.domain.sport.main.interactor.ISportInteractor
import ru.sscalliance.ui.sport.eventDetails.presentation.presenter.EventDetailsPresenter
import ru.sscalliance.ui.sport.eventDetails.presentation.presenter.IEventDetailsPresenter
import ru.sscalliance.ui.sport.eventDetails.presentation.view.IEventDetailsActivity

@Module
@InstallIn(ActivityComponent::class)
abstract class EventDetailsPresentationModule {

    @Binds
    abstract fun bindEventDetailsPresenter(impl: EventDetailsPresenter<IEventDetailsActivity, ISportInteractor>)
            : IEventDetailsPresenter<IEventDetailsActivity, ISportInteractor>
}