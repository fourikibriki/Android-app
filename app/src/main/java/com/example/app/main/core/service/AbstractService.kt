package com.example.app.main.core.service

import com.example.app.main.core.manager.AbstractManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleOnSubscribe;

abstract class AbstractService(scheduler: Scheduler) {
    private val scheduler: Scheduler
    abstract val manager: AbstractManager?

    protected fun <T> single(onSub: SingleOnSubscribe<T>?): Single<T> {
        var s: Single<T> = Single.create(onSub)
        s = s.observeOn(AndroidSchedulers.mainThread())
        s = s.subscribeOn(scheduler)
        return s
    }

    protected fun <T> observable(onSub: ObservableOnSubscribe<T>?): Observable<T> {
        var o: Observable<T> = Observable.create(onSub)
        o = o.observeOn(AndroidSchedulers.mainThread())
        o = o.subscribeOn(scheduler)
        return o
    }

    protected fun completable(onSub: CompletableOnSubscribe?): Completable {
        var c: Completable = Completable.create(onSub)
        c = c.observeOn(AndroidSchedulers.mainThread())
        c = c.subscribeOn(scheduler)
        return c
    }

    init {
        this.scheduler = scheduler
    }
}