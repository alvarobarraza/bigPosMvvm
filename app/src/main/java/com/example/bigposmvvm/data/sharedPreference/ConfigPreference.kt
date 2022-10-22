package com.example.bigposmvvm.data.sharedPreference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.bigposmvvm.data.model.ConfigM
import com.example.bigposmvvm.data.model.LoginM
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

const val DataStore_Config = "CONFIG"

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DataStore_Config)

class ConfigPreference @Inject constructor(private val context: Context) : Abstract {

    private val ip = stringPreferencesKey("ip")
    private val ep = stringPreferencesKey("ep")
    private val es = stringPreferencesKey("es")
    private val user = stringPreferencesKey("user")
    private val name = stringPreferencesKey("name")
    private val pass = stringPreferencesKey("pass")
    private val group = intPreferencesKey("group")
    private val checked = booleanPreferencesKey("checked")

    override suspend fun getConfig() = context.datastore.data.map { config ->
        ConfigM(
            ip = config[ip]!!,
            ep = config[ep]!!,
            es = config[es]!!
        )
    }

    override suspend fun saveConfig(configM: ConfigM) {
        context.datastore.edit { config ->
            config[ip] = configM.ip
            config[ep] = configM.ep
            config[es] = configM.es
        }
    }

    override suspend fun getLogin() = context.datastore.data.map { login->
        LoginM(
            user = login[user]!!,
            name = login[name]!!,
            pass = login[pass]!!,
            group = login[group]!!,
            checked = login[checked]!!
        )
    }

    override suspend fun saveLogin(loginM: LoginM) {
        context.datastore.edit { login->
            login[user] = loginM.user
            login[name] = loginM.name
            login[pass] = loginM.pass
            login[group] = loginM.group
            login[checked] = loginM.checked
        }
    }


}