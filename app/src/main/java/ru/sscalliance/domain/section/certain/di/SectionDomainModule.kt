package ru.sscalliance.domain.section.certain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.sscalliance.data.section.repository.SectionRepository
import ru.sscalliance.domain.section.certain.repository.ISectionRepository

@Module
@InstallIn(FragmentComponent::class)
abstract class SectionDomainModule {

    @Binds
    abstract fun bindSectionRepository(impl: SectionRepository): ISectionRepository

}