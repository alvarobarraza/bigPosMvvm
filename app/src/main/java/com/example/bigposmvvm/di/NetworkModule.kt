package com.example.bigposmvvm.di

import com.example.bigposmvvm.data.network.WebService
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity.Companion.configServer
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    var gson = GsonBuilder()
        .setLenient()
        .create()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("${configServer.ip}/bigserver/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

}