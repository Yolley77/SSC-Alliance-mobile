package ru.sscalliance.data.sport.sectionScreen.remote

import ru.sscalliance.data.base.BaseCloudDataSource
import ru.sscalliance.data.news.remote.NewsNetToUIMapper
import ru.sscalliance.data.sport.sectionScreen.remote.model.SectionRequest
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import javax.inject.Inject

interface ISectionRemoteDataSource {
    suspend fun getSections(request: SectionRequest): List<SectionBusinessModel>
}

class SectionRemoteDataSource @Inject constructor() : ISectionRemoteDataSource, BaseCloudDataSource(){
    override suspend fun getSections(request: SectionRequest): List<SectionBusinessModel> {
        val result = api.getSections(request)?.map(SectionNetToUIMapper::map)
        return result.orEmpty()
    }
}