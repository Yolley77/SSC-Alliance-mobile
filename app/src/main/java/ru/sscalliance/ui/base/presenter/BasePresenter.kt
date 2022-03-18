package ru.sscalliance.ui.base.presenter

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.HttpException
import ru.sscalliance.domain.base.IMvpInteractor
import ru.sscalliance.ui.base.coroutine.mainCoroutineContext
import ru.sscalliance.ui.base.view.IView
import ru.sscalliance.utils.AppConstants
import ru.sscalliance.utils.ToastsHandler
import java.net.ConnectException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<V : IView, I : IMvpInteractor> internal constructor(
    var interactor: I
) : IPresenter<V, I>, CoroutineScope {

    @Inject
    lateinit var toastsHandler: ToastsHandler

    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = mainCoroutineContext(job, ::handleError)

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
        Log.e("Presenter", error.message, error)
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