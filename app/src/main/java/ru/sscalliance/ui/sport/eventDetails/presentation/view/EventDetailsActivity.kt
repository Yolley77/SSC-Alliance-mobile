package ru.sscalliance.ui.sport.eventDetails.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.ActivityEventDetailsBinding
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.domain.sport.model.EventBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.eventDetails.presentation.presenter.IEventDetailsPresenter
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

interface IEventDetailsActivity : IMvpView {

}

@AndroidEntryPoint
class EventDetailsActivity : BaseActivity<ActivityEventDetailsBinding>(),
    IEventDetailsActivity {

    @Inject
    lateinit var presenter: IEventDetailsPresenter<IEventDetailsActivity, ISportInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        binding = ActivityEventDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    private fun initViews() {
        val item = intent.getParcelableExtra<EventBusinessModel>(Navigator.EVENT_DETAILS)
        item?.let {
            showEventDetails(it)
        }
    }

    private fun showEventDetails(item: EventBusinessModel) {
        //binding.text = ...
    }

}