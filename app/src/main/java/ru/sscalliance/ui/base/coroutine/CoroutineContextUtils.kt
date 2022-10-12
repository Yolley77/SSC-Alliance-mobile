package ru.sscalliance.ui.base.coroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Создание CoroutineContext в главном потоке с обработкой ошибок
 */
inline fun MainCoroutineContext(
    job: Job,
    crossinline handleError: (Throwable) -> Unit
): CoroutineContext =
    job + Dispatcher.Main + CoroutineExceptionHandler { throwable ->
        if (throwable !is CancellationException) handleError.invoke(throwable)
    }


/**
 * Для обработки кастомных ошибок при запуске корутин
 *
 * Для уменьшения кода, пример
 * launch(CoroutineExceptionHandler(Logger::error))
 */
inline fun CoroutineExceptionHandler(crossinline handler: (Throwable) -> Unit): CoroutineExceptionHandler =
    CoroutineExceptionHandler { _, throwable ->
        if (throwable !is CancellationException) handler.invoke(
            throwable
        )
    }

