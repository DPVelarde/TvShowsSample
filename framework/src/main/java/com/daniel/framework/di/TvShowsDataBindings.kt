package com.daniel.framework.di

import com.daniel.data.TvShowsRemoteSource
import com.daniel.framework.data.TvShowsMazeSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class TvShowsDataBindings {

    @Binds
    internal abstract fun bindRemoteSource(source: TvShowsMazeSource): TvShowsRemoteSource
}