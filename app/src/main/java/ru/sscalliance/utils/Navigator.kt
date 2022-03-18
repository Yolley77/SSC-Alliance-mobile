package ru.sscalliance.utils

import android.content.Context
import android.content.Intent
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.ui.main.view.MainActivity
import ru.sscalliance.ui.news.details.NewsDetailsActivity
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.view.MainSectionActivity
import ru.sscalliance.ui.sport.eventDetails.presentation.view.EventDetailsActivity
import javax.inject.Inject

interface INavigator {
    fun openMainScreen()
    fun openMainSectionScreen()
    fun openEventDetailsScreen(item: EventBusinessModel)
    fun openNewsDetailsScreen(item: NewsBusinessModel)
}

class Navigator @Inject constructor(
    private val context: Context
) : INavigator {

    companion object {
        const val EVENT_DETAILS = "event_details"
        const val NEWS_DETAILS = "news_details"
    }

    override fun openMainScreen() = context.startActivity(
        Intent(context, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    )

    override fun openMainSectionScreen() = context.startActivity(
        Intent(context, MainSectionActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    )

    override fun openEventDetailsScreen(item: EventBusinessModel) = context.startActivity(
        Intent(context, EventDetailsActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .putExtra(EVENT_DETAILS, item)
    )

    override fun openNewsDetailsScreen(item: NewsBusinessModel) = context.startActivity(
        Intent(context, NewsDetailsActivity::class.java)
            .putExtra(EVENT_DETAILS, item)
            .apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
    )

}