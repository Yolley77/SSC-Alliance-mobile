package ru.sscalliance.data.sport.eventScreen.remote

import ru.sscalliance.data.base.BaseCloudDataSource
import ru.sscalliance.data.sport.eventScreen.remote.model.EventRequest
import ru.sscalliance.data.sport.sectionScreen.remote.SectionNetToUIMapper
import ru.sscalliance.data.sport.sectionScreen.remote.model.SectionRequest
import ru.sscalliance.domain.sport.eventScreen.EventBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import javax.inject.Inject

interface IEventRemoteDataSource {
    suspend fun getEvents(request: EventRequest): List<EventBusinessModel>
}

class EventRemoteDataSource @Inject constructor(): IEventRemoteDataSource, BaseCloudDataSource(){
    override suspend fun getEvents(request: EventRequest): List<EventBusinessModel> {
        val result = api.getEvents(request)?.map(EventNetToUIMapper::map)
        return result.orEmpty()
    }
}