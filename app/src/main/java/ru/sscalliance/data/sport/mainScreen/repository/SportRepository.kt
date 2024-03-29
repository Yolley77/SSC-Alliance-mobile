package ru.sscalliance.data.sport.mainScreen.repository

import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.SectionPreviewBusinessModel
import ru.sscalliance.domain.sport.mainScreen.repository.ISportRepository
import javax.inject.Inject

class SportRepository @Inject constructor(

) : ISportRepository {

    override fun getSections(): List<SectionPreviewBusinessModel> {
        val model1 = SectionPreviewBusinessModel("Футбол", SectionType.FOOTBALL)
        val model2 = SectionPreviewBusinessModel("Баскетбол", SectionType.BASKETBALL)
        val model3 = SectionPreviewBusinessModel("Волейбол", SectionType.VOLLEYBALL)
        val model4 = SectionPreviewBusinessModel("Настольный теннис", SectionType.PING_PONG)
        val model5 = SectionPreviewBusinessModel("Бадминтон", SectionType.BADMINTON)
        val model6 = SectionPreviewBusinessModel("Шахматы", SectionType.CHESS)
        return listOf(
            model1, model2, model3, model4, model5, model6
        )
    }

    override suspend fun getEvents(): List<EventBusinessModel> {
        val model1 = EventBusinessModel("Секция по футболу", "image", "20/05/2021")
        val model2 = EventBusinessModel(
            "Секция по баскетболу",
            "https://sun9-28.userapi.com/impg/bt9XrbuavpQcY8DdtvQMnBUJkSTabbX4cdFN1A/zvdSVVfoxf8.jpg?size=2560x1707&quality=96&sign=a5c5dec96796f7ab42dde8cebddf2f69&type=album",
            "25/05/2021"
        )
        val model3 = EventBusinessModel("Секция по волейболу", "image", "30/06/2021")
        return listOf(
            model1, model2, model3,
            model1, model2, model3
        )
    }
}


