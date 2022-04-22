package ru.sscalliance.data.sport.sectionScreen.local

import ru.sscalliance.data.base.BaseCacheDataSource
import ru.sscalliance.data.network.ApiHelper
import ru.sscalliance.data.sport.sectionScreen.local.model.SectionStorageModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import javax.inject.Inject

interface ISectionLocalDataSource{
    fun save(sections: List<SectionBusinessModel>)
    fun get(): List<SectionBusinessModel>
}

class SectionLocalDataSource @Inject constructor(
    private val apiHelper: ApiHelper
): ISectionLocalDataSource, BaseCacheDataSource<SectionStorageModel>(SectionStorageModel::class.java) {
    override fun save(sections: List<SectionBusinessModel>) {
        TODO("Not yet implemented")
    }

    override fun get(): List<SectionBusinessModel> {
        TODO("Not yet implemented")
    }
}