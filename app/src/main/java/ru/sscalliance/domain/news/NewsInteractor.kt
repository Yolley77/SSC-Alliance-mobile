package ru.sscalliance.domain.news

import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.IMvpInteractor
import javax.inject.Inject

interface INewsInteractor : IMvpInteractor {
    suspend fun getNews(): List<NewsBusinessModel>
}

class NewsInteractor @Inject constructor(
    private val repository: INewsRepository
) : INewsInteractor, BaseInteractor() {

    override suspend fun getNews(): List<NewsBusinessModel> {
        return repository.getNews()
    }

}
