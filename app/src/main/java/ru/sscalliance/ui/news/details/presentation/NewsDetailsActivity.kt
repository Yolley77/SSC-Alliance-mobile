package ru.sscalliance.ui.news.details.presentation

import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.ActivityNewsDetailsBinding
import ru.sscalliance.ui.base.view.BaseFragment

interface INewsDetailsActivity {

}

@AndroidEntryPoint
class NewsDetailsActivity : BaseFragment<ActivityNewsDetailsBinding>(), INewsDetailsActivity {

}