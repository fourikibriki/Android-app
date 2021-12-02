package com.example.app.main.core.service

import com.example.app.main.core.manager.NetworkManager
import com.example.app.solution.dto.door.DoorObject
import com.example.app.solution.dto.network.data.DataObject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleOnSubscribe


abstract class NetworkService(scheduler: Scheduler?) : AbstractService(scheduler) {
    abstract override val manager: NetworkManager?
    val cameras: Single<DataObject>
        get() = single(camerasOnSub)
    protected abstract val camerasOnSub: SingleOnSubscribe<DataObject?>?
    val doors: Single<List<DoorObject>>
        get() = single(doorsOnSub)
    protected abstract val doorsOnSub: SingleOnSubscribe<List<DoorObject?>?>?
}