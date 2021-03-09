package ru.sscalliance.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.schedulers.Schedulers

interface IScheduleProvider {
    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T>
    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T>
    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T>
    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T>
    fun <T> ioToMainCompletableScheduler(): CompletableTransformer
}

class ScheduleProvider : IScheduleProvider {

    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()

    private fun getIoThreadScheduler() = Schedulers.io()

    override fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> =
        ObservableTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    override fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> =
        SingleTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    override fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> =
        FlowableTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    override fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> =
        MaybeTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

    override fun <T> ioToMainCompletableScheduler(): CompletableTransformer =
        CompletableTransformer { upstream ->
            upstream.apply {
                subscribeOn(getIoThreadScheduler())
                observeOn(getMainThreadScheduler())
            }
        }

}
