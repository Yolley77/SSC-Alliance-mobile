package ru.sscalliance.ui.base.presenter

import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.ui.base.view.IMvpView

interface IMvpPresenter<V : IMvpView, I : IMvpInteractor> {
    fun onAttach(view: V)
    fun onDetach()
    fun getView(): V?
    fun handleError(error: Throwable)
}