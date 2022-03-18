package ru.sscalliance.ui.base.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherProvider : IDispatcherProvider {
    override val IO: CoroutineDispatcher
        get() = Dispatchers.IO
    override val Main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val Default: CoroutineDispatcher
        get() = Dispatchers.Default
    override val Unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined

}