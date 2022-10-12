package ru.sscalliance.ui.sport.mainScreen.v2.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.repository.ISportRepository
import ru.sscalliance.ui.base.coroutine.CommonCoroutineScope
import javax.inject.Inject

internal class EventsDelegate @Inject constructor(
    private val repository: ISportRepository
) : IEventsDelegate, CommonCoroutineScope() {

    override var events: List<EventBusinessModel> by mutableStateOf(emptyList())

    override fun getEvents() {
        launch {
            events = repository.getEvents()
        }
    }

    override fun onEventClicked() {
        //TODO("Not yet implemented")
    }

    override fun getEventDetails() {
        //TODO("Not yet implemented")
    }
}