package ru.sscalliance.utils

import android.content.Context
import android.widget.Toast
import ru.sscalliance.R
import javax.inject.Inject

interface IToastsHandler {
    fun showError(errorCode: Int?, httpErrorCode: Int?)
    fun showMessage(message: String?)
}

class ToastsHandler @Inject constructor(
        private val context: Context
        ) : IToastsHandler {
    override fun showError(errorCode: Int?, httpErrorCode: Int?) {
        when (errorCode) {
            AppConstants.ERROR -> makeToast(context.getString(R.string.error_occurred_short))
            else -> makeToast(context.getString(R.string.error_occurred_long))
        }
    }

    override fun showMessage(message: String?) {
        when (message.isNullOrEmpty()) {
            true  -> makeToast(context.getString(R.string.error_occurred_long))
            false -> makeToast("${context.getString(R.string.error_occurred_short)}\n$message")
        }
    }

    private fun makeToast(message: String?, code: Int? = null) {
        val text = if (code == null) "$message" else "$message $code"
        Toast.makeText(context, text, Toast.LENGTH_SHORT)
                .show()
    }

}