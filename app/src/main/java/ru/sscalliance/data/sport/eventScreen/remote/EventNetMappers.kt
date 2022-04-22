package ru.sscalliance.data.sport.eventScreen.remote

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.sport.eventScreen.remote.model.EventResponse
import ru.sscalliance.domain.sport.eventScreen.EventBusinessModel

object EventNetToUIMapper: Mapper<EventResponse, EventBusinessModel> {
    override fun map(from: EventResponse): EventBusinessModel = EventBusinessModel().apply {
        id = from.id
        title = from.title
        description = from.description
       // docs = from.docs
        address = from.address
        eventDate = from.eventDate
        //startTime = from.startTime
    }
}