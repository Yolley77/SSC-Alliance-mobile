package ru.sscalliance.ui.base.view

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.utils.CommonUtil
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity(), IMvpView {

    @Inject
    lateinit var navigator: Navigator
    lateinit var binding: T
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun hideProgress() {
        progressBar?.let { if (it.isVisible) it.isVisible = false }
    }

    override fun showProgress() {
        hideProgress()
        progressBar = CommonUtil.showLoadingDialog(this)
    }

}