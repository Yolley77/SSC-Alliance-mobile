package ru.sscalliance.ui.news.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.FragmentNewsBinding
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.news.presentation.adapter.NewsAdapter
import ru.sscalliance.ui.news.presentation.viewModel.NewsViewModel
import javax.inject.Inject

interface INewsFragment : IMvpView {
    fun showNews(items: List<NewsBusinessModel>)
}

@AndroidEntryPoint
class NewsFragment : BaseFragment(R.layout.fragment_news), INewsFragment {

    @Inject
    lateinit var presenter: NewsViewModel<INewsFragment, INewsInteractor>

    private var binding: FragmentNewsBinding? = null
    private var newsAdapter: NewsAdapter<NewsBusinessModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentNewsBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        // IMPORTANT
        // to work with binding - must return binding.root in onCreate/onCreateView
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        setUpNewsRv()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        binding = null
        newsAdapter = null
        super.onDestroyView()
    }

    override fun showNews(items: List<NewsBusinessModel>) {
        newsAdapter?.updateAdapter(items)
    }

    private fun setUpNewsRv() {
        newsAdapter = NewsAdapter()
        binding?.rvNews?.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        presenter.getNews()
    }

}

