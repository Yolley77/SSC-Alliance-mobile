package ru.sscalliance.domain.sport.mainScreen.model

import ru.sscalliance.domain.sport.sectionScreen.model.SectionType

data class SectionPreviewBusinessModel(
    var title: String = "",
    val type: SectionType
)
