package ru.sscalliance.data.news.remote

import ru.sscalliance.domain.news.NewsBusinessModel

object FakeData {

    private val model1 = NewsBusinessModel(
        "1",
        "Новости секции по футболу",
        "image",
        "https://www.demonuts.com/Demonuts/smallvideo.mp4",
        "20/05/2021",
        "#мирэаспортфамили"
    )
    private val model2 = NewsBusinessModel(
        "2",
        "Новости секции по баскетболу",
        "https://sun9-28.userapi.com/impg/bt9XrbuavpQcY8DdtvQMnBUJkSTabbX4cdFN1A/zvdSVVfoxf8.jpg?size=2560x1707&quality=96&sign=a5c5dec96796f7ab42dde8cebddf2f69&type=album",
        "https://www.demonuts.com/Demonuts/smallvideo.mp4",
        "25/05/2021",
        "#баскетбол"
    )
    private val model3 = NewsBusinessModel(
        "3",
        "Новости секции по волейболу",
        "https://sun9-33.userapi.com/impg/yA1tzCE3O_unf5IBILN4tsmPsYI7zVy_01GumQ/Gadbf29OLZo.jpg?size=1919x1080&quality=96&sign=3799bbf349daadc2ff88d72367047929&type=album",
        "",
        "30/06/2021",
        "#волейбол"
    )

    fun getNews(): List<NewsBusinessModel> {
        return listOf(
            model1, model2, model3
        )
    }

}