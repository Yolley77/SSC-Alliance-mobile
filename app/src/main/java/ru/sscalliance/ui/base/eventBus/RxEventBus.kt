package ru.sscalliance.ui.base.eventBus

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

class RxEventBus<T> {

    var value: T? = null
        private set

    private val subject: PublishSubject<T> = PublishSubject.create()

    private val observer = Observable.create<T> { source ->
        val subscribe = subject.subscribe { source.onNext(it) }
        source.setCancellable { subscribe.dispose() }
        handle()
    }

    fun onNext(v: T) {
        value = v
        if (subject.hasObservers()) {
            handle()
        }
    }

    fun listen(): Observable<T> = observer

    fun hasValue() = value != null

    fun getValueAndClear(): T? {
        val result = value
        value = null
        return result
    }

    private fun handle() {
        value?.let {
            subject.onNext(it)
            value = null
        }
    }

}