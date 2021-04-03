package ru.sscalliance.ui.section.section.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.FragmentSectionBinding
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView

interface ISectionFragment : IMvpView {

}

@AndroidEntryPoint
class SectionFragment : BaseFragment(R.layout.fragment_section), ISectionFragment {

    private var _binding: FragmentSectionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}