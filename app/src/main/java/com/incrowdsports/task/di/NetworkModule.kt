package com.incrowdsports.task.di

import com.incrowdsports.task.data.FixtureService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(HttpUrl.get("https://feeds.incrowdsports.com/provider/opta/football/v1/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideCryptoCoroutinesApi(retrofit: Retrofit): FixtureService {
        return retrofit.create()
    }
}