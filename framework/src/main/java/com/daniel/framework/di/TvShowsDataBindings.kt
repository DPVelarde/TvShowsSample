package com.daniel.framework.di

import com.daniel.data.TvShowsRemoteSource
import com.daniel.data.TvShowsRepository
import com.daniel.framework.data.TvShowsMazeSource
import com.daniel.framework.data.TvShowsRepositoryDefault
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class TvShowsDataBindings {

    @Binds
    internal abstract fun bindRemoteSource(source: TvShowsMazeSource): TvShowsRemoteSource

    @Binds
    internal abstract fun bindRepository(source: TvShowsRepositoryDefault): TvShowsRepository
}