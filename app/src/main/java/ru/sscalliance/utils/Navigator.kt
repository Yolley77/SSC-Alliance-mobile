package ru.sscalliance.utils

import android.content.Context
import javax.inject.Inject

interface INavigator {
    fun openMainScreen()
}

class Navigator @Inject constructor(
    private val context: Context
) : INavigator {
    override fun openMainScreen() {
        TODO("Not yet implemented")
    }
}