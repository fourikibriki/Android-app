package com.example.app.main.core.service

import com.example.app.main.core.manager.DbManager
import com.example.app.solution.dto.door.DoorObject
import com.example.app.solution.dto.room.RoomObject
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableOnSubscribe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleOnSubscribe


abstract class DbDoorService(scheduler: Scheduler?) : AbstractService(scheduler) {
    abstract override val manager: DbManager?

    operator fun get(id: Long): Single<DoorObject> {
        return single(getOnSub(id))
    }

    protected abstract fun getOnSub(id: Long): SingleOnSubscribe<DoorObject?>?
    val list: Single<List<DoorObject>>
        get() = single(listOnSub)
    protected abstract val listOnSub: SingleOnSubscribe<List<DoorObject?>?>?

    fun getList(room: RoomObject?): Single<List<DoorObject>> {
        return single(getListOnSub(room))
    }

    protected abstract fun getListOnSub(room: RoomObject?): SingleOnSubscribe<List<DoorObject?>?>?
    fun getListObservable(room: RoomObject?): Observable<List<DoorObject>> {
        return observable(getListObservableOnSub(room))
    }

    protected abstract fun getListObservableOnSub(room: RoomObject?): ObservableOnSubscribe<List<DoorObject?>?>?
    fun insertAndDeleteOld(doorCollection: Collection<DoorObject?>?): Completable {
        return completable(insertAndDeleteOldOnSub(doorCollection))
    }

    protected abstract fun insertAndDeleteOldOnSub(doorCollection: Collection<DoorObject?>?): CompletableOnSubscribe?
    fun changeFavorites(id: Long): Single<Boolean> {
        return single(changeFavoritesOnSub(id))
    }

    protected abstract fun changeFavoritesOnSub(id: Long): SingleOnSubscribe<Boolean?>?
    fun changeName(id: Long, name: String?): Completable {
        return completable(changeNameOnSub(id, name))
    }

    protected abstract fun changeNameOnSub(id: Long, name: String?): CompletableOnSubscribe?
}