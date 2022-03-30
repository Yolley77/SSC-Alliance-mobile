package ru.sscalliance.ui.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ru.sscalliance.R

abstract class BaseFragment<T : ViewBinding> : Fragment(), IView {

    private var progressBar: ProgressBar? = null
    var viewBinding: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = viewBinding?.root

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

    override fun hideProgress() {
        activity?.findViewById<ProgressBar>(R.id.pbLoading)?.isVisible = false

    }

    override fun showProgress() {
        hideProgress()
        activity?.findViewById<ProgressBar>(R.id.pbLoading)?.isVisible = true
    }

}