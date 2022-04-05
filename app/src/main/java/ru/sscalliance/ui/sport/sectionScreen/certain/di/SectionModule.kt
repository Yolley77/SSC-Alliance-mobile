package ru.sscalliance.ui.sport.sectionScreen.certain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.sport.sectionScreen.certain.interactor.ISectionInteractor
import ru.sscalliance.domain.sport.sectionScreen.certain.interactor.SectionInteractor
import ru.sscalliance.ui.sport.sectionScreen.certain.presentation.ISectionPresenter
import ru.sscalliance.ui.sport.sectionScreen.certain.presentation.SectionPresenter
import ru.sscalliance.ui.sport.sectionScreen.certain.presentation.ISectionFragment

@Module
@InstallIn(FragmentComponent::class)
abstract class SectionModule {

    @Binds
    abstract fun bindSectionInteractor(impl: SectionInteractor): ISectionInteractor

    @Binds
    abstract fun bindSectionPresenter(impl: SectionPresenter<ISectionFragment>)
            : ISectionPresenter<ISectionFragment>

}