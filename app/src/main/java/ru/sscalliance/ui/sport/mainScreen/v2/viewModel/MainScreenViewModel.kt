package ru.sscalliance.ui.sport.mainScreen.v2.viewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sscalliance.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainScreenViewModel @Inject constructor(
    val eventsDelegate: IEventsDelegate,
) : BaseViewModel() {

    init {
        eventsDelegate.getEvents()
    }

}