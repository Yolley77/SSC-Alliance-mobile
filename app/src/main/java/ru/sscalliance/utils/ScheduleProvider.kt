package ru.sscalliance.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.schedulers.Schedulers

class ScheduleProvider {

    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()

    private fun getIoThreadScheduler() = Schedulers.io()

    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> =
        ObservableTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> =
        SingleTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> =
        FlowableTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> =
        MaybeTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    fun <T> ioToMainCompletableScheduler(): CompletableTransformer =
        CompletableTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

}