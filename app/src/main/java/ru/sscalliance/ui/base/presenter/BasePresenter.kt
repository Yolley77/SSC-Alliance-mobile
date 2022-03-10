package ru.sscalliance.ui.base.presenter

import retrofit2.HttpException
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.utils.AppConstants
import ru.sscalliance.utils.ToastsHandler
import java.net.ConnectException
import javax.inject.Inject

abstract class BasePresenter<V : IMvpView, I : IMvpInteractor> internal constructor(
    var interactor: I
) : IMvpPresenter<V, I> {

    @Inject
    lateinit var toastsHandler: ToastsHandler

    protected var view: V? = null
    private val isViewAttached: Boolean
        get() = view != null

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onViewReady() {
        // Empty implementation
    }

    override fun onDetach() {
        view?.hideProgress()
        view = null
    }

    override fun handleError(error: Throwable) {
        when (error) {
            is ConnectException -> toastsHandler.showError(
                AppConstants.NO_INTERNET_ERROR,
                null
            )
            is HttpException -> toastsHandler.showError(
                AppConstants.AUTH_ERROR,
                error.code()
            )
            else -> {
                toastsHandler.showMessage(
                    error.message
                )
            }
        }
    }

}