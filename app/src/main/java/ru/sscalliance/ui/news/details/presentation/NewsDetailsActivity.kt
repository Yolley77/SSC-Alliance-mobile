package ru.sscalliance.ui.news.details.presentation

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.ActivityNewsDetailsBinding
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

interface INewsDetailsActivity : IMvpView {

}

@AndroidEntryPoint
class NewsDetailsActivity : BaseActivity<ActivityNewsDetailsBinding>(), INewsDetailsActivity {

    @Inject
    lateinit var presenter: INewsDetailsPresenter<INewsDetailsActivity, INewsInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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