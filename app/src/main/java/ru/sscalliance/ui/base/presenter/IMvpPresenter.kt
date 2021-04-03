package ru.sscalliance.ui.base.presenter

import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.ui.base.view.IMvpView

interface IMvpPresenter<V: IMvpView, I: IMvpInteractor> {
    fun bindView(view: V)
    fun unbindView()
    fun getView(): V?
    fun handleError(error: Throwable)
}