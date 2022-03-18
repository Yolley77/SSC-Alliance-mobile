package ru.sscalliance.ui.base.view

import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import ru.sscalliance.utils.CommonUtil
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity(), IView {

    @Inject
    lateinit var navigator: Navigator
    lateinit var viewBinding: T
    private var progressBar: ProgressBar? = null

    override fun hideProgress() {
        progressBar?.let { if (it.isVisible) it.isVisible = false }
    }

    override fun showProgress() {
        hideProgress()
        progressBar = CommonUtil.showLoadingDialog(this)
    }

}