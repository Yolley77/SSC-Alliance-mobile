package ru.sscalliance.data.sport.eventScreen.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class EventStorageModel: RealmObject() {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var description: String = ""
 //   var docs: List<String> = listOf()
    var address: String = ""
    var eventDate: String = ""
   // var startTime: Double = 0.0
}