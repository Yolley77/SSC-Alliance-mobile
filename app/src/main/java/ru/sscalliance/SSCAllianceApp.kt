package ru.sscalliance

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm

/**
 * В проекте используется паттерн проектирования MVP с подходом Clean Architecture.
 * Presentation Layer содержится в package ui, он включает View's & Presenter's. Отвечает за UI.
 * Domain Layer находится в одноимённой package и содержит Business Objects, используемые
 * во всём приложении в качестве моделей данных, за исключением слоя Data.
 * Также здесь находятся Interactor's для взаимодействия с Presentation Layer
 * и интерфейсы Repository's, для взаимодействия с Data Layer.
 * Data Layer содержит в себе классы для взаимодействия с сетью и локальной БД, а также
 * модели данных, необходимые для их работы.
 */

@HiltAndroidApp
class SSCAllianceApp : MultiDexApplication() {

    companion object {

    }

    override fun onCreate() {
        super.onCreate()
    }
}