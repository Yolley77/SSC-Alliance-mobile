package ru.sscalliance.data.sport.sectionScreen.remote

import ru.sscalliance.data.common.Mapper
import ru.sscalliance.data.sport.sectionScreen.remote.model.SectionResponse
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import kotlin.math.log

object SectionNetToUIMapper : Mapper<SectionResponse, SectionBusinessModel>{
    override fun map(from: SectionResponse): SectionBusinessModel = SectionBusinessModel().apply {
        id = from.id
        title = from.title
        logo = from.logo
        description = from.description
        address = from.address
        //schedule = from.schedule
    }
}