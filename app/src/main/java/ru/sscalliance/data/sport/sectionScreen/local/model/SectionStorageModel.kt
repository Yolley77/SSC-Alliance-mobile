package ru.sscalliance.data.sport.sectionScreen.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class SectionStorageModel: RealmObject() {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var logo: String = ""
    var description: String = ""
    var address: String = ""
  //  var schedule: List<String> = listOf()
}