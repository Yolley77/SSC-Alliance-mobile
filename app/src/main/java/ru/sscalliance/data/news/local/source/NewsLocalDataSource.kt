package ru.sscalliance.data.news.local.source

import ru.sscalliance.data.base.BaseCacheDataSource
import ru.sscalliance.data.news.local.model.NewsStorageModel
import javax.inject.Inject

interface INewsLocalDataSource {

}

class NewsLocalDataSource @Inject constructor(

) : INewsLocalDataSource, BaseCacheDataSource<NewsStorageModel>(NewsStorageModel::class.java) {

}