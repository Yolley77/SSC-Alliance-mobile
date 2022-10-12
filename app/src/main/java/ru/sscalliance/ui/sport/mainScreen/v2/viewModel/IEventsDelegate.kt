package ru.sscalliance.ui.sport.mainScreen.v2.viewModel

import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel

internal interface IEventsDelegate {

    var events: List<EventBusinessModel>

    fun getEvents()
    fun onEventClicked()
    fun getEventDetails()

}