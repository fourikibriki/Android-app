package Moduls

import io.realm.RealmList;
import io.realm.RealmModel;


class Rooms : RealmModel {
    var list: RealmList<String>? = null

    constructor(list: RealmList<String>?) {
        this.list = list
    }

    constructor() {}
}