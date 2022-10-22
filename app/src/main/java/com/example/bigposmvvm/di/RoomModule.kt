package com.example.bigposmvvm.di

import android.content.Context
import androidx.room.Room
import com.example.bigposmvvm.data.database.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val nameDataBase = "BigPosDataBase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, nameDataBase).build()

    @Singleton
    @Provides
    fun provideBigPosDao(db: AppDataBase) = db.BdBigpos()

}