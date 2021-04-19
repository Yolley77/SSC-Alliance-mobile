package ru.sscalliance.ui.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ru.sscalliance.utils.CommonUtil

abstract class BaseFragment<T : ViewBinding> : Fragment(), IMvpView {

    private var progressBar: ProgressBar? = null
    var binding: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding?.root

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun hideProgress() {
        progressBar?.let { if (it.isVisible) it.isVisible = false }
    }

    override fun showProgress() {
        hideProgress()
        progressBar = CommonUtil.showLoadingDialog(requireContext())
    }

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

}