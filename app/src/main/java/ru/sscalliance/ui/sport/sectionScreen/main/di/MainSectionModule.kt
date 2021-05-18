package ru.sscalliance.ui.sport.sectionScreen.main.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sscalliance.domain.sport.sectionScreen.main.interactor.IMainSectionInteractor
import ru.sscalliance.domain.sport.sectionScreen.main.interactor.MainSectionInteractor
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.presenter.IMainSectionPresenter
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.presenter.MainSectionPresenter
import ru.sscalliance.ui.sport.sectionScreen.main.presentation.view.IMainSectionActivity

@Module
@InstallIn(ActivityComponent::class)
abstract class MainSectionModule {

    @Binds
    abstract fun bindMainSectionInteractor(impl: MainSectionInteractor): IMainSectionInteractor

    @Binds
    abstract fun bindMainSectionPresenter(impl: MainSectionPresenter<IMainSectionActivity, IMainSectionInteractor>)
            : IMainSectionPresenter<IMainSectionActivity, IMainSectionInteractor>

}