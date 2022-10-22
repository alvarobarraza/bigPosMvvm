package com.example.bigposmvvm.domain.repository

import com.example.bigposmvvm.data.model.AccessLoginM

interface BigposRepository {

    suspend fun getLogin(user:String, pass:String): AccessLoginM

}