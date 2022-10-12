package ru.sscalliance.ui.base.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class CommonCoroutineScope : CoroutineScope {

    private val job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext = MainCoroutineContext(job, ::errorHandler)

    open fun errorHandler(throwable: Throwable) {
        //Logger.error(throwable)
    }

    /*override fun onCleared() {
        job.cancel()
    }*/

}