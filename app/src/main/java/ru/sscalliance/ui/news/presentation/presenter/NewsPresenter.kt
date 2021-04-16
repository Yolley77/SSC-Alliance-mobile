package ru.sscalliance.ui.news.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.HttpException
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.news.presentation.view.INewsFragment
import ru.sscalliance.utils.AppConstants
import ru.sscalliance.utils.IScheduleProvider
import java.net.ConnectException
import javax.inject.Inject

interface INewsPresenter<V : INewsFragment, I : INewsInteractor> : IMvpPresenter<V, I> {
    fun getNews(): Any?
}

class NewsPresenter<V : INewsFragment, I : INewsInteractor> @Inject constructor(
    disposable: CompositeDisposable,
    scheduleProvider: IScheduleProvider,
    interactor: I
) : BasePresenter<V, I>(
    compositeDisposable = disposable,
    scheduleProvider = scheduleProvider,
    interactor = interactor
), INewsPresenter<V, I> {

    override fun getNews(): Any? = getView()?.let { view ->
        interactor.let {
            compositeDisposable.add(
                interactor.getNews()
                    .compose(scheduleProvider.ioToMainObservableScheduler())
                    .doOnSubscribe { view.showProgress() }
                    .doFinally { view.hideProgress() }
                    .subscribe({ items ->
                        view.showNews(items)
                    }, { error ->
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
                                toastsHandler.showMessage(error.message)
                            }
                        }
                    })
            )
        }
    }

}
