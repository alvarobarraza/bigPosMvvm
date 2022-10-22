package com.example.bigposmvvm.data.network

import com.example.bigposmvvm.data.model.AccessLoginM
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity.Companion.configServer
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity.Companion.pass
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity.Companion.user
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BigPosService @Inject constructor(
    private val api: WebService,
) {

    suspend fun getLogin(): AccessLoginM {
        return withContext(Dispatchers.IO) {
            val response = api.getLogin("login?idMainCompany=${configServer.ep}&user=$user&password=$pass")
            response.body()!!
        }
    }

}