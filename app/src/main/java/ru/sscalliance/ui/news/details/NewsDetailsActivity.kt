package ru.sscalliance.ui.news.details

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.ActivityNewsDetailsBinding
import ru.sscalliance.domain.news.INewsInteractor
import ru.sscalliance.domain.news.NewsBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IView
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

interface INewsDetailsActivity : IView {

}

@AndroidEntryPoint
class NewsDetailsActivity : BaseActivity<ActivityNewsDetailsBinding>(), INewsDetailsActivity {

    @Inject
    lateinit var presenter: INewsDetailsPresenter<INewsDetailsActivity, INewsInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        viewBinding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    private fun initViews() {
        val item = intent.getParcelableExtra<NewsBusinessModel>(Navigator.EVENT_DETAILS)
        item?.let {
            showNewsDetails(it)
        }
    }

    private fun showNewsDetails(item: NewsBusinessModel) {
        //binding.text = ...
    }

}