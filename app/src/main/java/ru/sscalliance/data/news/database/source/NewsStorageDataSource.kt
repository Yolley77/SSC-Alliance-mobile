package ru.sscalliance.data.news.database.source

import ru.sscalliance.data.base.BaseCacheDataSource
import ru.sscalliance.data.news.database.model.NewsStorageModel
import javax.inject.Inject

interface INewsStorageDataSource {

}

class NewsStorageDataSource @Inject constructor(

) : INewsStorageDataSource, BaseCacheDataSource<NewsStorageModel>(NewsStorageModel::class.java) {

}