package ru.sscalliance.utils

import android.content.Context
import android.widget.ProgressBar
import androidx.core.view.isVisible

object CommonUtil {

    fun showLoadingDialog(context: Context?): ProgressBar {
        val progressDialog = ProgressBar(context)
        progressDialog.let {
            it.isVisible = true
            it.isIndeterminate = true
            return it
        }
    }

}