package ru.sscalliance.ui.news.main.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.FragmentNewsBinding
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.news.main.presentation.adapter.NewsAdapter
import ru.sscalliance.ui.news.main.presentation.presenter.NewsPresenter
import javax.inject.Inject

interface INewsFragment : IMvpView {
    fun showNews(items: List<NewsBusinessModel>)
    fun openNewsDetailsScreen(item: NewsBusinessModel)
}

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>(), INewsFragment {

    @Inject
    lateinit var presenter: NewsPresenter<INewsFragment, INewsInteractor>

    private var newsAdapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    private fun setUpNewsRv() {
        newsAdapter = NewsAdapter(presenter::onItemClicked)
        binding?.rvNews?.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        presenter.getNews()
    }

}

