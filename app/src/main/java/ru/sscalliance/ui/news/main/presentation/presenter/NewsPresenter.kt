package ru.sscalliance.ui.news.main.presentation.presenter

import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.HttpException
import ru.sscalliance.domain.news.interactor.INewsInteractor
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.ui.base.presenter.BasePresenter
import ru.sscalliance.ui.base.presenter.IMvpPresenter
import ru.sscalliance.ui.news.main.presentation.view.INewsFragment
import ru.sscalliance.utils.AppConstants
import ru.sscalliance.utils.IScheduleProvider
import java.net.ConnectException
import javax.inject.Inject

interface INewsPresenter<V : INewsFragment, I : INewsInteractor> : IMvpPresenter<V, I> {
    fun getNews(): Any?
    fun onItemClicked(item: NewsBusinessModel)
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

    override fun getNews(): Any? = view?.let { view ->
        interactor.let {
            compositeDisposable.add(
                interactor.getNews()
                    .compose(scheduleProvider.ioToMainObservableScheduler())
                    .doOnSubscribe { view.showProgress() }
                    .doFinally { view.hideProgress() }
                    .subscribe({ items ->
                        view.showNews(items)
                    }, this::handleError)
            )
        }
    }

    override fun onItemClicked(item: NewsBusinessModel) {
        view?.openNewsDetailsScreen(item)
    }

}
