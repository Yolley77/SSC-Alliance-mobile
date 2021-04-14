package ru.sscalliance.ui.section.certain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.domain.section.certain.interactor.ISectionInteractor
import ru.sscalliance.domain.section.certain.interactor.SectionInteractor
import ru.sscalliance.ui.section.certain.presentation.presenter.ISectionPresenter
import ru.sscalliance.ui.section.certain.presentation.presenter.SectionPresenter
import ru.sscalliance.ui.section.certain.presentation.view.ISectionFragment

@Module
@InstallIn(FragmentComponent::class)
abstract class SectionModule {

    @Binds
    abstract fun bindSectionInteractor(impl: SectionInteractor): ISectionInteractor

    @Binds
    abstract fun bindSectionPresenter(impl: SectionPresenter<ISectionFragment, ISectionInteractor>)
            : ISectionPresenter<ISectionFragment, ISectionInteractor>

}