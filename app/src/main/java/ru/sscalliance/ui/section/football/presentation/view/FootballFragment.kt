package ru.sscalliance.ui.section.football.presentation.view

import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView

interface IFootballFragment : IMvpView {

}

@AndroidEntryPoint
class FootballFragment : BaseFragment(R.layout.fragment_section), IFootballFragment {

}