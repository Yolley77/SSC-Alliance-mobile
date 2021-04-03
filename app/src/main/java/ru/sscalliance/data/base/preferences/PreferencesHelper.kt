package ru.sscalliance.data.base.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

interface IPreferencesHelper {

    fun clearToken()
    fun getToken(): String?
    fun setToken(accessToken: String)

}

class PreferencesHelper @Inject constructor(
    context: Context
) : IPreferencesHelper {

    private companion object {
        private const val PREFERENCES_NAME = "preferences_instance_name"
        private const val PREFERENCES_KEY = "PREFERENCES_ACCESS_TOKEN_KEY"
    }

    private val preferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun clearToken() = preferences.edit().clear().apply()

    override fun getToken(): String? = preferences.getString(PREFERENCES_KEY, null)

    override fun setToken(accessToken: String) =
        preferences.edit().putString(PREFERENCES_KEY, accessToken).apply()
}