package ru.sscalliance.ui.news.details

import android.os.Bundle
import android.view.MenuItem
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
    lateinit var presenter: INewsDetailsPresenter<INewsDetailsActivity>

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val item = intent.getParcelableExtra<NewsBusinessModel>(Navigator.NEWS_DETAILS)
        item?.let {
            showNewsDetails(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun showNewsDetails(item: NewsBusinessModel) {
        //binding.text = ...
    }

}