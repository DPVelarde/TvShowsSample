package com.daniel.framework.di

import com.daniel.framework.data.TvShowsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    private const val BASE_URL = "https://api.tvmaze.com/"

    @Singleton
    @Provides
    internal fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Singleton
    @Provides
    internal fun provideRetrofit(
        converter: Converter.Factory
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converter)
            .build()
    }

    @Singleton
    @Provides
    internal fun provideTvShowsApi(
        retrofit: Retrofit
    ): TvShowsApi = retrofit.create(TvShowsApi::class.java)
}