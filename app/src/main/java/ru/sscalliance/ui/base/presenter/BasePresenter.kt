package ru.sscalliance.ui.base.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.sscalliance.domain.base.MvpInteractor
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.utils.IScheduleProvider
import ru.sscalliance.utils.ToastsHandler
import javax.inject.Inject

abstract class BasePresenter<V: IMvpView, I: MvpInteractor> internal constructor (
        var compositeDisposable: CompositeDisposable,
        var scheduleProvider: IScheduleProvider,
        var interactor: I
) : IMvpPresenter<V, I> {

    @Inject
    lateinit var toastsHandler: ToastsHandler

    private var view: V? = null
    private val isViewAttached: Boolean
        get() = view != null

    override fun bindView(view: V) {
        this.view = view
    }

    override fun unbindView() {
        view?.hideProgress()
        view = null
    }

    override fun getView(): V? = view

}