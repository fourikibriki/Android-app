package com.example.app.main.core.manager

import android.content.Context
import android.os.HandlerThread
import androidx.annotation.CallSuper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler


abstract class AbstractManager(protected var context: Context) {
    protected var scheduler: Scheduler
    protected open fun init() {}
    fun getScheduler(): Scheduler {
        return scheduler
    }

    @CallSuper
    open fun dispose() {
        scheduler.shutdown()
    }

    init {
        val handlerThread = HandlerThread("manager_thread")
        handlerThread.start()
        scheduler = AndroidSchedulers.from(handlerThread.looper)
        scheduler.scheduleDirect { init() }
    }
}