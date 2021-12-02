package com.example.app.main.core

import com.example.app.main.core.manager.DbManager
import com.example.app.main.core.manager.NetworkManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable


abstract class AbstractViewModel {
    protected var networkManager: NetworkManager? = null
    protected var dbManager: DbManager? = null
    protected var disposables: CompositeDisposable = CompositeDisposable()
    fun disposeAll() {
        networkManager.dispose()
        dbManager.dispose()
        disposables.dispose()
    }
}