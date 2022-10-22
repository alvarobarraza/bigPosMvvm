package com.example.bigposmvvm.data.network


import com.example.bigposmvvm.data.model.AccessLoginM
import com.example.bigposmvvm.ui.view.activity.access.LoginActivity.Companion.configServer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface WebService {

    @GET("login")
    suspend fun getLogin(
        @Query("idMainCompany") configServer: String,
        @Query("user") user: String,
        @Query("password") pass: String
    ): AccessLoginM

}