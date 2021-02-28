package ru.sscalliance.ui.base.view

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ru.sscalliance.utils.CommonUtil
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

abstract class BaseActivity(private val layoutId: Int) : AppCompatActivity(), IMvpView {

    @Inject
    lateinit var navigator: Navigator

    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    override fun hideProgress() {
        progressBar?.let { if (it.isVisible) it.isVisible = false }
    }

    override fun showProgress() {
        hideProgress()
        progressBar = CommonUtil.showLoadingDialog(this)
    }

}