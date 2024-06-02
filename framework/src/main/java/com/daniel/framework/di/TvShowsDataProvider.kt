package com.daniel.framework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object TvShowsDataProvider {
    @Provides
    internal fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}