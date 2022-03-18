package ru.sscalliance.ui.base.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Необходимо для корректной работы unit тестов
 *
 * Использовать вместо оригинального [Dispatchers]
 */
interface IDispatcherProvider {
    val IO: CoroutineDispatcher
    val Main: CoroutineDispatcher
    val Default: CoroutineDispatcher
    val Unconfined: CoroutineDispatcher
}