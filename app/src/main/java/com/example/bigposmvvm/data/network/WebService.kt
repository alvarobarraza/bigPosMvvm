package com.example.bigposmvvm.data.network


import com.example.bigposmvvm.data.model.AccessLoginM
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface WebService {

    @GET
    suspend fun getLogin(@Url url:String): Response<AccessLoginM?>

}