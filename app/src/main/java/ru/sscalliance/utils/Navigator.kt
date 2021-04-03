package ru.sscalliance.utils

import android.content.Context
import android.content.Intent
import ru.sscalliance.ui.main.view.MainActivity
import ru.sscalliance.ui.section.main.presentation.view.MainSectionActivity
import javax.inject.Inject

interface INavigator {
    fun openMainScreen()
    fun openMainSectionScreen()
}

class Navigator @Inject constructor(
    private val context: Context
) : INavigator {

    override fun openMainScreen() = context.startActivity(
        Intent(context, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    )

    override fun openMainSectionScreen() = context.startActivity(
        Intent(context, MainSectionActivity::class.java)
    )

}