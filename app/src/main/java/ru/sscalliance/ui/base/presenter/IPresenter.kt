package ru.sscalliance.ui.base.presenter

import ru.sscalliance.ui.base.view.IView

interface IPresenter<V : IView> {

    fun onAttach(view: V)
    fun onViewReady()
    fun onDetach()
    fun handleError(error: Throwable)

}