package ru.sscalliance.domain.sport.sectionScreen.certain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.sport.sectionScreen.repository.SectionRepository
import ru.sscalliance.domain.sport.sectionScreen.certain.repository.ISectionRepository

@Module
@InstallIn(FragmentComponent::class)
abstract class SectionDomainModule {

    @Binds
    abstract fun bindSectionRepository(impl: SectionRepository): ISectionRepository

}