package ru.sscalliance.ui.sport.eventDetails.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.ActivityEventBinding
import ru.sscalliance.databinding.FragmentEventInformationBinding
import ru.sscalliance.domain.sport.main.interactor.ISportInteractor
import ru.sscalliance.domain.sport.main.model.EventBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.eventDetails.presentation.presenter.IEventDetailsPresenter
import ru.sscalliance.utils.Navigator
import javax.inject.Inject

interface IEventDetailsActivity : IMvpView {

}

@AndroidEntryPoint
class EventDetailsActivity : BaseActivity(0), IEventDetailsActivity {

    @Inject
    lateinit var presenter: IEventDetailsPresenter<IEventDetailsActivity, ISportInteractor>

    lateinit var binding: FragmentEventInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        binding = FragmentEventInformationBinding.inflate(layoutInflater)
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