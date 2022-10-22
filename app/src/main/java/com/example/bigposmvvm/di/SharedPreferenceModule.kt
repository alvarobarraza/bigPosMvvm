package com.example.bigposmvvm.di

import android.content.Context
import android.content.SharedPreferences
import com.example.bigposmvvm.data.sharedPreference.ConfigPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context) = ConfigPreference(context)

}