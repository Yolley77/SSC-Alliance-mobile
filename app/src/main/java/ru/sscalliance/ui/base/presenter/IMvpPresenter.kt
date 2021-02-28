package ru.sscalliance.ui.base.presenter

import ru.sscalliance.domain.base.MvpInteractor
import ru.sscalliance.ui.base.view.IMvpView

interface IMvpPresenter<V: IMvpView, I: MvpInteractor> {
    fun bindView(view: V)
    fun unbindView()
    fun getView(): V?
}