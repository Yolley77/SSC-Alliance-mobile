package ru.sscalliance.domain.sport.sectionScreen.model

data class SectionBusinessModel(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val organizers: String = "",
    val type: SectionType
)
