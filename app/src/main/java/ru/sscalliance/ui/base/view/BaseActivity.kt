package ru.sscalliance.ui.base.view

import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import ru.sscalliance.R
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity(), IView {

    @Inject
    lateinit var navigator: Navigator
    lateinit var viewBinding: T
    private var progressBar: ProgressBar? = null

    override fun hideProgress() {
        findViewById<FrameLayout>(R.id.incLoader)?.isVisible = false
    }

    override fun showProgress() {
        findViewById<FrameLayout>(R.id.incLoader)?.isVisible = true
    }

}