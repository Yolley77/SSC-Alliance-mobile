package ru.sscalliance.ui.news.details

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import ru.sscalliance.R
import ru.sscalliance.databinding.ActivityNewsDetailsBinding
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
        viewBinding.fmtEventInfo.tvDetailsAddress.setOnClickListener {
            val encodedAddr = Uri.encode(viewBinding.fmtEventInfo.tvDetailsAddress.text.toString())
            startActivity(
                Intent(
                    ACTION_VIEW,
                    Uri.parse("geo:0,0?q=$encodedAddr")
                )
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun showNewsDetails(item: NewsBusinessModel) {
        with(viewBinding) {
            fmtEventInfo.eventDetailsDescription.text = item.title
            Glide.with(this@NewsDetailsActivity)
                .load(item.image)
                .apply(RequestOptions().centerCrop())
                .transform(
                    MultiTransformation(
                        CenterCrop(), RoundedCornersTransformation(40, 0)
                    )
                )
                .error(R.drawable.photo_test_1)
                .into(fmtEventInfo.ivPreview)
        }
    }

}