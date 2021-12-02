package com.example.app.main.core.service

import com.example.app.main.core.manager.DbManager
import com.example.app.solution.dto.room.RoomObject
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableOnSubscribe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleOnSubscribe


abstract class DbRoomService(scheduler: Scheduler?) : AbstractService(scheduler) {
    abstract override val manager: DbManager?

    operator fun get(id: String?): Single<RoomObject> {
        return single(getOnSub(id))
    }

    protected abstract fun getOnSub(id: String?): SingleOnSubscribe<RoomObject?>?
    val list: Single<List<RoomObject>>
        get() = single(listOnSub)
    protected abstract val listOnSub: SingleOnSubscribe<List<RoomObject?>?>?
    val listObservable: Observable<List<RoomObject>>
        get() = observable(listObservableOnSub)
    protected abstract val listObservableOnSub: ObservableOnSubscribe<List<RoomObject?>?>?

    fun insertAndDeleteOld(roomCollection: Collection<RoomObject?>?): Completable {
        return completable(insertAndDeleteOldOnSub(roomCollection))
    }

    protected abstract fun insertAndDeleteOldOnSub(roomCollection: Collection<RoomObject?>?): CompletableOnSubscribe?
}