package ru.sscalliance.ui.sport.eventDetails.presentation.presenter

import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.sport.eventDetails.presentation.view.IEventDetailsActivity
import javax.inject.Inject

interface IEventDetailsPresenter<V : IEventDetailsActivity> :
    IPresenter<V>

class EventDetailsPresenter<V : IEventDetailsActivity> @Inject constructor() : BasePresenter<V>(),
    IEventDetailsPresenter<V> {

}