package com.example.bigposmvvm.data.sharedPreference

import com.example.bigposmvvm.data.model.ConfigM
import com.example.bigposmvvm.data.model.LoginM
import kotlinx.coroutines.flow.Flow

interface Abstract {

    suspend fun getConfig(): Flow<ConfigM>
    suspend fun saveConfig(configM: ConfigM)

    suspend fun getLogin(): Flow<LoginM>
    suspend fun saveLogin(loginM: LoginM)

}