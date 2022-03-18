package ru.sscalliance.ui.base.presenter

import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.ui.base.view.IView

interface IPresenter<V : IView, I : IMvpInteractor> {

    fun onAttach(view: V)
    fun onViewReady()
    fun onDetach()
    fun handleError(error: Throwable)

}