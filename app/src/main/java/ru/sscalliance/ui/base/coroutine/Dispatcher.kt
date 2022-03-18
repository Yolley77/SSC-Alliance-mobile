package ru.sscalliance.ui.base.coroutine

import kotlinx.coroutines.CoroutineDispatcher

object Dispatcher {

    private val dispatcherProvider = DispatcherProvider()

    val IO: CoroutineDispatcher get() = dispatcherProvider.IO
    val Default: CoroutineDispatcher get() = dispatcherProvider.Default
    val Main: CoroutineDispatcher get() = dispatcherProvider.Main
    val Unconfined: CoroutineDispatcher get() = dispatcherProvider.Unconfined

}