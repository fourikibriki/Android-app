package com.example.app.main.core.service

import com.example.app.main.core.manager.DbManager
import com.example.app.solution.dto.camera.CameraObject
import com.example.app.solution.dto.room.RoomObject
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableOnSubscribe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleOnSubscribe


abstract class DbCameraService(scheduler: Scheduler?) : AbstractService(scheduler) {
    abstract override val manager: DbManager?

    operator fun get(id: Long): Single<CameraObject> {
        return single(getOnSub(id))
    }

    protected abstract fun getOnSub(id: Long): SingleOnSubscribe<CameraObject?>?
    val list: Single<List<CameraObject>>
        get() = single(listOnSub)
    protected abstract val listOnSub: SingleOnSubscribe<List<CameraObject?>?>?

    fun getList(room: RoomObject?): Single<List<CameraObject>> {
        return single(getListOnSub(room))
    }

    protected abstract fun getListOnSub(room: RoomObject?): SingleOnSubscribe<List<CameraObject?>?>?
    fun getListObservable(room: RoomObject?): Observable<List<CameraObject>> {
        return observable(getListObservableOnSub(room))
    }

    protected abstract fun getListObservableOnSub(room: RoomObject?): ObservableOnSubscribe<List<CameraObject?>?>?
    fun insertAndDeleteOld(cameraCollection: Collection<CameraObject?>?): Completable {
        return completable(insertAndDeleteOldOnSub(cameraCollection))
    }

    protected abstract fun insertAndDeleteOldOnSub(cameraCollection: Collection<CameraObject?>?): CompletableOnSubscribe?
    fun changeFavorites(id: Long): Single<Boolean> {
        return single(changeFavoritesOnSub(id))
    }

    protected abstract fun changeFavoritesOnSub(id: Long): SingleOnSubscribe<Boolean?>?
}