package com.example.app.main.core.manager

import android.content.Context
import com.example.app.main.core.service.NetworkService


abstract class NetworkManager(context: Context?) :
    AbstractManager(context!!) {
    abstract val service: NetworkService?
}
