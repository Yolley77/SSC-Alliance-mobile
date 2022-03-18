package ru.sscalliance.ui.sport.eventDetails.presentation.presenter

import ru.sscalliance.domain.sport.mainScreen.interactor.ISportInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IPresenter
import ru.sscalliance.ui.sport.eventDetails.presentation.view.IEventDetailsActivity
import javax.inject.Inject

interface IEventDetailsPresenter<V : IEventDetailsActivity, I : ISportInteractor> :
    IPresenter<V, I>

class EventDetailsPresenter<V : IEventDetailsActivity, I : ISportInteractor> @Inject constructor(
    interactor: I
) : BasePresenter<V, I>(
    interactor
), IEventDetailsPresenter<V, I> {

}