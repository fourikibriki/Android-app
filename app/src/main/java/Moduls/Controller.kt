package Moduls

import android.content.Context;
import android.util.Log;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;

class Controller {

    private var realm: Realm? = null

    fun Init(context: Context?) {
        Realm.init(context)
        val config = RealmConfiguration.Builder()
            .allowQueriesOnUiThread(false)
            .allowWritesOnUiThread(false)
            .build()
        realm = Realm.getInstance(config)
    }
    fun putCameras(camerasList: List<Cameras?>?) {
        realm!!.executeTransaction { _realm: Realm ->
            _realm.delete(Cameras::class.java)
            _realm.insert(camerasList)
        }
    }
    fun getCameras(room: String?): RealmResults<Cameras?>? {
        realm!!.beginTransaction()
        val cameras: RealmResults<Cameras?> =
            realm!!.where(Cameras::class.java).equalTo("room", room).findAll()
        realm!!.commitTransaction()
        return cameras
    }

    fun putRooms(list: List<String>) {
        Log.d("Flow", "LocalManager::putRooms")
        val roomsList = RealmList(*list.toTypedArray())
        realm!!.beginTransaction()
        rooms = realm!!.where(Rooms::class.java).findFirst()


        if (rooms == null) realm!!.insertOrUpdate(Rooms(roomsList)) else rooms.setList(roomsList)
        realm!!.commitTransaction()
    }
    fun getRooms(): Rooms? {
        if (rooms == null) {
            realm!!.beginTransaction()
            rooms = realm!!.where(Rooms::class.java).findFirst()
            realm!!.commitTransaction()
        }
        return rooms
    }
}
