package ru.sscalliance.data.news.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NewsStorageModel: RealmObject() {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var image: String = ""
    var publicationDate: String = ""
    var tag: String = ""
}