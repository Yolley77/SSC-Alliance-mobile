package ru.sscalliance.data.base

import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults

open class BaseCacheDataSource<T : RealmObject>(var clazz: Class<T>) {

    fun selectAllResults(): RealmResults<T> = Realm.getDefaultInstance().where(clazz).findAll()

    fun selectLastResult(): T? = Realm.getDefaultInstance().where(clazz).findAll().last()

    fun insertOrUpdate(list: List<T>) = withRealmTransaction { realm -> realm.insertOrUpdate(list) }

    fun insertOrUpdate(item: T) = withRealmTransaction { realm -> realm.insertOrUpdate(item) }

    fun clearTable() = withRealmTransaction { it.where(clazz).findAll().deleteAllFromRealm() }

    fun getById(id: String, fieldNameId: String = "id"): T? =
        Realm.getDefaultInstance().where(clazz).equalTo(fieldNameId, id).findFirst()

    private fun <T> withRealmTransaction(procedure: (realm: Realm) -> T): T {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val result = procedure(realm)
        realm.commitTransaction()
        return result
    }

}