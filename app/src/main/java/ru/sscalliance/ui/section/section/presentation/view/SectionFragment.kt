package ru.sscalliance.ui.section.section.presentation.view

import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView

interface ISectionFragment : IMvpView {

}

@AndroidEntryPoint
class SectionFragment : BaseFragment(R.layout.fragment_section), ISectionFragment {

}