package com.example.bigposmvvm.di

import com.example.bigposmvvm.data.BigPosRepositoryImpl
import com.example.bigposmvvm.data.network.WebService
import com.example.bigposmvvm.domain.repository.BigposRepository
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

    @Singleton
    @Provides
    fun provideBigPosApi(): WebService {
        return Retrofit.Builder()
            .baseUrl("http://bigpos.ddns.net:1106")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebService::class.java)
    }

    @Singleton
    @Provides
    fun provideBigPosRepository(api: WebService): BigposRepository {
        return BigPosRepositoryImpl(api = api)
    }

}