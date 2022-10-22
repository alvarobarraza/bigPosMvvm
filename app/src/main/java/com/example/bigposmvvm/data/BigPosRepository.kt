package com.example.bigposmvvm.data

import com.example.bigposmvvm.data.database.dao.BigPosDao
import com.example.bigposmvvm.data.database.entities.M_USER
import com.example.bigposmvvm.domain.model.AccessLogin
import com.example.bigposmvvm.data.network.BigPosService
import com.example.bigposmvvm.domain.model.toDomain
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity.Companion.user
import javax.inject.Inject

class BigPosRepository @Inject constructor(
    private val api: BigPosService,
    private val bigPosDao: BigPosDao
) {

    suspend fun getLogin(): AccessLogin? {
        val response = api.getLogin()
        println(response)
        return response!!.toDomain()
    }

    fun getUser(): AccessLogin {
        val response = bigPosDao.getUser(user)
        return response.toDomain()
    }

    suspend fun insertUser(user: M_USER){
        bigPosDao.insertUser(user)
    }

}