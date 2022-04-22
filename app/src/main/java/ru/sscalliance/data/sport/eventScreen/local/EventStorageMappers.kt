package ru.sscalliance.data.sport.eventScreen.local

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.sport.eventScreen.local.model.EventStorageModel
import ru.sscalliance.domain.sport.eventScreen.EventBusinessModel

object EventStorageToUIMapper: Mapper<EventStorageModel, EventBusinessModel> {
    override fun map(from: EventStorageModel): EventBusinessModel = EventBusinessModel().apply {
        id = from.id
        title = from.title
        description = from.description
//        docs = from.docs
        address = from.address
        eventDate = from.eventDate
  //      startTime = from.startTime
    }
}

object EventUIToStorageManager: Mapper<EventBusinessModel, EventStorageModel> {
    override fun map(from: EventBusinessModel): EventStorageModel = EventStorageModel().apply {
        id = from.id
        title = from.title
        description = from.description
 //       docs = from.docs
        address = from.address
        eventDate = from.eventDate
   //     startTime = from.startTime
    }

}