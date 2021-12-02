package com.example.app.main.core.manager

import android.content.Context
import com.example.app.main.core.manager.AbstractManager
import com.example.app.main.core.service.DbCameraService
import com.example.app.main.core.service.DbDoorService
import com.example.app.main.core.service.DbRoomService


abstract class DbManager (context: Context?) : AbstractManager(context!!) {
    abstract val cameraService: DbCameraService?
    abstract val roomService: DbRoomService?
    abstract val doorService: DbDoorService?
}
