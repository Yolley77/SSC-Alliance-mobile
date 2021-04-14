package ru.sscalliance.ui.section.certain.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.FragmentSectionBinding
import ru.sscalliance.domain.section.certain.interactor.ISectionInteractor
import ru.sscalliance.domain.section.model.SectionBusinessModel
import ru.sscalliance.domain.section.model.SectionType
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.section.certain.presentation.presenter.SectionPresenter
import javax.inject.Inject

interface ISectionFragment : IMvpView {
    fun setInfo(sectionInfo: SectionBusinessModel)
}

@AndroidEntryPoint
class SectionFragment(private val sectionType: SectionType) : BaseFragment(R.layout.fragment_section),
    ISectionFragment {

    @Inject
    lateinit var presenter: SectionPresenter<ISectionFragment, ISectionInteractor>

    private var _binding: FragmentSectionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectionBinding.inflate(inflater, container, false)
        presenter.configureViews(sectionType)
        return binding.root
    }

    override fun onDestroyView() {
        presenter.onDetach()
        _binding = null
        super.onDestroyView()
    }

    override fun setInfo(sectionInfo: SectionBusinessModel) {
        // init all views here
        // binding.smth = ...
        binding.sectionTitle.text = sectionInfo.title
        binding.sectionDescription.text = sectionInfo.description
    }

}