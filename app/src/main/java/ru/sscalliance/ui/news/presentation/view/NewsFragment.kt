package ru.sscalliance.ui.news.presentation.view

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.news.presentation.presenter.NewsPresenter
import javax.inject.Inject

interface INewsFragment : IMvpView {

}

@AndroidEntryPoint
class NewsFragment : BaseFragment(R.layout.fragment_news), INewsFragment {

    @Inject
    lateinit var presenter: NewsPresenter<INewsFragment, INewsInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.bindView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // setup here
    }

    override fun onDestroyView() {
        presenter.unbindView()
        super.onDestroyView()
    }

}