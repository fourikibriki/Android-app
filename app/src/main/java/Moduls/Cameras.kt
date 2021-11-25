package Moduls

import io.realm.annotations.PrimaryKey;
import io.realm.RealmModel;
import io.realm.Realm
import io.realm.RealmConfiguration



class Cameras: RealmModel {
    var  ID :PrimaryKey = ""
    var name: String = ""
    var room: String = ""
    var snapshot: String = ""
    var favorites: Boolean = ""
    var rec: Boolean = ""

    fun Camera() {}
    fun Camera(id: Long) {
        id = id
    }


 fun getId(id: Long) : {
     return id
    }
    fun setId(id: Long) {
        id = id
    }
    fun getName(): String? {
        return name
    }
    fun setName(name: String?) {
        this.name = name!!
    }

    fun getSnapshot(): String? {
        return snapshot
    }
    fun setSnapshot(snapshot: String?) {
        this.snapshot = snapshot!!
    }

    fun getRoom(): String? {
        return room
    }
    fun setRoom(room: String?) {
        this.room = room!!
    }

    fun getFavorites(): Boolean {
        return favorites
    }
    fun setFavorites(favorites: Boolean) {
        this.favorites = favorites
    }

    fun getRec(): Boolean {
        return rec
    }
    fun setRec(rec: Boolean) {
        this.rec = rec
    }
}



