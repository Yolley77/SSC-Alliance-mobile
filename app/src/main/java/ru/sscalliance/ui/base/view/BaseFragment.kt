package ru.sscalliance.ui.base.view

import android.content.Context
import android.os.Bundle
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ru.sscalliance.utils.CommonUtil

abstract class BaseFragment(private var layoutId: Int) : Fragment(), IMvpView {

    private var parentActivity: BaseActivity? = null
    private var progressBar: ProgressBar? = null
    //open var binding: ViewBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            parentActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

/*    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)*/

    override fun onDestroyView() {
        //binding = null
        super.onDestroyView()
    }

    override fun hideProgress() {
        progressBar?.let { if (it.isVisible) it.isVisible = false }
    }

    override fun showProgress() {
        hideProgress()
        progressBar = CommonUtil.showLoadingDialog(requireContext())
    }

    fun getParentActivity() = parentActivity

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

}