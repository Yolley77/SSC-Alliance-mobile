package ru.sscalliance.data.sport.eventScreen.local

import ru.sscalliance.data.base.BaseCacheDataSource
import ru.sscalliance.data.sport.eventScreen.local.model.EventStorageModel
import ru.sscalliance.domain.sport.eventScreen.EventBusinessModel
import javax.inject.Inject

interface IEventLocalDataSource {
    fun save(events: List<EventBusinessModel>)
    fun get(): List<EventBusinessModel>
}

class EventLocalDataSource @Inject constructor(

): IEventLocalDataSource, BaseCacheDataSource<EventStorageModel>(EventStorageModel::class.java) {
    override fun save(events: List<EventBusinessModel>) {
        TODO("Not yet implemented")
    }

    override fun get(): List<EventBusinessModel> {
        TODO("Not yet implemented")
    }
}