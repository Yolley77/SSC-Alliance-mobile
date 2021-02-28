package ru.sscalliance.domain.news.interactor

import ru.sscalliance.data.base.preferences.PreferencesHelper
import ru.sscalliance.domain.base.BaseInteractor
import ru.sscalliance.domain.base.MvpInteractor
import javax.inject.Inject

interface INewsInteractor: MvpInteractor {

}

class NewsInteractor @Inject constructor(
    preferencesHelper: PreferencesHelper
): INewsInteractor, BaseInteractor() {

}