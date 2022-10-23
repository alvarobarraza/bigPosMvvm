package com.example.bigposmvvm.data

import com.example.bigposmvvm.data.model.AccessLoginM
import com.example.bigposmvvm.data.network.WebService
import com.example.bigposmvvm.domain.repository.BigposRepository
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity.Companion.configServer
import javax.inject.Inject

class BigPosRepositoryImpl @Inject constructor(
    private val api: WebService
) : BigposRepository {

    override suspend fun getLogin(user: String, pass: String): AccessLoginM {
        return api.getLogin("${configServer.ip}/bigserver/login?idMainCompany=${configServer.ep}&user=$user&password=$pass")
    }

}