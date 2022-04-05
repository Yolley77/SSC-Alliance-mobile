package ru.sscalliance.ui.news.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.FragmentNewsBinding
import ru.sscalliance.domain.news.INewsInteractor
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IView
import javax.inject.Inject

interface INewsFragment : IView {
    fun showNews(items: List<NewsBusinessModel>)
    fun openNewsDetailsScreen(item: NewsBusinessModel)
    fun stopRefreshing()
}

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>(), INewsFragment {

    @Inject
    lateinit var presenter: NewsPresenter<INewsFragment>

    private var newsAdapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentNewsBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        initViews()
        setUpNewsRv()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        newsAdapter = null
        super.onDestroyView()
    }

    override fun showNews(items: List<NewsBusinessModel>) {
        newsAdapter?.updateAdapter(items)
    }

    override fun openNewsDetailsScreen(item: NewsBusinessModel) {
        val parent = activity as BaseActivity<*>
        parent.navigator.openNewsDetailsScreen(item)
    }

    override fun stopRefreshing() {
        viewBinding?.srlRefresh?.isRefreshing = false
    }

    private fun initViews() {
        viewBinding?.srlRefresh?.setOnRefreshListener {
            newsAdapter?.updateAdapter(emptyList())
            presenter.getNews()
        }
    }

    private fun setUpNewsRv() {
        newsAdapter = NewsAdapter(presenter::onItemClicked)
        viewBinding?.rvNews?.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        presenter.getNews()
    }

}

