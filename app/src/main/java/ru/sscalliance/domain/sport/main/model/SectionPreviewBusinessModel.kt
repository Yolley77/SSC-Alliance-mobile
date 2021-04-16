package ru.sscalliance.domain.sport.main.model

import ru.sscalliance.domain.section.model.SectionType

data class SectionPreviewBusinessModel(
        var title: String = "",
        var logo: String = "",
        val type: SectionType
)
