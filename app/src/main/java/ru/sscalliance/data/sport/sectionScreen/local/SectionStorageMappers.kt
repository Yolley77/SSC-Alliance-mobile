package ru.sscalliance.data.sport.sectionScreen.local

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.sport.sectionScreen.local.model.SectionStorageModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import kotlin.math.log

object SectionStorageToUIMappers : Mapper<SectionStorageModel, SectionBusinessModel> {
    override fun map(from: SectionStorageModel): SectionBusinessModel = SectionBusinessModel().apply {
        id = from.id
        title = from.title
        logo = from.logo
        description = from.description
        address = from.address
    //    schedule = from.schedule
    }
}

object SectionUIToStorageMapper : Mapper<SectionBusinessModel, SectionStorageModel> {
    override fun map(from: SectionBusinessModel): SectionStorageModel = SectionStorageModel().apply {
        id = from.id
        title = from.title
        logo = from.logo
        description = from.description
        address = from.address
      //  schedule = from.schedule
    }
}