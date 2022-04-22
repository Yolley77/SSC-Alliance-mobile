package ru.sscalliance.data.team.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class TeamStorageModel: RealmObject() {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var logo: String = ""
   // var trainingGallery: List<String> = listOf()
  //  var trainingSchedule: List<String> = listOf()
    var trainingAddress: String = ""
    var history: String = ""
}